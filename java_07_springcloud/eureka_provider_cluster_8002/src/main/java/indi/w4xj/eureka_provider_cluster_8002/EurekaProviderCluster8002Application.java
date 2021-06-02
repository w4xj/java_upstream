package indi.w4xj.eureka_provider_cluster_8002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EurekaProviderCluster8002Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaProviderCluster8002Application.class, args);
    }

}
