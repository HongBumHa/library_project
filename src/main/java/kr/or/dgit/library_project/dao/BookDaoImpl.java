package kr.or.dgit.library_project.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.library_project.dto.Book;

public class BookDaoImpl implements BookDao {

	private SqlSession sqlSession;
	private String namespace="kr.or.dgit.library_project.dao.BookDao.";
	private static final Log log=LogFactory.getLog(BookDaoImpl.class);

	public BookDaoImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Book> selectBookByAll() {
		log.debug("selectBookByAll()");
		return sqlSession.selectList(namespace+"selectBookByAll");
	}

	@Override
	public Book selectBookByCode(Book book) {
		log.debug("selectBookByCode()");
		return sqlSession.selectOne(namespace+"selectBookByCode", book);
	}
	
	@Override
	public List<Book> selectBookBySomething(Map<String, Object> map) {
		log.debug("selectBookBySomething()");
		return sqlSession.selectList(namespace+"selectBookBySomething", map);
	}

	@Override
	public Book selectBookForChart(Book book) {
		log.debug("selectBookForChart()");
		return sqlSession.selectOne(namespace+"selectRentalCountForChart", book);
	}
	
	@Override
	public Book selectBookGroupRow(Book book) {
		log.debug("selectBookGroupRow()");
		return sqlSession.selectOne(namespace+"selectBookGroupRow", book);
	}
	
	@Override
	public int insertBook(Book book) {
		log.debug("insertBook()");
		return sqlSession.insert(namespace+"insertBook", book);
	}

	@Override
	public int updateBook(Book book) {
		log.debug("updateBook()");
		return sqlSession.update(namespace+"updateBook",book);
	}

	@Override
	public int deleteBook(Book book) {
		log.debug("deleteBook()");
		return sqlSession.delete(namespace+"deleteBook", book);
	}

	@Override
	public List<Book> selectByRank() {
		log.debug("selectByRank()");
		return sqlSession.selectList(namespace+"selectByRank");
	}

	@Override
	public List<Book> selectByWhereBookData(Book book) {
		log.debug("selectByWhereBookData()");
		return sqlSession.selectList(namespace+"selectByWhereBookData", book);
	}

	@Override
	public List<Book> selectByBigMiddleGroupCode(Book book) {
		log.debug("selectByBigMiddleGroupCode()");
		return sqlSession.selectList(namespace+"selectByBigMiddleGroupCode", book);
	}
}
