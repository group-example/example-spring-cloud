package spring.cloud.web.feign.hystrix;

import org.springframework.stereotype.Component;
import spring.cloud.web.feign.HelloFeign;

/**
 * Created by liuluming on 2017/3/7.
 */
@Component
public class HelloFeignHystrix implements HelloFeign {

    @Override
    public int insert(String name) {
        return 111;
    }

}
