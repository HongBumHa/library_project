package kr.or.dgit.library_project.test;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.library_project.dto.RentalBook;
import kr.or.dgit.library_project.dto.RentalView;
import kr.or.dgit.library_project.service.RentalBookService;
import kr.or.dgit.library_project.service.RentalViewService;

public class RentalBookTest {

	private static RentalBookService rentalBookService;
	private static RentalViewService rentalViewService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		rentalBookService = new RentalBookService();
		rentalViewService = new RentalViewService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		rentalBookService = null;
		rentalViewService = null;
	}

	/*@Test
	public void test1_1InsertDataRentalBook() {
		RentalBook rentalBook = new RentalBook();
		rentalBook.setBookCode("A0001321");
		rentalBook.setUserId("test");
		
		Date rentalDay = rentalBook.parseDate("2017-11-13");
		rentalBook.setRentalDay(rentalDay);
		
		Date returnDay = rentalBook.parseDate("2017-11-27");
		rentalBook.setReturnDay(returnDay);
		
		int res = rentalBookService.insertDataRentalBook(rentalBook);
		
		Assert.assertEquals(1, res);
	}*/
	
	/*@Test
	public void test1_2DeleteDataByWhereRentalBook() {
		RentalBook rentalBook = new RentalBook();
		rentalBook.setBookCode("A0001321");
		rentalBook.setUserId("test");
		
		int res = rentalBookService.deleteDataByWhereRentalBook(rentalBook);
		
		Assert.assertEquals(1, res);
	}*/

}
