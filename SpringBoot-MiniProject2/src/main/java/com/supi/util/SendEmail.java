package com.supi.util;

import java.io.BufferedReader;
import java.io.File;

import java.io.FileReader;
import java.io.IOException;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.supi.entity.UserRegistrationForm;




	
	/*
	 * @Autowired private static JavaMailSender emailSender;
	 * 
	 * public static String sendEmail(UserRegistrationForm user) {
	 * 
	 * 
	 * 
	 * try {
	 * 
	 * MimeMessage message = emailSender.createMimeMessage();
	 * 
	 * MimeMessageHelper helper = new MimeMessageHelper(message);
	 * 
	 * // helper.setFrom("supriyabal5011@gmail.com"); helper.setTo(user.getEmail());
	 * helper.setSubject("for u");
	 * 
	 * 
	 * helper.setText(ReadData(user),true); emailSender.send(message);
	 * 
	 * 
	 * } catch (MessagingException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); } return "email nor send";
	 * 
	 * 
	 * 
	 * // ... }
	 * 
	 * private static String ReadData(UserRegistrationForm userform) throws
	 * IOException {
	 * 
	 * 
	 * File file=new File("SEND-EMAIL.txt");
	 * 
	 * // String file // = new FileSystemResource( new File("SEND-EMAIL.txt"));
	 * 
	 * FileReader fr=new FileReader(file); BufferedReader br=new BufferedReader(fr);
	 * 
	 * StringBuffer sb=new StringBuffer(); String line=br.readLine();
	 * 
	 * while(line !=null) { sb.append(line); line=br.readLine();
	 * 
	 * //appends line to string buffer sb.append("\n"); }
	 * 
	 * String string=sb.toString(); string=string.replace("{FNAME}",
	 * userform.getFirstName()); string=string.replace("{LNAME}",
	 * userform.getLastName()); string=string.replace("{TEMP-PWD}",
	 * userform.getUserPwd()); string=string.replace("{EMAIL}",
	 * userform.getEmail());
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * //return sb.toString(); return string;
	 * 
	 * }
	 */
	

	/*
	 * @Autowired private static JavaMailSender emailSender;
	 * 
	 * public static String sendSimpleMessage(UserRegistrationForm user) {
	 * 
	 * SimpleMailMessage message = new SimpleMailMessage(); // message.setFrom("");
	 * message.setTo(user.getEmail()); message.setSubject("for u");
	 * message.setText("You are best"); emailSender.send(message); return
	 * emailSender.toString();
	 * 
	 * }
	 */

	



	@Component
	public class SendEmail {
		
		@Autowired
	    private JavaMailSender javaMailSender;
		

	public  String  sendEmailForAccUnlock(UserRegistrationForm user)  {

	   // SimpleMailMessage msg = new SimpleMailMessage();
		try {
		  MimeMessage msg = javaMailSender.createMimeMessage();
	      
		    MimeMessageHelper helper = new MimeMessageHelper(msg);
		    
		    helper.setTo(user.getEmail());
		    helper.setSubject("For u");
		   
		helper.setText(readEmailBody(user),true);
		javaMailSender.send(msg);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "Failed";
		     
		  
			
			  //msg.setTo("kush.shraddha.kush@gmail.com");
			/*
			 * msg.setTo(user.getEmail()); msg.setSubject("For u"); try {
			 * msg.setText(readEmailBody(user)); javaMailSender.send(msg); return true; }
			 * catch (IOException e) { e.printStackTrace();
			 * 
			 * 
			 * } return false;
			 */
	    

	}
	//karrasankar@gmail.com

	  private String readEmailBody(UserRegistrationForm user) throws IOException {
		  
		    String fileMsg="";
		  
		    FileReader file=new FileReader("SEND-EMAIL.txt");

		     BufferedReader br = new BufferedReader(file);
		     fileMsg=br.readLine();
		     StringBuffer sb=new  StringBuffer();
		     while (fileMsg != null) {
		    	 sb.append(fileMsg);
		    	 fileMsg = br.readLine();
		     }
		    	    //System.out.println(fileMsg); 
		     String string = sb.toString();
		     string=string.replace("{FNAME}", user.getFirstName());
		     string=string.replace("{LNAME}", user.getLastName());
			 string=string.replace("{TEMP-PWD}", user.getUserPwd()); 
			 string=string.replace("{EMAIL}", user.getEmail()); 
		     
		return string;
		
		
		  
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	
	/*  public boolean sendEmailForPwd(UserRegistrationForm user) {
	  
	  // SimpleMailMessage msg = new SimpleMailMessage(); 
		  try { 
			  MimeMessage msg =
		  }
	  javaMailSender.createMimeMessage();
	  
	  MimeMessageHelper helper = new MimeMessageHelper(msg);
	  
	  helper.setTo(user.getEmail()); helper.setSubject("Forgot pwd");
	  
	  helper.setText(readEmailBody02(user),true); 
	  
	  javaMailSender.send(msg);
	  }
	  catch (Exception e) { 
		  // TODO Auto-generated catch block
		  e.printStackTrace();
		  }
	  return false;
	  
	  }
	 
	  
	  
	/*
	 * private String readEmailBody02(UserRegistrationForm user) throws IOException
	 * {
	 * 
	 * String fileMsg="";
	 * 
	 * FileReader file=new FileReader("SEND-PWD.txt");
	 * 
	 * BufferedReader br = new BufferedReader(file); fileMsg=br.readLine();
	 * StringBuffer sb=new StringBuffer(); while (fileMsg != null) {
	 * sb.append(fileMsg); fileMsg = br.readLine(); } //System.out.println(fileMsg);
	 * String string = sb.toString(); string=string.replace("<FNAME>",
	 * user.getFirstName()); string=string.replace("<LNAME>", user.getLastName());
	 * string=string.replace("<PWD>", user.getUserPwd());
	 * //string=string.replace("<email>", user.getEmail());
	 * 
	 * return string;
	 * 
	 * }
	 */

	}
	

 
     
    
    
