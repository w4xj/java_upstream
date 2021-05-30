package indi.w4xj.eureka_server_00_standalone_7000;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServer00Standalone7000Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer00Standalone7000Application.class, args);
    }

}
