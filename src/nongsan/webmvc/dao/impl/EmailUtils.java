package nongsan.webmvc.dao.impl;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import nongsan.webmvc.model.Email;

public class EmailUtils {
	public static void sendMail(Email email) throws Exception
	{
		// cau hinh
		Properties prop = new Properties();
		prop.put("mail.smtp.host","smtp.gmail.com");// dia chi host
		prop.put("mail.smtp.port","587");// so hieu cong ket noi
		prop.put("mail.smtp.auth","true");//bat so hieu sat thuc
		prop.put("mail.smtp.starttls.enable","true");
		
// tao seeion emil va password
		Session session = Session.getInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthenticator() {
				return new PasswordAuthentication(email.getFrom(),email.getFromPassword());
			}
		});
		try {
			Message message =new MimeMessage(session);// tao message tu session o tren
			
			message.setFrom(new InternetAddress(email.getFrom()));// thiet lap thong so dia chi mail gui di
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getTo()));// danh sach nguoi nhan
			message.setSubject(email.getSubject());// tieu de
			message.setContent(email.getContend(),"text/html;charset=uft-8");//noi dung
			
			Transport.send(message);//gui
		     }catch (Exception e) {
		    	 e.printStackTrace();
		    	 throw e;	    	 
		     }
		
	}
}
