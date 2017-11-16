package kr.or.dgit.library_project.service;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.library_project.dto.Post;

public class TestServicePost {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void Test1sido() {
		List<Post> lists = PostService.getInstance().findPostBysido();
		Assert.assertNotNull(lists);
	}
	
	@Test
	public void Test2sigungu() {
		Post post = new Post();
		post.setSido("대구광역시");
		List<Post> lists = PostService.getInstance().findPostBySigungu(post);
		Assert.assertNotNull(lists);
	}
}
