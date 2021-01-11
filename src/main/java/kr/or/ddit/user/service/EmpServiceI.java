package kr.or.ddit.user.service;

import java.util.List;

import kr.or.ddit.user.model.EmpVo;

public interface EmpServiceI {

	//전체 직원 조회
	List<EmpVo> selectAllEmp();
}
