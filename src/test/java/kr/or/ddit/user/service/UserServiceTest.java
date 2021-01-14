package kr.or.ddit.user.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.repository.UserDao;
import kr.or.ddit.user.repository.UserDaoI;

public class UserServiceTest {
	UserServiceI userService = new UserService();
	
	@Before
		public void setup() { 
		
		UserVo userVo = new UserVo("testUser", "테스트사용자", "testUserPass", new Date(),
								"대덕", "대전 중구 중앙로", "4층", "123");
	
		userService.registUser(userVo);
	
		//신규 입력 테스트를 위해 테스트 과정에서 입력된 데이터를 삭제
		userService.deleteUser("ddit_n");
	
	
		}

	@After
		public void tearDown() {
		userService.deleteUser("testUser");
		}
	
	@Test
	public void deleteUser() {
		/***Given***/
		
		String userid = "dditttt";
		
		/***When***/
		int registCnt = userService.deleteUser(userid);
		
		/***Then***/
		assertEquals(1, registCnt);
	}
	
	@Test
	public void selectAllUserTest() {
		/***Given***/
		

		/***When***/
		List<UserVo> userList = userService.selectAllUser();

		/***Then***/
		assertEquals(19,userList.size());
	}
	// 사용자 아이디를 이용하여 특정 사용자 정보 조회
	@Test
	public void selectUserTest() {
		/***Given***/
	
		String userid = "brown";

		/***When***/
		UserVo user = userService.selectUser(userid);
		
		/***Then***/
		assertNotNull(user);
		assertEquals("브라운", user.getUsernm());
	}

	//사용자 아이디가 존재하지 않을 때, 특정 사용자 조회
	@Test
	public void selectUserNotExsistTest() {
		/***Given***/
		
		String userid = "brownfsdfafd";

		/***When***/
		UserVo user = userService.selectUser(userid);
		
		/***Then***/
		assertNull(user);
		
	}
	
	//사용자 페이징 조회 테스트
	@Test
	public void selectPagingUserTest() {
		/***Given***/
		
		PageVo page = new PageVo(2,5);

		/***When***/
		Map<String, Object> map = userService.selectPagingUser(page);
		List<UserVo> userList = (List<UserVo>)map.get("userList");
		int userCnt = (int)map.get("userCnt");
		
		/***Then***/
		assertNotNull(userList);
		assertEquals(5, userList.size());
	}
	@Test
	public void modifyUserTest() {
		/***Given***/
		
		UserVo userVo = new UserVo("dditttt", "대덕인재", "dditpass", new Date(),
				"개발원_m", "대전시 중구 영민빌딩", "4층", "123");

		/***When***/
		int updateCnt = userService.modifyUser(userVo);
		
		/***Then***/
		assertEquals(1, updateCnt);
	}
	
	@Test
	public void registUser() {
		/***Given***/
		
		UserVo userVo = new UserVo("dditttt", "대덕인재", "dditpass", new Date(),
				"개발원_m", "대전시 중구 영민빌딩", "4층", "123");
		
		/***When***/
		int registCnt = userService.registUser(userVo);
		
		/***Then***/
		assertEquals(1, registCnt);
	}

	

}
