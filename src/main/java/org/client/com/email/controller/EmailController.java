package org.client.com.email.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.client.com.util.email.EmailUtil;
import org.client.com.util.resultJson.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * email test
 * 带有附件方法
 */
@Api(value = "email", description = "邮件服务")
@RestController
@RequestMapping("/email")
public class EmailController {

    @Value("${spring.mail.username}")
    private String forEmail;
    @Value("${filesPath}")
    private String filesPath;

    @Autowired
    JavaMailSender mailSender;

    @ApiOperation(value = "发送验证码email",
            response = ResponseResult.class,
            httpMethod = "POST",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/verification",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult regitEmail(@RequestParam("title") String title, @RequestParam("toUser") String toUser) {
        ResponseResult result = new ResponseResult();
        EmailUtil emailUtil = new EmailUtil();
        boolean b = emailUtil.toEmail(mailSender, title, "您本次验证码为<span style='color:red;'>123</span>", forEmail, toUser);
        result.setSuccess(b);
        return result;
    }

}
