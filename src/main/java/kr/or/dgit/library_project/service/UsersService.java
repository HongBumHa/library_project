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
	public Users findUsersByNo(Users users) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			UsersDao dao = new UsersDaoImpl(sqlSession);
			return dao.selectUsersByNo(users);
		}
	}
	public int findinsertUser(Users users) {
		int res = -1;
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			UsersDao dao = new UsersDaoImpl(sqlSession);
			res =  dao.insertUser(users);
			sqlSession.commit();
		}
		return res;
		
	}
	
	public int finddeleteUsers(String id) {
		int res = -1;
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			UsersDao dao = new UsersDaoImpl(sqlSession);
			res =  dao.deleteUsers(id);
			sqlSession.commit();
		}
		return res;	
	}
	
	public int findupdateUsers(Users users) {
		int res = -1;
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			UsersDao dao = new UsersDaoImpl(sqlSession);
			res =  dao.updateUser(users);
			sqlSession.commit();
		}
		return res;
	}
	
	
}
