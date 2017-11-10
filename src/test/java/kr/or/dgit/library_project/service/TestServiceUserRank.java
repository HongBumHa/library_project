package kr.or.dgit.library_project.service;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.library_project.dto.UserRank;
import kr.or.dgit.library_project.service.UserRankService;


public class TestServiceUserRank {
	private static UserRankService service;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = new UserRankService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}
	
	/*@Test
	public void testFindUserRankByAll() {
		List<UserRank> lists = service.findUserRankByAll();
		System.out.println(lists);
		Assert.assertNotNull(lists);
	}*/
}
