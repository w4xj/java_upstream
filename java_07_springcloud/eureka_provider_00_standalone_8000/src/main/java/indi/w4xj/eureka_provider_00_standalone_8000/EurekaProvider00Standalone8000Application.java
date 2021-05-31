package indi.w4xj.eureka_provider_00_standalone_8000;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EurekaProvider00Standalone8000Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaProvider00Standalone8000Application.class, args);
    }

}
