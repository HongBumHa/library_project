package kr.or.dgit.library_project.dao;

import java.util.List;

import kr.or.dgit.library_project.dto.Publisher;

public interface PublisherDao {
	List<Publisher> selectPublisherByAll();
	Publisher selectPublisherByCodeName(Publisher publisher);
	int insertPublisher(Publisher publisher);
	int updatePublisher(Publisher publisher);
	int deletePublisher(Publisher publisher);
	
}
