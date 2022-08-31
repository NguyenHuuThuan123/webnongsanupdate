package nongsan.webmvc.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.mail.internet.*;
import nongsan.webmvc.dao.impl.EmailUtils;
import nongsan.webmvc.dao.impl.UserDaoImpl;
import nongsan.webmvc.model.Email;
import nongsan.webmvc.model.User;

import java.io.IOException;

@WebServlet(name = "ForgotPasswordController", urlPatterns = "/quen-mat-khau")
public class ForgotPasswordController extends HttpServlet {

	private static final long serialVersionUID = 1L;
//	private UserDaoImpl userDao = new UserDaoImpl();

	public ForgotPasswordController() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/client/forgot-password.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String email = request.getParameter("email");	
		System.out.println(email);	
		
		try {			
			UserDaoImpl userDao = new UserDaoImpl();
			if (userDao.passwordRecovery(email)) {
				request.setAttribute("Message", "Mật khẩu đã được gửi, vui lòng kiểm tra email và đăng nhập lại!.");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/client/forgot-password.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("errMessage", "Tài khoản không tồn tại với email này!");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/client/forgot-password.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//userDao.passwordRecovery(email)
		//private UserDaoImpl userDao = new UserDaoImpl();
	}
}

//ham phu
//	
//	public class ForgotPasswordController extends HttpServlet {
//		private static final long serialVersionUID = 1L;
//		public ForgotPasswordController() {
//			super();
//		}
//		
//		protected void doGet(HttpServletRequest request, HttpServletResponse response)
//				throws ServletException, IOException {
//			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/client/forgot-password.jsp");
//			dispatcher.forward(request, response);
//		}
//	
//

//		protected void doPost(HttpServletRequest request, HttpServletResponse response)
//				throws ServletException, IOException 
//		{
//			request.setCharacterEncoding("utf-8");
//			response.setCharacterEncoding("UTF-8");
//			response.setContentType("text/html;charset=UTF-8");
//		//	String email = request.getParameter("email");	
//			try {
//			String email =request.getParameter("email");		
//		UserDaoImpl userDao = new UserDaoImpl();
//			User user = userDao.passwordRecovery(email);
//			
//			if(user == null)
//			{
//				request.setAttribute("error", "User or email are incorrect");
//			}else
//			{	
//			Email email1 = new Email();
//				email1.setFrom("huuthuan170003@gmail.com");
//				email1.setFromPassword("yourpassword");
//				email1.setTo(email);
//				email1.setSubject("Forgot Password Funtion");
////				StringBuilder sb = new StringBuilder();
////				sb.append("Dear").append("<br>");
////				sb.append("you are used the forgot password funtion. <br>");
////				sb.append("Regards <br>");
////				sb.append("Adminnistrator");
////				
////				email1.setContend(sb.toString());
////				EmailUtils.sendMail(email1);
////				RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/client/forgot-password.jsp");
////				rd.forward(request, response);
////				request.setAttribute("message", "Email sent to the email Address. " + "Please check and get your password");
////			}}catch(Exception e) {
////				e.printStackTrace();
////				request.setAttribute("error", e.getMessage());
////			}
////			//PageInfo.prepareAndForwardSite(request, response, PageType.SITE_FORGOT_PASSWORD_PAGE);
////		}
////	}
	
	

