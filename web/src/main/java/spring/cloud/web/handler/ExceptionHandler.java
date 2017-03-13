package spring.cloud.web.handler;

import org.springframework.web.bind.annotation.ResponseBody;
import spring.cloud.common.BusinessException;
import spring.cloud.web.response.GeneralResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by liuluming on 2017/3/1.
 */
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public GeneralResponse<String> errorHandler1(HttpServletRequest req, BusinessException e) throws Exception {
        GeneralResponse<String> r = new GeneralResponse<>();
       r.setSuccessful(false);
       r.setMessage(e.getMessage());
        return r;
    }


    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    @ResponseBody
    public GeneralResponse<String> errorHandler2(HttpServletRequest req, BusinessException e) throws Exception {
        GeneralResponse<String> r = new GeneralResponse<>();
        r.setSuccessful(false);
        r.setMessage("系统出错了："+e.getMessage());
        return r;
    }
}
