package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public interface UserServiceI {
	
	List<UserVo>selectAllUser();

	// userid에 해당하는 사용자 한명의 정보 조회
	UserVo selectUser(String userid);
	
	Map<String, Object> selectPagingUser(PageVo Vo);
	
	//사용자 정보 수정 update
	int modifyUser(UserVo userVo);
	
	//사용자 등록
	int registUser(UserVo userVo);

	//사용자 삭제
	int deleteUser(String userid);
	
}
