package com.company;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class JavaMail {


    private Properties prop;
    private String host = "smtp.gmail.com" ;
    private String from = "shakiba25.kh@gmail.com";
   // private String to = "khanzadeh.shakiba@gmail.com";

    public JavaMail(String code , String to) {
        prop = System.getProperties();
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.auth", "true");

        String StrCode = code;
        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("shakiba25.kh@gmail.com","lrcyyvxrgpctbgle");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("This is the  Davat Code 'Snnapfood!' ");

            // Now set the actual message
            message.setText(StrCode);

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }

}
