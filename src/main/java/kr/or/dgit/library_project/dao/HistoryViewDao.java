package kr.or.dgit.library_project.dao;

import java.util.List;

import kr.or.dgit.library_project.dto.HistoryView;

public interface HistoryViewDao {
	public List<HistoryView> selectAllHistoryView();
	public List<HistoryView> selectByWhereHistoryView(HistoryView historyView);
}
