package com.eknaij.springbootemail;

import com.eknaij.springbootemail.service.MailServer;
import com.eknaij.springbootemail.serviceImpl.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootemailApplicationTests {

    @Autowired
    private MailService mailService;
    @Test
    public void contextLoads() {
        mailService.sendSimpleMail("eknaij@qq.com","测试发送简单邮件","这是简单邮件");
    }
    @Test
    public void testHtmlMail() throws Exception {
        String content="<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail("eknaij@qq.com","测试发送html邮件",content);
    }
    @Test
    public void sendAttachmentsMail() {
        String filePath="C:\\Users\\admin\\Desktop\\新建文本文档.txt";
        mailService.sendAttachmentsMail("eknaij@qq.com", "主题：带附件的邮件", "有附件，请查收！", filePath);
    }
    @Test
    public void sendInlineResourceMail() {
        String rscId = "test888666";
        String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "C:\\Users\\admin\\Desktop\\111.png";

        mailService.sendInlineResourceMail("eknaij@qq.com", "主题：这是有图片的邮件", content, imgPath, rscId);
    }


}
