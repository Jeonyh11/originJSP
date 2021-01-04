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

@WebServlet("/sumCalculation")
public class sumCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger logger = LoggerFactory.getLogger(sumCalculation.class);
    
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher("/jsp/sumMain.jsp").forward(req, res);
		
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String start = req.getParameter("start");
		String end = req.getParameter("end");
		
		int a = Integer.parseInt(start);
		int b = Integer.parseInt(end);
		
		int sum = 0;
		for(int i = a; i<=b; i++) {
			sum += i;
		}
		
		String result = Integer.toString(sum);
		
		HttpSession session = req.getSession();
		session.setAttribute("session", result);
		
		req.setAttribute(result, result);
		
		logger.debug(start);
		logger.debug(end);
		logger.debug(result);
		
		req.getRequestDispatcher("/jsp/sumResult.jsp").forward(req, res);
	}

}
