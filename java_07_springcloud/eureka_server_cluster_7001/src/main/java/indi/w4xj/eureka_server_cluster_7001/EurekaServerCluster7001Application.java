package indi.w4xj.eureka_server_cluster_7001;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerCluster7001Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerCluster7001Application.class, args);
    }

}
