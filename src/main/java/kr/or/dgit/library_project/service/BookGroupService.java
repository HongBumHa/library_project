package kr.or.dgit.library_project.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.library_project.dao.BookGroupDao;
import kr.or.dgit.library_project.dao.BookGroupDaoImpl;
import kr.or.dgit.library_project.dto.BookGroup;
import kr.or.dgit.library_project.util.MyBatisSqlSessionFactory;

public class BookGroupService {
	public List<BookGroup> findAllBookBigGroup(){
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			BookGroupDao dao = new BookGroupDaoImpl(sqlSession);
			return dao.selectAllBookBigGroup();
		}
	}
	
	public List<BookGroup> findAllMiddleGroup(BookGroup bookGroup){
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			BookGroupDao dao = new BookGroupDaoImpl(sqlSession);
			return dao.selectAllMiddleGroup(bookGroup);
		}
	}
	
	public BookGroup findByNoBigGroup(BookGroup bookGroup){
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			BookGroupDao dao = new BookGroupDaoImpl(sqlSession);
			return dao.selectByNoBigGroup(bookGroup);
		}
	}
	
	public BookGroup findByNoMiddleGroup(BookGroup bookGroup){
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			BookGroupDao dao = new BookGroupDaoImpl(sqlSession);
			return dao.selectByNoMiddleGroup(bookGroup);
		}
	}
}
