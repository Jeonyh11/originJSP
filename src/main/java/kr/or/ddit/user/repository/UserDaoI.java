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
	
	//사용자 정보 수정 List<UserVo> modifyUser(String userid);보다 업데이트 성공하면 1을 반환하므로 int로 선언
	int modifyUser(UserVo userVo);
	//int modifyUser(String userid, String usernm); 이렇게 하나하나 받아오면 불안정하고 값이 하나하나 달라진다
	
	//사용자 등록
	int registUser(UserVo userVo);

	//사용자 삭제
	int deleteUser(String userid);
	
	
	
}
