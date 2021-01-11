package kr.or.ddit.user.service;

import java.util.List;

import kr.or.ddit.user.model.EmpVo;
import kr.or.ddit.user.repository.EmpDao;
import kr.or.ddit.user.repository.EmpDaoI;

public class EmpService implements EmpServiceI{
	
	EmpDaoI EmpDao = new EmpDao();

	@Override
	public List<EmpVo> selectAllEmp() {
		return EmpDao.selectAllEmp();
	}

}
