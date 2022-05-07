package utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class SendMailTLSPendenciaBuilder {

	public void MandaEmail(String email, 
        String assunto, StringBuilder mensagem, String pass ) {

		final String username = email;
		final String password = pass;
                final String server="";
                final String port="";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", server);
		props.put("mail.smtp.port", port);

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(email));
                        message.setRecipients(Message.RecipientType.CC, 
                                InternetAddress.parse(email));
                        
                                               
			message.setSubject(assunto);
                        String mensagemNormal = String.valueOf(mensagem);
			message.setText(mensagemNormal);

			Transport.send(message);
                        
			JOptionPane.showMessageDialog(null,"Mensagem enviada com sucesso!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}

