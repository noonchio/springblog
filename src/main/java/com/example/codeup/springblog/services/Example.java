package com.example.codeup.springblog.services;
import com.example.codeup.springblog.model.Post;
import com.sendgrid.*;
import java.io.IOException;
import com.sendgrid.SendGridAPI;

import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
@Service("email")
    public class Example  {

    @Autowired

    //    @Value()

     static String SENDGRID_API_KEY ="";

//        public static void main(String[] args) throws IOException {
public void prepareAndSendReal(Post post) throws IOException {
            Email from = new Email("a.oviedo.mprc@gmail.com");
            String subject = "Sending with SendGrid is Fun";
            Email to = new Email("alfredo.g.oviedo08@gmail.com");
            Content content = new Content("text/plain", "and easy to do anywhere, even with Java, Sent by: fastfreddy");
            Mail mail = new Mail(from, subject, to, content);


            SendGrid sg = new SendGrid(SENDGRID_API_KEY);
            Request request = new Request();
            try {
                request.setMethod(Method.POST);
                request.setEndpoint("mail/send");
                request.setBody(mail.build());
                Response response = sg.api(request);
                System.out.println(response.getStatusCode());
                System.out.println(response.getBody());
                System.out.println(response.getHeaders());
            } catch (IOException ex) {
                throw ex;
            }
        }
    }

