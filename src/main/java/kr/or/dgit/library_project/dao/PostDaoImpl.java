package kr.or.dgit.library_project.dao;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.library_project.dto.Post;

public class PostDaoImpl implements PostDao {
	private SqlSession sqlSession;
	private static final Log log=LogFactory.getLog(PostDaoImpl.class);
	
	public PostDaoImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Post> selectByDoroList(Post post) {
		log.debug("selectByDoroList()");
		return sqlSession.getMapper(PostDao.class).selectByDoroList(post);
	}
	@Override
	public List<Post> selectBysidoList() {
		log.debug("selectBysidoList()");
		return sqlSession.getMapper(PostDao.class).selectBysidoList();
	}

}
