package com.btea.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;

/**
 * @Author: TwentyFiveBTea
 * @Date: 2024/05/22 17:13
 * @Description: 拦截器配置类
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Bean
    public AuthInterceptor authInterceptor() {
        return new AuthInterceptor();
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        // 放行路径
//        ArrayList<String> patterns = new ArrayList<>();
//        patterns.add("/home/**");
//        patterns.add("/about/**");
//        patterns.add("/join");
//        patterns.add("/settings");
//        patterns.add("/settings/roster");
//        patterns.add("/settings/login");
//
//        registry.addInterceptor(authInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns(patterns);
//    }
}
