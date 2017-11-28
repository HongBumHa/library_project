package kr.or.dgit.library_project.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.library_project.dao.PostDao;
import kr.or.dgit.library_project.dao.PostDaoImpl;
import kr.or.dgit.library_project.dto.Post;
import kr.or.dgit.library_project.util.MyBatisSqlSessionFactory;

public class PostService {
	private static final PostService instance = new PostService();

	public static PostService getInstance() {
		return instance;
	}

	private PostService() {}
	
	public List<Post> findSelectByDoroList(Post post){
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			PostDao dao = new PostDaoImpl(sqlSession);
			return dao.selectByDoroList(post);
		}
	}
	
	public List<Post> findPostBysido(){
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			PostDao dao = new PostDaoImpl(sqlSession);
			return dao.selectBysidoList();
		}
	}
	
}
