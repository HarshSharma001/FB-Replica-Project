package Data_Processing_Units;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class SendAutomatedEmail {

	Properties prop = System.getProperties();
    
	final String username = "*****@gmail.com";//
    final String password = "*******";
    
    String toEmail = null;

	private String code;
	
	public void sendEmail(String toUsername)  
    {
		toEmail = toUsername;
        try {
            
            prop.setProperty("mail.smtp.host", "smtp.gmail.com");
            prop.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            prop.setProperty("mail.smtp.socketFactory.fallback", "false");
            prop.setProperty("mail.smtp.port", "465");
            prop.setProperty("mail.smtp.socketFactory.port", "465");
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.debug", "true");
            prop.put("mail.store.protocol", "pop3");
            prop.put("mail.transport.protocol", "smtp");
            

            Session session = Session.getDefaultInstance(prop,
                    new Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    }); //to get hold on Session class instance //

            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(username));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

            VerificationCodeGenerator vc = new VerificationCodeGenerator();
            vc.generateVerificationCode();
            
            setCode(vc.generatedString);
           
            message.setSubject("FB Replica Verification Code");
            message.setText(getCode());

            Transport.send(message);

            System.out.println("Message Deleivered !");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
