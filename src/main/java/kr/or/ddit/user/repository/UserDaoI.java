package kr.or.ddit.user.repository;

import java.util.List;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public interface UserDaoI {
	//전체 사용자 정보 조회
	
	List<UserVo>selectAllUser();

	// userid에 해당하는 사용자 한명의 정보 조회
	UserVo selectUser(String userid);
	
	//사용자 페이지 조회
	List<UserVo> selectPagingUser(PageVo Vo);
	
	//사용자 전체 수 조회 반환 타입 int
	int selectAllUserCnt();
	
	
}
