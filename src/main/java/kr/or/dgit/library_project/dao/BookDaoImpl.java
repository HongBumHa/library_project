package kr.or.dgit.library_project.dao;

import java.util.List;

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
	public List<Book> selectBookBySomething(Book book) {
		log.debug("selectBookBySomething()");
		return sqlSession.selectList(namespace+"selectBookBySomething", book);
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

}
