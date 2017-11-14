package kr.or.dgit.library_project.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.library_project.dao.BookDao;
import kr.or.dgit.library_project.dao.BookDaoImpl;
import kr.or.dgit.library_project.dto.Book;
import kr.or.dgit.library_project.util.MyBatisSqlSessionFactory;

public class BookService {
	public List<Book> selectBookByAll(){
		try(SqlSession sqlSession=MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			BookDao dao=new BookDaoImpl(sqlSession);
			return dao.selectBookByAll();
		}
	}
	
	public Book selectBookBySomething(Book book) {
		try(SqlSession sqlSession=MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			BookDao dao=new BookDaoImpl(sqlSession);
			return dao.selectBookBySomething(book);
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
}
