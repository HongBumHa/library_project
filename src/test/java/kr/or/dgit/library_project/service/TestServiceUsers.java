package kr.or.dgit.library_project.service;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.library_project.dto.Users;

public class TestServiceUsers {
	private static UsersService service;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = new UsersService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}

	@Test
	public void testFindUsersByAll() {
		List<Users> lists = service.findUsersByAll();
		Assert.assertNotNull(lists);
	}

}
