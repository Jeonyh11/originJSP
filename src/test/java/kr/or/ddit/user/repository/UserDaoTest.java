package kr.or.ddit.user.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public class UserDaoTest {

	@Test
	public void selectAllUserTest() {
		/***Given***/
		UserDaoI userDao = new UserDao();
		

		/***When***/
		List<UserVo> userList = userDao.selectAllUser();

		/***Then***/
		assertEquals(16,userList.size());
	}
	// 사용자 아이디를 이용하여 특정 사용자 정보 조회
	@Test
	public void selectUserTest() {
		/***Given***/
		UserDaoI userDao = new UserDao();
		String userid = "brown";

		/***When***/
		UserVo user = userDao.selectUser(userid);
		
		/***Then***/
		assertNotNull(user);
		assertEquals("브라운", user.getUsernm());
	}

	//사용자 페이징 조회 테스트
	@Test
	public void selectPagingUserTest() {
		/***Given***/
		UserDaoI userDao = new UserDao();
		PageVo page = new PageVo(2,5);

		/***When***/
		List<UserVo> userList = userDao.selectPagingUser(page);
		
		/***Then***/
		assertNotNull(userList);
		assertEquals(5, userList.size());
	}


@Test
public void selectAllUserCntTest() {
	/***Given***/
	UserDaoI userDao = new UserDao();

	/***When***/
	int userCnt = userDao.selectAllUserCnt();
	/***Then***/
	assertEquals(16, userCnt);
}
}



