package kr.or.dgit.library_project.dao;

import java.util.List;

import kr.or.dgit.library_project.dto.Post;

public interface PostDao {
	List<Post> selectByDoroList(Post post);
	List<Post> selectBysidoList();
}
