package kr.or.dgit.library_project.test;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.library_project.dto.HistoryView;
import kr.or.dgit.library_project.service.HistoryViewService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HistoryViewTest {

	private static HistoryViewService historyViewService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		historyViewService = new HistoryViewService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		historyViewService = null;
	}

	/*@Test
	public void test1_1FindAllHistoryViewData() {
		List<HistoryView> lists = historyViewService.findAllHistoryViewData();
		Assert.assertNotNull(lists);
	}*/
	
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
}
