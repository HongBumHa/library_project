package kr.or.dgit.library_project.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.library_project.dao.UsersDao;
import kr.or.dgit.library_project.dao.UsersDaoImpl;
import kr.or.dgit.library_project.dto.Users;
import kr.or.dgit.library_project.util.MyBatisSqlSessionFactory;

public class UsersService {
	public List<Users> findUsersByAll(){
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			UsersDao dao = new UsersDaoImpl(sqlSession);
			return dao.selectUserByAll();
		}
	}
}
