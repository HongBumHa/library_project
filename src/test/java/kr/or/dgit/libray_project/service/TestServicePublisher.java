package kr.or.dgit.libray_project.service;

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

	@Test
	public void testSelectPubliserByAll() {
		List<Publisher> lists=publisherService.selectPublisherByAll();
		Assert.assertNotNull(lists);
	}

}
