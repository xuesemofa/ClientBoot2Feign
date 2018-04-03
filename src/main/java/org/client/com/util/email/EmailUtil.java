package org.client.com.util.email;

import org.apache.commons.collections.map.HashedMap;
import org.apache.velocity.app.VelocityEngine;
import org.client.com.util.base64.Base64Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

public class EmailUtil {

    private final static Logger logger = LoggerFactory
            .getLogger(EmailUtil.class);

    /**
     * @param mailSender JavaMailSender
     * @param title      邮件主题
     * @param text       邮件内容
     * @param fromUser   发送账户
     * @param toUser     接受账户
     * @return 是否成功
     */
    public boolean toEmail(JavaMailSender mailSender, String title, String text, String fromUser, String toUser) {
        try {
            final MimeMessage mimeMessage = mailSender.createMimeMessage();
            final MimeMessageHelper message = new MimeMessageHelper(
                    mimeMessage, true);
            message.setFrom(fromUser);
            message.setTo(toUser);
            // 邮件主题
            message.setSubject(title);
            //            模版
            //初始化参数
            Properties properties = new Properties();
            //设置velocity资源加载方式为file
            properties.setProperty("resource.loader", "file");
            //设置velocity资源加载方式为file时的处理类
            properties.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.FileResourceLoader");
            //实例化一个VelocityEngine对象
            VelocityEngine velocity = new VelocityEngine();
            Map<String, Object> model = new HashedMap();
            model.put("yzm", "验证码");
            String text1 = VelocityEngineUtils.mergeTemplateIntoString(
                    velocity, "model.vm", "UTF-8", model);
            message.setText(text1, true);
            mailSender.send(mimeMessage);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }


    /**
     * @param formUser
     * @param toUser
     * @return boolean
     */
    public boolean sendEmail(JavaMailSender mailSender, String formUser, String toUser) {
        try {
            final MimeMessage mimeMessage = mailSender
                    .createMimeMessage();
            final MimeMessageHelper message = new MimeMessageHelper(
                    mimeMessage);
            message.setFrom(formUser);
            message.setTo(toUser);
            message.setSubject("注册");
            StringBuffer sb = new StringBuffer();
            // 时间加密
            Date afterDate = new Date(new Date().getTime() + 300000);
            String str3 = Base64Util.encode(afterDate.toString());
            sb.append(
                    "<a href='http://member.hebeikuajing.com/register/registerActivation?a="
                            + toUser + "&c=" + str3
                            + "'>点击连接并激活账号</a>");
            message.setText(sb.toString(), true);
            mailSender.send(mimeMessage);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }


    /**
     * @param formUser
     * @param toUser
     * @param str
     * @return boolean
     */
    public boolean email(JavaMailSender mailSender, String formUser, String toUser, String str) {
        try {
            final MimeMessage mimeMessage = mailSender.createMimeMessage();
            final MimeMessageHelper message = new MimeMessageHelper(
                    mimeMessage);
            message.setFrom(formUser);
            message.setTo(toUser);
            // 邮件主题
            message.setSubject("");
            StringBuffer sb = new StringBuffer();
            sb.append(str);
            // 邮件内容
            message.setText(sb.toString(), true);
            mailSender.send(mimeMessage);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * 带附件切使用模版，模版有背景图片
     *
     * @param mailSender JavaMailSender
     * @param fromUser   发送人
     * @param toUser     接收人
     * @param zt         邮件主题
     * @param filesPath  系统设置的上传下载路径
     * @param FJfileName 附件显示的名称
     * @param FJfiles    附件真正的文件名称，带后缀名
     * @return true ok ;false error
     */
    public boolean toEmail(JavaMailSender mailSender, String fromUser, String toUser, String zt, String filesPath,
                           String FJfileName, String FJfiles) {
        try {
            final MimeMessage mimeMessage = mailSender.createMimeMessage();
            final MimeMessageHelper message = new MimeMessageHelper(
                    mimeMessage, true);
            message.setFrom(fromUser);
            message.setTo(toUser);
            // 邮件主题
            message.setSubject(zt);
//            模版
            //初始化参数
            Properties properties = new Properties();
            //设置velocity资源加载方式为file
            properties.setProperty("resource.loader", "file");
            //设置velocity资源加载方式为file时的处理类
            properties.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.FileResourceLoader");
            //实例化一个VelocityEngine对象
            VelocityEngine velocity = new VelocityEngine();
            Map<String, Object> model = new HashedMap();
            model.put("emailname", toUser);
            String text = VelocityEngineUtils.mergeTemplateIntoString(
                    velocity, "model.vm", "UTF-8", model);
            message.setText(text.toString(), true);
//插入图片(背景图片)
//            FileSystemResource img1 = new FileSystemResource(new File(filesPath, "img.img"));
//            message.addInline("backimg1", img1);
//            FileSystemResource img2 = new FileSystemResource(new File(filesPath, "img.img"));
//            message.addInline("backimg2", img2);


//            附件1
            FileSystemResource file1 = new FileSystemResource(new File(filesPath, FJfiles));
            message.addAttachment(FJfileName, file1);
            mailSender.send(mimeMessage);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
