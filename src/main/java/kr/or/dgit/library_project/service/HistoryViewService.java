package kr.or.dgit.library_project.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.library_project.dao.HistoryViewDao;
import kr.or.dgit.library_project.dao.HistoryViewDaoImpl;
import kr.or.dgit.library_project.dto.HistoryView;
import kr.or.dgit.library_project.util.MyBatisSqlSessionFactory;

public class HistoryViewService {
	private static final HistoryViewService instance= new HistoryViewService();
	private HistoryViewService() {}
	
	public static HistoryViewService getInstance() {
		return instance;
	}

	public List<HistoryView> findAllHistoryViewData(){
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			HistoryViewDao dao = new HistoryViewDaoImpl(sqlSession);
			return dao.selectAllHistoryView();
		}
	}
	
	public List<HistoryView> findWhereHistoryViewData(HistoryView historyView){
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			HistoryViewDao dao = new HistoryViewDaoImpl(sqlSession);
			return dao.selectByWhereHistoryView(historyView);
		}
	}
	
	public List<HistoryView> findUserHistoryVide(HistoryView users){
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			HistoryViewDao dao = new HistoryViewDaoImpl(sqlSession);
			return dao.selectByUserHistory(users);
		}
	}
}
