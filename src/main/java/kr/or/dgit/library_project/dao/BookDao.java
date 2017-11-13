package kr.or.dgit.library_project.dao;

import java.util.List;

import kr.or.dgit.library_project.dto.Book;

public interface BookDao {
	List<Book> selectBookByAll(Book book);
}
