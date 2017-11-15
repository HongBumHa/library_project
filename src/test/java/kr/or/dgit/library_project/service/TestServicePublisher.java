package kr.or.dgit.library_project.service;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.library_project.dto.Publisher;
import kr.or.dgit.library_project.service.PublisherService;

public class TestServicePublisher {

	private static PublisherService publisherService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		publisherService=new PublisherService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		publisherService=null;
	}

	/*@Test
	public void testSelectPublisherByAll() {
		List<Publisher> lists=publisherService.selectPublisherByAll();
		Assert.assertNotNull(lists);
	}
	
	@Test
	public void testSelectPublisherByCodeName() {
		Publisher publisher=new Publisher();
		publisher.setPublicName("한빛미디어");
		
		Publisher findPublisher=publisherService.selectPublisherByCodeName(publisher);
		Assert.assertNotNull( findPublisher.getPublicCode());
	}*/
	
	/*@Test
	public void testInsertPublisher() {
		Publisher publisher=new Publisher("0006", "재진사");
		int res=publisherService.insertPublisher(publisher);
	}
	
	@Test
	public void testUpdatePublisher() {
		Publisher publisher=new Publisher();
		publisher.setPublicCode("0006");
		publisher.setPublicName("DGIT");
		
		int result=publisherService.updatePublisher(publisher);
		
	}*/
	
	/*@Test
	public void testDeletePublisher() {
		Publisher publisher=new Publisher();
		publisher.setPublicName("0006");
		
		int deletePublisher=publisherService.deletePublisher(publisher);
	}*/

}
