package kr.or.dgit.library_project.dao;

import java.util.List;

import kr.or.dgit.library_project.dto.BookGroup;

public interface BookGroupDao {
	public List<BookGroup> selectAllBookBigGroup();
	public List<BookGroup> selectAllMiddleGroup(BookGroup bookGroup);
	public BookGroup selectByNoBigGroup(BookGroup bookGroup);
	public BookGroup selectByNoMiddleGroup(BookGroup bookGroup);
}
