package nongsan.webmvc.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.catalina.mbeans.MBeanUtils;

import nongsan.webmvc.dao.impl.EmailUtils;
import nongsan.webmvc.dao.impl.LoginDao;
import nongsan.webmvc.dao.impl.UserDaoImpl;
import nongsan.webmvc.model.Email;
import nongsan.webmvc.model.User;
import nongsan.webmvc.model.changepasswordform;

@WebServlet(name = "changepasswordcontroller", urlPatterns = "/doi-mat-khau")
public class changepasswordcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
    public changepasswordcontroller() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/client/changepassword.jsp");
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
			UserDaoImpl userdao = new UserDaoImpl();
			//HttpSession session = request.getSession(); 
			//session.setAttribute("username", username);
			changepasswordform form = new changepasswordform(); 
			request.setAttribute("email", email);
			if(!form.getConfirmpassword().equals(form.getPassword()))
			{
			request.setAttribute("erro","new password  and new confirpassword không trùng nhau");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/client/changepassword.jsp");
			rd.forward(request, response);
			}
			else{				
				userdao.changepassword(form.getEmail(), form.getCurrenpassword(), form.getPassword());
				request.setAttribute("thống báo", "Password has been changed");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/view/client/changepassword.jsp");
				rd.forward(request, response);
				}
			
			}catch (Exception e) {
			e.printStackTrace();
		}	
	}
}


