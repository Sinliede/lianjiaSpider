package com.sinliede.spider.core.http;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author sinliede
 * @date 19-5-14 下午2:00
 * @since
 */
public class InetAddressUtil {

    public static String getIpByHost(String host) {
        try {
            InetAddress netAddress = InetAddress.getByName(host);
            return netAddress.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }
}
