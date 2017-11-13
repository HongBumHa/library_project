package kr.or.dgit.library_project.dao;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.library_project.dto.Users;

public class UsersDaoImpl implements UsersDao{
	private SqlSession sqlSession;
	private static final Log log = LogFactory.getLog(UsersDaoImpl.class);
	
	
	public UsersDaoImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}


	@Override
	public List<Users> selectUserByAll() {
		log.debug("selectUserByAll()");
		return sqlSession.getMapper(UsersDao.class).selectUserByAll();
	}


	@Override
	public int insertUser(Users users) {
		log.debug("insertUser()");
		return sqlSession.getMapper(UsersDao.class).insertUser(users);
	}


	@Override
	public int deleteUsers(String id) {
		log.debug("deleteSql()");
		return sqlSession.getMapper(UsersDao.class).deleteUsers(id);
	}


	@Override
	public Users selectUsersByNo(Users users) {
		log.debug("selectUsersByNo()");
		return sqlSession.getMapper(UsersDao.class).selectUsersByNo(users);
	}


	@Override
	public int updateUser(Users users) {
		log.debug("updateUser()");
		return sqlSession.getMapper(UsersDao.class).updateUser(users);
	}


}
