package kr.or.ddit.user.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

@WebServlet("/userModify")
public class UserModify extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private UserServiceI userService = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
//		파라미터 userid는 스트링 으로 받아와서 스트링으로 데이터 타입 설정
		String userid = req.getParameter("userid");
//		selectUser 를 들어가보면 UserVo 라는 객체로 데이터타입이 되어 있어서 user도 객체 데이터 타입 설정
		UserVo user = userService.selectUser(userid);
		
		req.setAttribute("user", user); 
		
		req.getRequestDispatcher("/user/userModify.jsp").forward(req, resp);
	}

	//사용자 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//파라미터를 읽기 전에 실행 doPost에서 구현 doGet은 server URL을 통해 받아오므로 server.xml에서 고쳐준다.
		//servlet의 doPost 메소드 마다 실행 필요 => Filter
		req.setCharacterEncoding("utf-8");
		
		String userid = req.getParameter("userid");
		String usernm = req.getParameter("usernm");
		String pass = req.getParameter("pass");
		
		//파라미터는 문자열이다 reg_dt는 Date 타입이다 날짜를 문자열로 변환해야 한다.
		//
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		Date reg_dt = null;
		
		try {
			reg_dt = sdf.parse(req.getParameter("reg_dt"));
		}catch(ParseException e){
			e.printStackTrace();
		}
		
		String alias = req.getParameter("alias");
		String addr1 = req.getParameter("addr1");
		String addr2 = req.getParameter("addr2");
		String zipcode = req.getParameter("zipcode");
		
		UserVo userVo = new UserVo(userid, usernm, pass, reg_dt, alias, addr1, addr2, zipcode);
	
		int updateCnt = userService.modifyUser(userVo);
		
		//사용자 수정이 정상적으로 된 경우 => 해당 사용자의 상세조회 페이지 이동
		if(updateCnt == 1) {
			
		resp.sendRedirect(req.getContextPath()+"/user?userid="+userid);
		//서블릿으로 재요청
		//req.getRequestDispatcher("/user/user.jsp").forward(req, resp);
		}
		//사용자 수정이 비정상적으로 된 경우 => 해당 사용자의 정보 수정 페이지 이동
		else {
			doGet(req,resp);		
		}
	}
}
