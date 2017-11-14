package kr.or.dgit.library_project.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.library_project.dao.UserRankDaoImpl;
import kr.or.dgit.library_project.dto.UserRank;
import kr.or.dgit.library_project.util.MyBatisSqlSessionFactory;


public class UserRankService {
	
	public List<UserRank> findUserRankByAll(){
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			UserRankDaoImpl dao = new UserRankDaoImpl(sqlSession);
			return dao.selectUserRankByAll();
		}
	}
}
