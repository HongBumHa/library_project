package kr.or.dgit.library_project.dao;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.library_project.dto.Reading;

public class ReadingDaoImpl implements ReadingDao {
	private SqlSession sqlSession;
	private String namespace="kr.or.dgit.library_project.dao.ReadingDao.";
	private static final Log log=LogFactory.getLog(BookDaoImpl.class);
	
	public ReadingDaoImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Reading> selectByAll() {
		log.debug("selectByAll()");
		return sqlSession.selectList(namespace+"selectByAll");
	}

	@Override
	public int insertReading(Reading book) {
		log.debug("insertReading()");
		return sqlSession.insert(namespace+"insertReading",book);
	}

	@Override
	public int deleteReading(Reading book) {
		log.debug("deleteReading()");
		return sqlSession.delete(namespace+"deleteReading",book);
	}

}
