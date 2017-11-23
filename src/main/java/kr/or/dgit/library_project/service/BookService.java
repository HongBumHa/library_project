package kr.or.dgit.library_project.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.library_project.dao.BookDao;
import kr.or.dgit.library_project.dao.BookDaoImpl;
import kr.or.dgit.library_project.dto.Book;
import kr.or.dgit.library_project.util.MyBatisSqlSessionFactory;

public class BookService {
	private static final BookService instance = new BookService();
	
	public static BookService getInstance() {
		return instance;
	}

	public BookService() {
		// TODO Auto-generated constructor stub
	}

	public List<Book> selectBookByAll(){
		try(SqlSession sqlSession=MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			BookDao dao=new BookDaoImpl(sqlSession);
			return dao.selectBookByAll();
		}
	}
	
	public Book selectBookByCode(Book book){
		try(SqlSession sqlSession=MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			BookDao dao=new BookDaoImpl(sqlSession);
			return dao.selectBookByCode(book);
		}
	}
	
	public List<Book> selectBookBySomething(Map<String, Object> map) {
		try(SqlSession sqlSession=MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			BookDao dao=new BookDaoImpl(sqlSession);
			return dao.selectBookBySomething(map);
		}
	}
	
	public int insertBook(Book book) {
		int res=-1;
		try(SqlSession sqlSession=MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			BookDao dao=new BookDaoImpl(sqlSession);
			res=dao.insertBook(book);
			sqlSession.commit();
		}
		return res;
	}
	
	public int updateBook(Book book) {
		SqlSession sqlSession=MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();
		try {
			BookDao dao=new BookDaoImpl(sqlSession);
			System.out.println("updateBook Ser:" + book.toString());
			int res=dao.updateBook(book);
			sqlSession.commit();
			return res;
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException(e.getCause());
		}finally {
			sqlSession.close();
		}
	}
	
	public int deleteBook(Book book) {
		SqlSession sqlSession=MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();
		try {
			BookDao dao=new BookDaoImpl(sqlSession);
			System.out.println("service book : " + book.getBookCode());
			int res=dao.deleteBook(book);
			sqlSession.commit();
			return res;
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException(e.getCause());
		}finally {
			sqlSession.close();
		}
	}
	public List<Book> findselectByRank(){
		try(SqlSession sqlSession=MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			BookDao dao=new BookDaoImpl(sqlSession);
			return dao.selectByRank();
		}
	}
}
