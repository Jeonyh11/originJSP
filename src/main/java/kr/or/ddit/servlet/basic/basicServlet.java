package kr.or.ddit.servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;private static final Logger logger = LoggerFactory.getLogger(enclosing_type.class);
public class basicServlet extends HttpServlet{
	
	private static final Logger logger = LoggerFactory.getLogger(basicServlet.class);

	
	@Override
	public void init() throws ServletException {
		System.out.println("basicServlet.init()");
	}
	
	//doXXX 메소드의 인자 : req, res
	//GET, POST, DELETE, PUSH, HEAD : HTTP 메소드
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		logger.debug("basicServlet.doGet()");
		
		//만약에 log level을 debug보다 높은 레벨로 설정한 경우
		//로그를 생성하지는 않지만 메소드 인자인 문자열 + 문자열 ==> 문자열 결합 연산은 발생한다.
		
//		if(설정 로그 레벨 <= debug) {
		logger.debug("basicServlet.doGet() userid parameter :" + req.getParameter("userid"));
//		}
		logger.debug("basicServlet.doGet() userid parameter : {} {}", 
				req.getParameter("userid"), req.getParameter("password"));
		resp.setContentType("text/html; charset=UTF-8");
		
		//재정의
		//요청을 생성할 때마다 서버의 현재시간이 달라진다
		//new Date 부분을 db에서 조회한 데이터라고 생각해보면
		//사용자 별로 요청에 대한 응답을 각각 다르게 생성하는 것이 가능하다
		//db에 대한 연동 부분은 html, javascript만 이용해서는 불가능 ==> 정적
		//servlet을 통해 응답으로 생성하는 html을 동적으로 변경 ==> 동적(servlet/jsp를 배우는 이유)
		
		//Servlet의 라이프 사이클
		// init() ->     service() ->        destroy()
		// 로딩시 최초1회    사용자가 요청할때마다      서버 종료 or reload
		
		//init 메소드는 해당 서블릿에서 사용할 자원을 초기화 할 때 사용
		//로딩시 최초1회 호출 : 로딩 되는 시점 -> 해당서블릿으로 최초 요청이 들어왔을때
		//단 web.xml의 servlet 엘레멘트의 하위 엘레멘트인 load-on-startup 엘레멘트 값으로 
		//양의 정수값을 입력할 경우 서버가 기동하면서 바로 init 메소드를 호출한다.
		
		
		//servlet container가 요청을 처리하는 방법
		//등록된 url 매핑을 참고하여 등록된 서블릿으로 요청을 전달(servlet 메소드 호출)
		//localhost/basicServlet ==> BasicServlet의 service 메소드를 통해 응답생성
		// localhost/index.jsp ==> server 설정에 있는 web.xml 에 등록된 *.jsp,
//									 *.jspx url-pattern에 따라 jsp라는 이름의 서블릿에서 처리(JspServlet)
		//localhost/doc/20201223.txt 정적자료
		
		
		PrintWriter pw = resp.getWriter(); // Test
		 
		pw.println("<html>");
		pw.println("	<head>");
		pw.println("		<title>basic Servlet</title>");
		pw.println("	</head>");
		pw.println("	<body> Hello, World" + new Date());
		pw.println("	</body>");
		pw.println("</html>");
		pw.println("Hello, World");
		
		pw.flush();    //더이상 작성할 내용이 없으므로 작업을 마무리한다.
		pw.close();	   //사용한 자원 반납
	}
	
	//doGet, doPost 
	
	

}
