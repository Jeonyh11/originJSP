package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.EmpVo;
import kr.or.ddit.user.service.EmpService;
import kr.or.ddit.user.service.EmpServiceI;

@WebServlet("/allemp")
public class AllEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmpServiceI service = new EmpService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<EmpVo> empList = service.selectAllEmp();
		
		req.setAttribute("empList", empList);
		
		req.getRequestDispatcher("/emp/allemp.jsp").forward(req, resp);
		
	}
}
