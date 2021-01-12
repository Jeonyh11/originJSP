package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

@WebServlet("/pagingUser")
public class PagingUser extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private UserServiceI userService = new UserService();
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//left.jsp : /pagingUser?page=1&pageSize=5
		// ===>      /pagingUser
		
		//doGet 메소드에서 page, pageSize 파라미터가 request 객체에 존재 하지 않을 떄
		//page는 1로 pageSize는 5로 생각하여 코드를 작성
		// 파라미터가 존재하면 해당 파라미터 적용
		
		// primitive Type ==> class(Wrapper) Integer int를 Interger클래스로 Wrapper 할수 있다.
		
		//int page = Integer.parseInt(req.getParameter("page"));
		//int pageSize = Integer.parseInt(req.getParameter("pageSize"));
		
		//refactoring : 코드를 깔끔하게 바꾸는데 기존 동작 방식을 유지한채로 변경하는 기법
		
		String pageParam = req.getParameter("page");
		String pageSizeParam = req.getParameter("pageSize");
		
		int page = req.getParameter("page") == null ? 1 :Integer.parseInt(pageParam);
		int pageSize = req.getParameter("pageSize") == null ? 5 : Integer.parseInt(pageSizeParam);
		
		PageVo pageVo = new PageVo(page, pageSize);
		
//		if(req.getParameter("page") == null) {
//			page = 1;
//		}
//		else {
//			page = Integer.parseInt(req.getParameter("page"));
//		}
//		
//		if(req.getParameter("pageSize") == null) {
//			pageSize = 5;
//		}
//		else {
//			pageSize =Integer.parseInt(req.getParameter("pageSize"));
//		}
//		
			
		Map<String,Object> map = userService.selectPagingUser(pageVo);
		
		List<UserVo> userList = (List<UserVo>)map.get("userList");
		
		int userCnt = (int)map.get("userCnt");
		int pagination = (int)Math.ceil((double) userCnt/ pageSize);
		
		req.setAttribute("userList", userList);
//		1월12일 수업
		req.setAttribute("pagination", pagination);
		req.setAttribute("PageVo", pageVo);
		
		req.getRequestDispatcher("/user/pagingUser.jsp").forward(req, resp);
	}

}
