package indi.w4xj.eureka_provider_00_standalone_8000.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.eureka_provider_00_standalone_8000.controller
 * @Classname ProviderController
 * @Description TODO
 * @Date 2021/6/1 22:21
 * @Created by IntelliJ IDEA
 */
@RestController()
public class ProviderController {

    @Autowired
    private DiscoveryClient client;

    @GetMapping("/provider/discovery")
    public Object discovery(){
        List<String> list = client.getServices();
        System.out.println("service list:" + list);
        List<ServiceInstance> srvList = client.getInstances("provider");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.client;

    }
}
