package kr.or.dgit.library_project.test;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.library_project.dto.BookGroup;
import kr.or.dgit.library_project.service.BookGroupService;

public class BookGroupTest {

	private static BookGroupService bookGroupService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		bookGroupService = new BookGroupService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		bookGroupService = null;
	}

	@Test
	public void test1_1FindAllBookBigGroup() {
		List<BookGroup> lists = bookGroupService.findAllBookBigGroup();
		Assert.assertNotNull(lists);
	}
	
	@Test
	public void test1_2FindAllBookMiddelGroup() {
		BookGroup bookGroup = new BookGroup();
		bookGroup.setBigGroup("A0");
		
		List<BookGroup> lists = bookGroupService.findAllMiddleGroup(bookGroup);
		Assert.assertNotNull(lists);
	}

}
