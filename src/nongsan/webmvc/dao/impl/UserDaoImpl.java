package nongsan.webmvc.dao.impl;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
//import javax.persistence.EntityManager;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JPanel;
import javax.swing.text.html.parser.Entity;






import java.sql.ResultSet;

import nongsan.webmvc.model.User;
import nongsan.webmvc.dao.UserDao;
import nongsan.webmvc.jdbc.connectDB;


public class UserDaoImpl extends connectDB implements UserDao {
	
	@Override
	public void insert(User user) {
		String sql = "INSERT INTO users(name,email,phone,username,password,created) VALUES (?, ?, ?, ?, ?, ?)";
		new connectDB();
		Connection con = connectDB.getConnect();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPhone());
			ps.setString(4, user.getUsername());
			ps.setString(5, user.getPassword());
			ps.setString(6,user.getCreated());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM users where id = ?";
		new connectDB();
		Connection con = connectDB.getConnect();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public User get(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User get(int id) {
		User user = new User();
		String sql = "select * from users where id=?";
		new connectDB();
		Connection con = connectDB.getConnect();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setCreated(rs.getString("created"));
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		}

        return user;
	}
	
	@Override
	public void edit(User user) {	
		String sql = "Update users set name=?, email=?, phone=?, username=?, password=?, created=? where id=?";
		new connectDB();
		Connection con = connectDB.getConnect();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPhone());
			ps.setString(4, user.getUsername());
			ps.setString(5, user.getPassword());
			ps.setString(6,user.getCreated());
			ps.setInt(7,user.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public List<User> getAll() {		
		List<User> users = new ArrayList<User>();
		String sql = "SELECT * FROM users";
		Connection conn = connectDB.getConnect();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User user = new User();

				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setCreated(rs.getString("created"));
				users.add(user);
			}	

		} catch (SQLException e) {
			e.printStackTrace();
			
		}

		return users; 
	}
//hamchinh	
	public boolean passwordRecovery(String email) {
        Connection conn = connectDB.getConnect();
        String sql = "SELECT * FROM users WHERE email ='" + email +  "'"; //"SELECT * FROM user WHERE email ='" + email +  "'"; 
        try {	
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setPassword(rs.getString("password"));
               sendMail(email,"Your password is: ",user.getPassword());
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
	
//	public boolean passwordRecovery(String email) {
//        Connection conn = connectDB.getConnect();    
//        String sql = "SELECT * FROM user WHERE email ='" + email +  "'";
//        try {	
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                User user = new User();
//                user.setPassword(rs.getString("password"));
//                user.setEmail(email);            
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
	
	//Send Mail:
    public static boolean sendMail(String to, String subject, String text) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");     
    //    props.put("mail.smtp.ssl.trust", "*");
        
        
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("huuthuan170003@gmail.com", "pgpfthirahswjntr");//pgpfthirahswjntr 0933644058n chickengangstore615@gmail.com
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setHeader("Content-Type", "text/plain; charset=UTF-8");
            message.setFrom(new InternetAddress("huuthuan170003@gmail.com","webnongsan@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(text);
            Transport.send(message);
        } catch (MessagingException | UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    //thay doi mat khau
//    public User changepassword (String username , String password, String newpassword) {
//    	
//    	Connection conn = null;
//    	PreparedStatement ps = null; // nem lenh query sang slq
//    	ResultSet rs = null; // nhan ket qua tra vef
//    	
//        try {	
//        	String query = "select username, password from users where username = ? AND password = ?";
//			new connectDB();
//			conn = connectDB.getConnect();
//			ps = conn.prepareStatement(query);
//			ps.setString(1, username);
//			ps.setString(2, password);
//			rs = ps.executeQuery();
//			while(rs.next()) {
//				User u = new User(rs.getString(1), rs.getString(2));				
//				u.setPassword(newpassword);
//				ps.executeUpdate();
//				return u;    				
//            }			
//        } catch (SQLException e) {
//            e.printStackTrace();               
//    }
//        		return null;
//    }
    public boolean changepassword(String email, String newpassword, String password) {
        Connection conn = connectDB.getConnect();
        String sql = "SELECT * FROM users WHERE email ='" + email +  "'"; //"SELECT * FROM user WHERE email ='" + email +  "'"; 
        try {	
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setPassword(rs.getString("password"));
                user.setPassword(newpassword);
				ps.executeUpdate();
					
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
  }


