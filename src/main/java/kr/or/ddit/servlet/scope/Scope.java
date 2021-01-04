package kr.or.ddit.servlet.scope;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/scope")
public class Scope extends HttpServlet {
	private static final long serialVersionUID = 1L;



@Override
  	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  req.getRequestDispatcher("/jsp/scope.jsp").forward(req, resp);
  	}
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String scopeParameter = request.getParameter("scope");
		
		request.setAttribute("request", scopeParameter + "_request");
		
		HttpSession session = request.getSession();
		session.setAttribute("session", scopeParameter + "_session");
		
		ServletContext application = getServletContext();
		application.setAttribute("application", scopeParameter + "_application");
		
		
		request.getRequestDispatcher("/jsp/scopeResult.jsp").forward(request, response);
		
	}

}
