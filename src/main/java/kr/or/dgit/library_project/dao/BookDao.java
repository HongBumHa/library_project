package kr.or.dgit.library_project.dao;

import java.util.List;
import java.util.Map;

import kr.or.dgit.library_project.dto.Book;

public interface BookDao {
	List<Book> selectBookByAll();
	List<Book> selectBookBySomething(Map<String, Object> map);
	Book selectBookByCode(Book book);
	Book selectBookForChart(Book book);
	Book selectBookGroupRow(Book book);
	int insertBook(Book Book);
	int updateBook(Book book);
	int deleteBook(Book book);
	
	List<Book> selectByRank();
}
