package spring.cloud.service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liuluming on 2017/3/5.
 */
@RestController
@RequestMapping("mail")
@Api(description = "邮件演示描述")
public class MailService {
    private Logger logger= LoggerFactory.getLogger(MailService.class);

    @Autowired
    private JavaMailSender mailSender;

    @RequestMapping(value="send",method = RequestMethod.POST)
    @ApiOperation("邮件演示")
    public void sendSimpleMail() throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("461290158@qq.com");
        message.setTo("liuluming1989@qq.com");
        message.setSubject("测试邮件");
        message.setText("测试邮件内容");
        mailSender.send(message);
    }
}
