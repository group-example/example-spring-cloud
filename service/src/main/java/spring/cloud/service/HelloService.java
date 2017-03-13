package spring.cloud.service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.cloud.common.BusinessException;
import spring.cloud.dao.mapper.HelloMapper;
import spring.cloud.dao.model.Hello;

import java.util.List;

/**
 * Created by liuluming on 2017/3/5.
 */
@RestController
@RequestMapping("hello")
@Api(description = "演示描述")
public class HelloService {

    private Logger logger= LoggerFactory.getLogger(HelloService.class);

    @Autowired
    private HelloMapper helloMapper;

//    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    @RequestMapping(value="insert",method= RequestMethod.POST)
    @ApiOperation("新增")
    public int insert(@RequestParam("name") String name) throws BusinessException {
        int i= helloMapper.insert(name);
        System.out.println("数量="+i);
        return i;
    }

    @RequestMapping(value="update",method= RequestMethod.PUT)
    @ApiOperation("更新")
    public int update(@RequestParam String name,@RequestParam Long id){
        return helloMapper.update(name,id);
    }

    @RequestMapping(value="find",method= RequestMethod.GET)
    @ApiOperation("查询")
    public List<Hello> findByName(@RequestParam String name){
        return helloMapper.findByName(name);
    }
}
