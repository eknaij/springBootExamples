package com.eknaij.springbootemail.service;

public interface MailServer {
    /**
     * to ：接受者
     * subject：主题
     * content： 正文
     * **/

    /**发送普通的邮件**/
    public void sendSimpleMail(String to, String subject, String content);
    /**发送html格式的邮件**/
    public void sendHtmlMail(String to, String subject, String content);
    /**发送带附件**/
    public void sendAttachmentsMail(String to, String subject, String content, String filePath);
    /**发送带静态自愿的邮件**/
    public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);
}
