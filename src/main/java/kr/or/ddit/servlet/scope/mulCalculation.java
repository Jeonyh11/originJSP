package kr.or.ddit.servlet.scope;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/mulCalculation")
public class mulCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private static final Logger logger = LoggerFactory.getLogger(mulCalculation.class);
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/jsp/mulMain.jsp").forward(req, resp);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int param1 = Integer.parseInt(req.getParameter("param1"));
		int param2 = Integer.parseInt(req.getParameter("param2"));
		
		int mul = param1 * param2;
		
		logger.debug("",mul);
		
		HttpSession session = req.getSession();
		session.setAttribute("mulResult", "결과값 : " +mul);
		
		req.getRequestDispatcher("/jsp/mulResult.jsp").forward(req, resp);
		
		
	}

}
