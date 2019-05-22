package com.sinliede.spider.core.http;

import com.alibaba.fastjson.JSONObject;
import com.sinliede.spider.core.constant.ConstantFields;
import com.sinliede.spider.core.proxy.IpProxy;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author sinliede
 * @date 19-5-13 下午4:15
 * @since 0.1.0
 */
public class HttpRequest {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpRequest.class);

    private String host;

    private String ipAddress;

    private CloseableHttpClient httpClient;

    public HttpRequest(String host, String ipAddress) {
        this.host = host;
        this.ipAddress = ipAddress;
        init();
    }

    void init() {
        {
            LayeredConnectionSocketFactory sslsf = null;
            try {
                X509TrustManager x509mgr = new X509TrustManager() {
                    @Override
                    public void checkClientTrusted(X509Certificate[] xcs, String string) {
                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] xcs, String string) {
                    }

                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                };
                SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustSelfSignedStrategy()).build();
                sslContext.init(null, new TrustManager[]{x509mgr}, null);
                sslsf = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);

                String[] ipStrings = ipAddress.split(ConstantFields.NODE);
                byte [] byteAddress = new byte[ipStrings.length];
                for (int i = 0; i < ipStrings.length; i++)
                    byteAddress[i] = Byte.parseByte(ipStrings[i]);
                HttpClientContext clientContext = HttpClientContext.create();
                InetSocketAddress remoteAddress = new InetSocketAddress(InetAddress.getByAddress(byteAddress), 80);
                sslsf.connectSocket(1000, sslsf.createSocket(clientContext), new HttpHost(host), remoteAddress, null, clientContext);
            } catch (Exception e) {
                LOGGER.info("创建SSL连接失败", e);
            }


            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("https", sslsf)
                    .register("http", PlainConnectionSocketFactory.getSocketFactory())
                    .build();


            PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
            connectionManager.setMaxTotal(200);
            connectionManager.setDefaultMaxPerRoute(20);

            httpClient = HttpClients.custom()
                    .setConnectionManager(connectionManager)
                    .build();
        }
    }

    public String get(String url, IpProxy proxy, Header... headers) {

        CloseableHttpResponse httpResponse = null;
        String response = null;
        try {
            RequestConfig requestConfig = RequestConfig.custom()
                    .setProxy(new HttpHost(proxy.getIp(), proxy.getPort()))
                    .build();
            HttpGet httpGet = new HttpGet(url);
            httpGet.setConfig(requestConfig);
            if (null != headers)
                for (Header header : headers)
                    httpGet.addHeader(header);
            httpResponse = httpClient.execute(httpGet);
            response = getResponseWithHttpCode(httpResponse);
        } catch (IOException e) {
            LOGGER.error("请求{}失败", url, e);
        } finally {
            if (httpResponse != null) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    LOGGER.error("关闭response失败", e);
                }
            }
        }
        return response;
    }

    public String postJson(String url, IpProxy proxy, Object params, Header... headers) {
        StringEntity entity = new StringEntity(JSONObject.toJSONString(params), ConstantFields.CHARSET_UTF8);
        entity.setContentEncoding(ConstantFields.CHARSET_UTF8.name());
        entity.setContentType("application/json");
        return post(url, proxy, entity, headers);
    }

    public String postEntity(String url, IpProxy proxy, Map<String, Object> params, Header... headers) {
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        params.forEach((key, value) -> nameValuePairs.add(new BasicNameValuePair(key, value.toString())));
        return post(url, proxy, new UrlEncodedFormEntity(nameValuePairs, ConstantFields.CHARSET_UTF8), headers);
    }

    private String post(String url, IpProxy proxy, HttpEntity entity, Header... headers) {
        CloseableHttpResponse httpResponse = null;
        String response = null;
        try {
            RequestConfig requestConfig = RequestConfig.custom()
                    .setProxy(new HttpHost(proxy.getIp(), proxy.getPort()))
                    .build();
            HttpPost httpPost = new HttpPost(url);
            httpPost.setConfig(requestConfig);
            if (headers != null)
                for (Header header : headers)
                    httpPost.addHeader(header);
            httpPost.setEntity(entity);
            httpResponse = httpClient.execute(httpPost);
            response = getResponseWithHttpCode(httpResponse);
        } catch (IOException e) {
            LOGGER.error("请求{}失败", url, e);
        } finally {
            if (httpResponse != null) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    LOGGER.error("关闭response失败", e);
                }
            }
        }
        return response;
    }


    private String getResponseWithHttpCode(CloseableHttpResponse httpResponse) throws IOException {

        HttpEntity entity = httpResponse.getEntity();
        if (null != entity) {
            String response = EntityUtils.toString(entity);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            LOGGER.info("当前请求返回码: {}", statusCode);
            return response;
        }
        return null;
    }

}
