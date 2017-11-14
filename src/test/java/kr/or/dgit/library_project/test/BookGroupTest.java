package kr.or.dgit.library_project.test;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.library_project.dto.BookGroup;
import kr.or.dgit.library_project.dto.RentalView;
import kr.or.dgit.library_project.service.BookGroupService;
import kr.or.dgit.library_project.service.RentalViewService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BookGroupTest {

	private static BookGroupService bookGroupService;
	private static RentalViewService rentalViewService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		bookGroupService = new BookGroupService();
		rentalViewService = new RentalViewService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		bookGroupService = null;
	}

	/*@Test
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
	
	@Test
	public void test1_3FindByNoBookBigGroup() {
		BookGroup bookGroup = new BookGroup();
		bookGroup.setBigGroup("A0");
		
		BookGroup data = bookGroupService.findByNoBigGroup(bookGroup);
		Assert.assertNotNull(data);
	}

	@Test
	public void test1_4FindByNoMiddleGroup() {
		BookGroup bookGroup = new BookGroup();
		bookGroup.setBigGroup("A0");
		bookGroup.setMiddleGroup("00");
		
		BookGroup data = bookGroupService.findByNoMiddleGroup(bookGroup);
		Assert.assertNotNull(data);
	}
	
	@Test
	public void test1_5FindAllRentalView() {
		List<RentalView> lists = rentalViewService.findAllRentalView();
		Assert.assertNotNull(lists);
	}*/
	
	@Test
	public void test1_6FindByWhereRentalView() {
		RentalView rentalView = new RentalView();
		rentalView.setUserId("test");
		
//		List<RentalView> lists = rentalViewService.findByWhereRentalView(rentalView);
		
		Vector<RentalView> vec = rentalViewService.findByWhereRentalView(rentalView);
		
		Assert.assertNotNull(vec);
	}
	
	/*@Test
	public void test1_7FindByWhereRentalView() {
		RentalView rentalView = new RentalView();
		Date insertDate = rentalView.parseDate("2017-11-12");
		rentalView.setRentalDay(insertDate);
		
		List<RentalView> lists = rentalViewService.findByWhereRentalView(rentalView);
		Assert.assertNotNull(lists);
	}
	
	@Test
	public void test1_9FindByWhereRentalView() {
		RentalView rentalView = new RentalView();
		rentalView.setUserName("test");
		
		List<RentalView> lists = rentalViewService.findByWhereRentalView(rentalView);
		Assert.assertNotNull(lists);
	}
	
	@Test
	public void test2_1FindByWhereRentalView() {
		RentalView rentalView = new RentalView();
		rentalView.setAuthor("프라사드 머크헤드카");
		
		List<RentalView> lists = rentalViewService.findByWhereRentalView(rentalView);
		Assert.assertNotNull(lists);
	}
	
	@Test
	public void test2_2FindByWhereRentalView() {
		RentalView rentalView = new RentalView();
		rentalView.setBookCode("A0000551");
		
		List<RentalView> lists = rentalViewService.findByWhereRentalView(rentalView);
		Assert.assertNotNull(lists);
	}*/
	
}
