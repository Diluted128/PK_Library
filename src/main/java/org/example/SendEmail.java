package org.example;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {

    public static void sendMail(String recipient) throws Exception {

        Properties properties = new Properties();

        // Identifies that server has authorization (login/password)
        properties.put("mail.smtp.auth","true");
        // if gmail set it to true else false
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");

        String myAccountEmail = "usermailservice.2@gmail.com";
        String password = "javabot890";

        Session session = Session.getInstance(properties, new Authenticator() {

            @Override
            protected  PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

        Message message = prepareMessage(session, myAccountEmail, recipient);

        Transport.send(message);

        System.out.println("Message sent secessfully");
    }
    private static Message prepareMessage(Session session, String myAccountEmail, String recipient){
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("Password Reminder");
            message.setText("We remind you that your password is xxxxxxxx");
            return message;
        }
        catch (Exception e){
            System.out.println("Error");
        }
        return null;
    }
}
