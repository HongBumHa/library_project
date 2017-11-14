package kr.or.dgit.library_project.service;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.library_project.dto.Book;

public class TestServiceBook {
	private static BookService bookService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		bookService=new BookService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		bookService=null;
	}

	/*@Test
	public void testSelectBookByAll() {
		List<Book> lists=bookService.selectBookByAll();
		Assert.assertNotNull(lists);
	}
	
	@Test
	public void testSelectBookBySomething() {
		Book book=new Book();
		book.setAuthor("배재진");
		
		Book findBook=bookService.selectBookBySomething(book);
		
	}*/
	
	/*@Test
	public void testInsertBook() {
		Book book=new Book("Z0000001", "짜증나는 mybatis", "배재진", "0001", 450000, 5);
		int res=bookService.insertBook(book);
	}
	
	@Test
	public void testUpdateBook() {
		Book book=new Book();
		book.setBookCode("z0000001");
		book.setBookName("mybatis는 왜쓰는걸까?");
		book.setAuthor("배재진님");
		book.setPublicName("0005");
		book.setPrice(1000000);
		book.setAmount(1);
		
		int result=bookService.updateBook(book);
	}*/
	
	/*@Test
	public void testDeleteBook() {
		Book book=new Book();
		book.setAuthor("배재진");
		int deleteBook=bookService.deleteBook(book);
	}*/


}
