package kr.or.ddit.servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TimeTablesServlet
 */
//@WebServlet("TimeTablesServlet")
public class TimeTablesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public TimeTablesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<!html>");
		out.println("<head><!meta charset='utf-8'>");
		out.println("<title>구구단</title></head>");
		out.println("<style>");
		out.println(" table{");
		out.println("width : 100%;");
		out.println("}");
		out.println("</style>");
		out.println("<body>");
		
		
		out.println("<table border='1'>");
//		out.println("<tr>");
		for(int i =1; i<=9; i++) {
			out.println("<tr>");
		for(int j =2; j <=9; j++) {
			out.println("<td>" + j + "* "+i+"=" + j*i + "</td>");
		}
		out.println("</tr>");
		}
		
		out.println("</table>");
		out.println("</body");
		out.println("</html>");
		
	}

}
