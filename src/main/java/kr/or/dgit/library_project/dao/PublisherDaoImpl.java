package kr.or.dgit.library_project.dao;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.library_project.dto.Publisher;

public class PublisherDaoImpl implements PublisherDao {
	
	private SqlSession sqlSession;
	private String namespace="kr.or.dgit.library_project.dao.PublisherDao.";
	private static final Log log=LogFactory.getLog(PublisherDaoImpl.class);
	
	
	
	public PublisherDaoImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}



	@Override
	public List<Publisher> selectPublisherByAll() {
		log.debug("selectPublisherByAll()");
		return sqlSession.selectList(namespace+"selectPublisherByAll");
	}


	@Override
	public Publisher selectPublisherByCodeName(Publisher publisher) {
		log.debug("selectPublisherByCodeName()");
		return sqlSession.selectOne(namespace+"selectPublisherByCodeName", publisher);
	}

}
