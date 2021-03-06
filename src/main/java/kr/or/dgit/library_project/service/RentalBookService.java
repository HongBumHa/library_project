package kr.or.dgit.library_project.service;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.library_project.dao.RentalBookDao;
import kr.or.dgit.library_project.dao.RentalBookDaoImpl;
import kr.or.dgit.library_project.dto.RentalBook;
import kr.or.dgit.library_project.dto.Users;
import kr.or.dgit.library_project.util.MyBatisSqlSessionFactory;

public class RentalBookService {
	private static final RentalBookService instance=new RentalBookService();
	
	public static RentalBookService getInstance() {
		return instance;
	}
	

	public RentalBookService() {
		// TODO Auto-generated constructor stub
	}


	public int insertDataRentalBook(RentalBook rentalBook){
		int res = -1;
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			RentalBookDao dao = new RentalBookDaoImpl(sqlSession);
			res = dao.insertData(rentalBook);
			sqlSession.commit();
		}
		return res;
	}
	
	public int deleteDataByWhereRentalBook(RentalBook rentalBook){
		int res = -1;
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			RentalBookDao dao = new RentalBookDaoImpl(sqlSession);
			res = dao.deleteByWhereRentalBook(rentalBook);
			sqlSession.commit();
		}
		return res;
	}
	
	public RentalBook findselectByUserRentalbookCount(Users user) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			RentalBookDao dao = new RentalBookDaoImpl(sqlSession);
			return dao.selectByUserRentalCount(user);
		}
	
	}
}
