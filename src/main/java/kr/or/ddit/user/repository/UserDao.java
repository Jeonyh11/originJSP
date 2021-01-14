package kr.or.ddit.user.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.user.model.UserVo;

public class UserDao implements UserDaoI{

	@Override
	public List<UserVo> selectAllUser() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		//select : 리턴되는 값의 복수 유무를 판단
//					1. 단건 : 일반객체를 반환(UserVo) selectOne()
//					2. 여러건 : List<UserVo> selectList()
//		  insert, update, delete ; insert, update, delete
		
		// 메소드 이름과 실행할 sql id를 동일하게 맞추자(유지보수 - 다른 개발자의 가독성)
		
		//vo는 객체만 지정이므로 DB안에 있는 값 (userid)를 가져오려면 selectAllUser() 같은 함수를 호출 해야된다.
		List<UserVo> userList = sqlSession.selectList("users.selectAllUser");
		
		//사용한 자원 반환
		sqlSession.close();
		
		return userList;
		
	}

	@Override
	public UserVo selectUser(String userid) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		UserVo user = sqlSession.selectOne("users.selectUser", userid);
		
		sqlSession.close();
		
		return user;
	}

	@Override
	public List<UserVo> selectPagingUser(PageVo Vo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		List<UserVo> userList = sqlSession.selectList("users.selectPagingUser",Vo);
		
		sqlSession.close();
		
		return userList;
	}

	@Override
	public int selectAllUserCnt() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		int userCnt = sqlSession.selectOne("users.selectAllUserCnt");
		
		sqlSession.close();
		
		return userCnt;
	}

	@Override
	public int modifyUser(UserVo userVo) {
		//SqlSession sqlSession = MybatisUtil.getSqlSession(); 이구문을 위에 선언해서 안해주고 메소드안에 계속 하는 이유는
		// 사용자별로 커낵션을 다르게 가져가야 되서 update, insert, delete로 기능이 다르므로 호출을 할때마다 사용한다.
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		int updateCnt = sqlSession.update("users.modifyUser", userVo);
		
		if(updateCnt == 1) {
			sqlSession.commit();			
		}
		else {
			sqlSession.rollback();			
		}
		
		sqlSession.close();
		
		return updateCnt;
	}

	@Override
	public int registUser(UserVo userVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		int insertCnt = sqlSession.update("users.registUser", userVo);
		
		if(insertCnt == 1) {
			sqlSession.commit();
		}
		else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return insertCnt;
	}

	@Override
	public int deleteUser(String userid) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		int deleteCnt = sqlSession.delete("users.deleteUser",userid);
		
		if(deleteCnt == 1) {
			sqlSession.commit();
		}
		else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return deleteCnt;
	}

}
