package indi.w4xj.eureka_server_cluster_7003;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerCluster7003Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerCluster7003Application.class, args);
    }

}
