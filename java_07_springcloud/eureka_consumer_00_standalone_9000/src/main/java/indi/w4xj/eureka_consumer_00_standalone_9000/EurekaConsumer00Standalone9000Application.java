package indi.w4xj.eureka_consumer_00_standalone_9000;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EurekaConsumer00Standalone9000Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumer00Standalone9000Application.class, args);
    }

}
