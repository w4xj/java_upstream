package indi.w4xj.eureka_consumer_00_standalone_9000.controller;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.eureka_consumer_00_standalone_9000.controller
 * @Classname ConsumerController
 * @Description 
 * @Date 2021/6/1 22:16
 * @Created by IntelliJ IDEA
 */
@RestController()
@RequestMapping("/consumer")
public class ConsumerController {

    private DiscoveryClient client;
    private static final String REST_URL_PREFIX = "http://localhost:8000";
    private final RestTemplate restTemplate;

    @Autowired
    public ConsumerController(DiscoveryClient client, RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.client = client;
    }

    /**
     * 直接通过RestTemplate访问URL
     * @return
     */
    @RequestMapping(value = "/getByUrl")
    public Object getByUrl(){
        return restTemplate.getForObject(REST_URL_PREFIX + "/provider/discovery", Object.class);
    }

    /**
     * 通过Eureka的DiscoveryClient获取服务列表
     * @return
     */
    @RequestMapping(value = "/getDiscoveryClient")
    public Object getDiscoveryClient(){
        List<String> list = client.getServices();
        System.out.println("service list:" + list);
        List<ServiceInstance> serviceInstances = client.getInstances("provider");
        //拿第一个
        ServiceInstance element = serviceInstances.get(0);
        System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t" + element.getUri());
        return restTemplate.getForObject(element.getUri() + "/provider/discovery", Object.class);
    }

}
