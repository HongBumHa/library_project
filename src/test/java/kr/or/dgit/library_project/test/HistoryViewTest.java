package kr.or.dgit.library_project.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.library_project.dto.Book;
import kr.or.dgit.library_project.dto.HistoryView;
import kr.or.dgit.library_project.service.BookService;
import kr.or.dgit.library_project.service.HistoryViewService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HistoryViewTest {

	private static HistoryViewService historyViewService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		historyViewService =  HistoryViewService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		historyViewService = null;
	}

	/*@Test
	public void test1_2FindWhereHistoryViewData() {
		HistoryView historyView = new HistoryView();
		historyView.setUserId("test");
		
		List<HistoryView> lists = historyViewService.findWhereHistoryViewData(historyView);
		Assert.assertNotNull(lists);
	}
	
	@Test
	public void test1_3FindWhereHistoryViewData() {
		HistoryView historyView = new HistoryView();
		historyView.setUserName("test");
		
		List<HistoryView> lists = historyViewService.findWhereHistoryViewData(historyView);
		Assert.assertNotNull(lists);
	}
	
	@Test
	public void test1_4FindWhereHistoryViewData() {
		HistoryView historyView = new HistoryView();
		historyView.setBookCode("A0000001");
		
		List<HistoryView> lists = historyViewService.findWhereHistoryViewData(historyView);
		Assert.assertNotNull(lists);
	}
	
	@Test
	public void test1_5FindWhereHistoryViewData() {
		HistoryView historyView = new HistoryView();
		historyView.setAuthor("이기동");
		
		List<HistoryView> lists = historyViewService.findWhereHistoryViewData(historyView);
		Assert.assertNotNull(lists);
	}
	
	@Test
	public void test1_6FindWhereHistoryViewData() {
		HistoryView historyView = new HistoryView();
		Date insertDate = historyView.parseDate("2017-11-12");
		historyView.setRentalDay(insertDate);
		
		List<HistoryView> lists = historyViewService.findWhereHistoryViewData(historyView);
		Assert.assertNotNull(lists);
	}*/
	
	/*@Test
	public void test1FineUserHistoryView() {
		HistoryView users = new HistoryView();
		users.setUserId("test3");
		List<HistoryView> lists = historyViewService.findUserHistoryVide(users);
		for(HistoryView h : lists) {
			System.out.println(h);
		}
		SimpleDateFormat dd = new SimpleDateFormat("yyyy-MM-dd");
		String date = dd.format(lists.get(0).getReturnDay());
		Assert.assertEquals(date,"2017-11-15");
	}*/
	
	/*@Test
	public void test3DeleteBookTesting() {
		Book book = new Book();
		book.setBookCode("J0092321");
		
		int res = BookService.getInstance().deleteBook(book);
		Assert.assertEquals(1, res);
	}*/
	
	/*@Test
	public void test4UpdateBookTesting() {
		Book book = new Book();
		book.setBookCode("J0091121");
		book.setBookName("최고보다는 최선을");
		book.setAuthor("박경용");
		book.setPublicName("0004");
		book.setPrice(12000);
		book.setAmount(8);
		
		int res = BookService.getInstance().updateBook(book);
		Assert.assertEquals(1, res);
	}*/
	
	/*@Test
	public void test5selectByBigMiddleGroupCode() {
		Book book = new Book();
		book.setBookCode("A000");
		List<Book> lists = BookService.getInstance().findselectByBigMiddleGroupCode(book);
		
		Assert.assertNotNull(lists);
	}*/
}
