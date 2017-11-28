package kr.or.dgit.library_project.dao;

import java.util.List;

import kr.or.dgit.library_project.dto.Reading;

public interface ReadingDao {
	List<Reading> selectByAll();
	int insertReading(Reading book);
	int deleteReading(Reading book);
}
