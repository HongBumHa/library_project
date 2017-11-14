package kr.or.dgit.library_project.dao;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.library_project.dto.BookGroup;

public class BookGroupDaoImpl implements  BookGroupDao{
	
	private SqlSession sqlSession;
	private static final Log log = LogFactory.getLog(BookGroupDao.class);
	private String namespace = "kr.or.dgit.library_project.dao.BookGroupDao";
	
	public BookGroupDaoImpl(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<BookGroup> selectAllBookBigGroup() {
		log.debug("selectAllBookBigGroup()");
		return sqlSession.getMapper(BookGroupDao.class).selectAllBookBigGroup();
	}

	@Override
	public List<BookGroup> selectAllMiddleGroup(BookGroup bookGroup) {
		log.debug("selectAllMiddleGroup()");
		return sqlSession.getMapper(BookGroupDao.class).selectAllMiddleGroup(bookGroup);
	}

	@Override
	public BookGroup selectByNoBigGroup(BookGroup bookGroup) {
		log.debug("selectByNoBookBigGroup()");
		return sqlSession.selectOne(namespace+".selectByNoBigGroup", bookGroup);
	}

	@Override
	public BookGroup selectByNoMiddleGroup(BookGroup bookGroup) {
		log.debug("selectByNoMiddleGroup()");
		return sqlSession.selectOne(namespace+".selectByNoMiddleGroup", bookGroup);
	}
	
}
