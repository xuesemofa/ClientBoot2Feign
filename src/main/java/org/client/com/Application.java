package org.client.com;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.client.com.server.AccountInterface;
import org.client.com.server.CustomerInterface;
import org.client.com.server.TokenInterface;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * Spring Boot 应用启动类
 * <p>
 * Created by bysocket on 16/4/26.
 */
@SpringBootApplication
public class Application {
//        extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public AccountInterface anInterface() {
        AccountInterface accountInterface = Feign.builder().encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(AccountInterface.class, "http://39.106.33.113:9002/account");
        return accountInterface;
    }

    @Bean
    public TokenInterface tokenInterface() {
        TokenInterface tkInterface = Feign.builder().encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(TokenInterface.class, "http://39.106.33.113:9002/account");
        return tkInterface;
    }

    @Bean
    public CustomerInterface customerInterface() {
        CustomerInterface interfaces = Feign.builder().encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(CustomerInterface.class, "http://39.106.33.113:9002/customer");
        return interfaces;
    }

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); // 允许cookies跨域
        config.addAllowedOrigin("*");// 允许向该服务器提交请求的URI，*表示全部允许。。这里尽量限制来源域，比如http://xxxx:8080 ,以降低安全风险。。
        config.addAllowedHeader("*");// 允许访问的头信息,*表示全部
        config.setMaxAge(18000L);// 预检请求的缓存时间（秒），即在这个时间段里，对于相同的跨域请求不会再预检了
        config.addAllowedMethod("*");// 允许提交请求的方法，*表示全部允许，也可以单独设置GET、PUT等
    /*    config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");// 允许Get的请求方法
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");*/
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

    // war
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder
//                                                         builder) {
//        // TODO Auto-generated method stub
//        return builder.sources(Application.class);
//    }

}
