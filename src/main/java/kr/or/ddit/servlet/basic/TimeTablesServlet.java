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
		
		out.write("<!DOCTYPE html>");
		out.write("<!html>");
		out.write("<head><!meta charset='utf-8'>");
		out.write("<title>구구단</title></head>");
		out.write("<style>");
		out.write(" table{");
		out.write("width : 100%;");
		out.write("}");
		out.write("</style>");
		out.write("<body>");
		
		
		out.write("<table border='1'>");

		for(int i =1; i<=9; i++) {
			out.write("<tr>");
		for(int j =2; j <=9; j++) {
			out.write("<td>" + j + "* "+i+"=" + j*i + "</td>");
		}
		out.write("</tr>");
		}
		
		out.write("</table>");
		out.write("</body");
		out.write("</html>");
		
	}

}
