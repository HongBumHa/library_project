package kr.or.dgit.library_project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.library_project.dto.Users;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestServiceUsers {
	private static UsersService service;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service =  UsersService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}

/*	@Test
	public void testAFindUsersByAll() {
		List<Users> lists = service.findUsersByAll();
		Assert.assertNotNull(lists);
	}
	@Test
	public void testAFindinsertUser() {
		Users users = new Users("test1", "test1", "test1", "test1", "test1","test1",0,1,"y");		
		int res = service.findinsertUser(users);
		Assert.assertEquals(1, res);
	}
	@Test
	public void testCFindupdateUser() {
		Users users = new Users("test1", "test2", "test2", "test2", "test2","test2",1,2,"n");		
		int res = service.findupdateUsers(users);
		Assert.assertEquals(1, res);
	}*/
	
	/*@Test
	public void testDFindselectByNo() {
		Users users = new Users("test1");
		Users users1 = service.findUsersByNo(users);
		
		Assert.assertNotNull(users1);
	}*/
	
/*	@Test
	public void test2FinddeleteById() {
		String id = "test1";
		int res = service.finddeleteUsers(id);
		
		Assert.assertEquals(1, res);
	}*/
	
	/*@Test
	public void testFIndselectByUserList() {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("userId", "tes%");
		List<Users> lists = service.findSelectByUserList(map);
		Assert.assertNotNull(lists);
	}*/
	
}
