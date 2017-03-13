package spring.cloud.web.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import spring.cloud.web.feign.hystrix.HelloFeignHystrix;

/**
 * Created by liuluming on 2017/3/5.
 */
@FeignClient(value="SERVER-GATEWAY/api-a",fallback = HelloFeignHystrix.class)
//@RequestMapping("/hello") 如果加上这个注解，hystrix将无法正常工作
public interface HelloFeign {

    @RequestMapping(method = RequestMethod.POST, value = "/hello/insert")
    int insert(@RequestParam(value = "name") String name) ;

}
