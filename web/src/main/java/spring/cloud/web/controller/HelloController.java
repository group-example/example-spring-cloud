package spring.cloud.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import spring.cloud.web.feign.HelloFeign;
import spring.cloud.web.response.GeneralResponse;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by liuluming on 2017/2/10.
 */
@Controller
@RequestMapping("/hello")
@Api(description = "描述")
public class HelloController {

    private Logger logger= LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private HelloFeign helloFeign;

    @Value("${spring.boot.admin.url}")
    private String from;

    @ApiOperation(value="单个用户")
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ResponseBody
    public GeneralResponse insert(){
        SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now=new Date();
        int result=helloFeign.insert(f.format(now));
        logger.info("操作成功数{}",result);
        GeneralResponse resp=new GeneralResponse();
        return resp;
    }


    @ApiOperation(value="查询列表")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public String list(){
        return from;
    }

    @ApiOperation(value="首页")
    @RequestMapping(value = {"/index",""},method = RequestMethod.GET)
    public String index(ModelMap map){
        map.addAttribute("host", "http://www.liuluming.com");
        return "index";
    }
}
