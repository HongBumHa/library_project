package kr.or.dgit.library_project.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.library_project.dao.PublisherDao;
import kr.or.dgit.library_project.dao.PublisherDaoImpl;
import kr.or.dgit.library_project.dto.Publisher;
import kr.or.dgit.library_project.util.MyBatisSqlSessionFactory;

public class PublisherService{

	public List<Publisher> selectPublisherByAll() {
		try(SqlSession sqlSession=MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			PublisherDao dao=new PublisherDaoImpl(sqlSession);
			return dao.selectPublisherByAll();
		}
	}
	
	public Publisher selectPublisherByCodeName(Publisher publisher) {
		try(SqlSession sqlSession=MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			PublisherDao dao=new PublisherDaoImpl(sqlSession);
			return dao.selectPublisherByCodeName(publisher);
		}
	}
}
