package com.sinliede.spider.core.proxy;

import java.io.Serializable;

/**
 * @author sinliede
 * @date 19-5-16 下午3:27
 * @since
 */
public class IpProxy implements Serializable {
    private static final long serialVersionUID = -3521423751538365183L;

    private String ip;

    private int port;

    public IpProxy(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public IpProxy setIp(String ip) {
        this.ip = ip;
        return this;
    }

    public int getPort() {
        return port;
    }

    public IpProxy setPort(int port) {
        this.port = port;
        return this;
    }
}
