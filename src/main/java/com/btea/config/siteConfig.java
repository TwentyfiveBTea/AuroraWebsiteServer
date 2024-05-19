package com.btea.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/05/17 21:37
 * @Description: 官网配置类
 */

@Configuration
@Getter
@ConfigurationProperties(prefix = "site")
public class siteConfig {
    /**
     * 文件存放目录，需要在配置文件自行设置
     * 注意：无默认值
     */
    private static String filePath;

    /**
     * 面向访问者的hostIp地址,用于文件链接创建
     * 默认值：120.24.88.212
     */
    private static String publicHost;

    @Value("${site.filePath}")
    public void setFilePath(String filePath) {
        siteConfig.filePath = filePath;
    }

    @Value("${site.public-host:120.24.88.212}")
    public void setPublicHost(String publicHost) {
        siteConfig.publicHost = publicHost;
    }

}
