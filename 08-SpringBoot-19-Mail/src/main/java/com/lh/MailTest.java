package com.lh;

import org.apache.logging.log4j.message.SimpleMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

@SpringBootTest
public class MailTest {
    //从容器中获取邮件发送对象
    @Autowired
    private JavaMailSender sender;
    @Test
    void testHtmlMail(){
        //创建一个邮箱对象
        MimeMessage mimeMessage = sender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        try {
            mimeMessageHelper.setFrom("2312697938@qq.com");
            //设置发送的时间（定时邮件）
         mimeMessage.setSentDate(new Date());

         mimeMessageHelper.setTo(new String("527798454@qq.com"));
         mimeMessageHelper.setCc(new String("527798454@qq.com"));
         mimeMessageHelper.setBcc("527798454@qq.com");
         mimeMessageHelper.setSubject("长得太丑了，去韩国整整容吧");
         mimeMessageHelper.setText("你和村里的老母猪订婚，结婚在3033年13月32日,赶快整容回来",true);
         sender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Test
    void  testSimple(){
        //简单的邮件消息
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        //发送人
        simpleMailMessage.setFrom("2856730147@qq.com");
        //接收者
        simpleMailMessage.setTo("527798454@qq.com");
        //抄送人
        simpleMailMessage.setCc("i1581336927@qq.com");
        //秘密抄送，只有发送人和密抄者能够看到
        simpleMailMessage.setBcc("i1581336927@qq.com");
        //邮件主题
        simpleMailMessage.setSubject("您收到了一份订婚邮件，请注意查收");

        simpleMailMessage.setText("你和村里的老母猪订婚，结婚在3033年13月32日。");

        //发送邮件
        for (int i = 0; i <50 ; i++) {
            sender.send(simpleMailMessage);
        }

    }
}
