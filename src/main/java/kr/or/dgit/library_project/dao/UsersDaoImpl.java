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


}
