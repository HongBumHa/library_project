package kr.or.dgit.library_project.dao;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.library_project.dto.UserRank;

public class UserRankDaoImpl implements UserRankDao {
	private SqlSession sqlSession;
	private static final Log log = LogFactory.getLog(UserRankDaoImpl.class);

	public UserRankDaoImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<UserRank> selectUserRankByAll() {
		log.debug("selectUserRankByAll()");
		return sqlSession.getMapper(UserRankDao.class).selectUserRankByAll();
	}
}
