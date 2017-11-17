package kr.or.dgit.library_project.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.library_project.dao.UsersDao;
import kr.or.dgit.library_project.dao.UsersDaoImpl;
import kr.or.dgit.library_project.dto.Users;
import kr.or.dgit.library_project.util.MyBatisSqlSessionFactory;

public class UsersService {
	private static final UsersService instance = new UsersService();
	private UsersService() {}
	public static  UsersService getInstance() {
		return instance;
	}
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
	
	public List<Users> findSelectByUserList(Map<String,Object> map){
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			UsersDao dao = new UsersDaoImpl(sqlSession);
			return dao.selectByUserList(map);
		}
	}

}
