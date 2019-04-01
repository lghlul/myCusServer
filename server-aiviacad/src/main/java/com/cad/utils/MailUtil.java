package com.cad.utils;

import com.cad.controller.UserController;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @CLassName MailUtil
 * @Description TODO
 * @Author ll
 * @Date 2019/3/4 9:52
 **/
public class MailUtil {
    public static void main(String[] args) {
        // 收件人电子邮箱
        String to = "736690299@qq.com";

        // 发件人电子邮箱
        String from = "matlacdom@163.com";

        // 指定发送邮件的主机为 smtp.qq.com
        String host = "smtp.163.com";  //QQ 邮件服务器

        // 获取系统属性
        Properties properties = System.getProperties();

        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);

        properties.put("mail.smtp.auth", "true");
        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                //return new PasswordAuthentication("736690299@qq.com", "hbhglghll0710"); //发件人邮件用户名、授权码
                return new PasswordAuthentication("matlacdom@163.com", "AIviaCAD2016"); //发件人邮件用户名、授权码
            }
        });

        try {
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from));

            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            // Set Subject: 头部头字段
            message.setSubject("This is the Subject Line!");

            // 设置消息体
            message.setText("This is actual message");

            // 发送消息
            Transport.send(message);
            System.out.println("Sent message successfully....from runoob.com");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }


    private static String from = "matlacdom@163.com";
    private static String fromPwd = "AIviaCAD2016";
    private static String host = "smtp.163.com";
    private static final String TAG = UserController.class.getName();

    public static void sendMailCode(String to, String subject, String text) {
        LogUtil.i(TAG, "sendEmailCode start...to=" + to + ",subject=" + subject + ",text=" + text);
        // 指定发送邮件的主机为 smtp.qq.com
        //String host = "smtp.qq.com";  //QQ 邮件服务器

        // 获取系统属性
        Properties properties = System.getProperties();

        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);

        properties.put("mail.smtp.auth", "true");


        String smtpPort = "465";
        properties.setProperty("mail.smtp.port", smtpPort);
        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.smtp.socketFactory.fallback", "false");
        properties.setProperty("mail.smtp.socketFactory.port", smtpPort);

        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, fromPwd); //发件人邮件用户名、授权码
            }
        });

        try {
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);
            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from));
            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));
            // Set Subject: 头部头字段
            message.setSubject(subject);
            // 设置消息体
            message.setText(text);
            // 发送消息
            Transport.send(message);
        } catch (MessagingException mex) {
            mex.printStackTrace();
            LogUtil.e(TAG, "Exception=" + mex);
        }
        LogUtil.i(TAG, "sendEmailCode end...");
    }
}
