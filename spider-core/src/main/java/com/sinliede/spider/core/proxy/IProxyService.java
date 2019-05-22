package com.sinliede.spider.core.proxy;

/**
 * 使用随机的代理ip进行访问,防止ip被锁
 * @author sinliede
 * @date 19-5-15 上午10:54
 * @since 0.1.0
 */
public interface IProxyService {

    /**
     * 获取可用的代理ip
     * @return
     */
    IpProxy getProxy();
}
