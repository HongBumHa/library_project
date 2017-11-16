package kr.or.dgit.library_project.service;

import java.util.List;
import java.util.Vector;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.library_project.dao.RentalViewDao;
import kr.or.dgit.library_project.dao.RentalViewDaoImpl;
import kr.or.dgit.library_project.dto.RentalView;
import kr.or.dgit.library_project.util.MyBatisSqlSessionFactory;

public class RentalViewService {
	
private static final RentalViewService instance = new RentalViewService();
	
	public static RentalViewService getInstance() {
		return instance;
	}

	public RentalViewService() {
		// TODO Auto-generated constructor stub
	}
	
	public List<RentalView> findAllRentalView(){
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			RentalViewDao dao = new RentalViewDaoImpl(sqlSession);
			return dao.selectAllRentalView();
		}
	}
	
	public List<RentalView> findByWhereRentalView(RentalView rentalView){
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			RentalViewDao dao = new RentalViewDaoImpl(sqlSession);
			return dao.selectByWhereRentalView(rentalView);
		}
	}
}
