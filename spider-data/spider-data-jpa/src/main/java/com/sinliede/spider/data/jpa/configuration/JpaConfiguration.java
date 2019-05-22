package com.sinliede.spider.data.jpa.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author sinliede
 *
 * @date 19-5-8 下午5:39
 * @desc
 */
@Configuration
@EntityScan("com.sinliede.spider.core.jpa.domain")
@EnableJpaRepositories(basePackages = "com.sinliede.spider.core.jpa.repository")
@EnableTransactionManagement
public class JpaConfiguration {
}
