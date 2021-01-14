package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.repository.UserDao;
import kr.or.ddit.user.repository.UserDaoI;

public class UserService implements UserServiceI{
	
	UserDaoI userDao = new UserDao();
	   
	   @Override
	   public List<UserVo> selectAllUser() {
	      return userDao.selectAllUser();
	   }

	   @Override
	   public UserVo selectUser(String userid) {
	      return userDao.selectUser(userid);
	   }

	   @Override
	   public Map<String, Object> selectPagingUser(PageVo Vo) {
		   Map<String, Object> map = new HashMap<String, Object>();
		   
		   List<UserVo> userList = userDao.selectPagingUser(Vo);
		   int userCnt = userDao.selectAllUserCnt();
		   
		   map.put("userList", userList);
		   map.put("userCnt", userCnt);
	      return map;
	   }

	@Override
	public int modifyUser(UserVo userVo) {
		int updateCnt = userDao.modifyUser(userVo);
				
		return updateCnt;
	}

	@Override
	public int registUser(UserVo userVo) {		
		
		
		int insertCnt = userDao.registUser(userVo);
//		try {
//		return userDao.registUser(userVo);
//		}catch(Exception e) {
//		return 0;
//		}
		return insertCnt;
	}

	@Override
	public int deleteUser(String userid) {
		
		return userDao.deleteUser(userid);
	}
	   
	  
}