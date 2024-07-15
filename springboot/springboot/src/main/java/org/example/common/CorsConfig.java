package org.example.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration =new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");//1设置访问源地址
        corsConfiguration.addAllowedHeader("*");//2设置访问源请求头
        corsConfiguration.addAllowedMethod("*");//3设置访问源请求方法
        source.registerCorsConfiguration("/**",corsConfiguration);//4对接口配置跨域设置
        return new CorsFilter(source);
    }
}
