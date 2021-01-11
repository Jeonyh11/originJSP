package kr.or.ddit.user.repository;

import java.util.List;

import kr.or.ddit.user.model.EmpVo;

public interface EmpDaoI {
	
	//전체 직원 조회
	List<EmpVo> selectAllEmp();

}
