package kr.or.dgit.library_project.dao;

import java.util.List;
import java.util.Map;

import kr.or.dgit.library_project.dto.HistoryView;

public interface HistoryViewDao {
	public List<HistoryView> selectAllHistoryView();
	public List<HistoryView> selectByWhereHistoryView(HistoryView historyView);
	
//	유저 히스토리
	List<HistoryView> selectByUserHistory(HistoryView users);   

	// manager historyView
	public List<HistoryView> selectAllHistoryViewMap();
	public List<HistoryView> selectByWhereHistoryViewMap(Map<String, Object> map);
	   
}
