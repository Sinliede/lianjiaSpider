package com.sinliede.spider.core.resolver;

/**
 * @author sinliede
 * @date 19-5-13 下午4:01
 * @since 0.1.0
 */
public interface IResolver<T> {

    T resolve(String httpResult);
}
