package indi.w4xj.eureka_consumer_00_standalone_9000.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.eureka_consumer_00_standalone_9000.config
 * @Classname BeanConfig
 * @Description TODO
 * @Date 2021/6/1 22:12
 * @Created by IntelliJ IDEA
 */
@Configuration
public class BeanConfig {

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
