package kr.or.dgit.library_project.dao;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.library_project.dto.HistoryView;

public class HistoryViewDaoImpl implements HistoryViewDao {

	private SqlSession sqlSession;
	   private static final Log log = LogFactory.getLog(HistoryViewDao.class);
	   private String namespace = "kr.or.dgit.library_project.dao.HistoryDao";
	   
	   public HistoryViewDaoImpl(SqlSession sqlSession) {
	      super();
	      this.sqlSession = sqlSession;
	   }
	   
	   @Override
	   public List<HistoryView> selectAllHistoryView() {
	      log.debug("selectAllHistoryView()");
	      return sqlSession.getMapper(HistoryViewDao.class).selectAllHistoryView();
	   }

	   @Override
	   public List<HistoryView> selectByWhereHistoryView(HistoryView historyView) {
	      log.debug("selectAllHistoryView()");
	      return sqlSession.getMapper(HistoryViewDao.class).selectByWhereHistoryView(historyView);
	   }

	@Override
	public List<HistoryView> selectByUserHistory(HistoryView users) {
		log.debug("selectByUserHistory()");
		return sqlSession.getMapper(HistoryViewDao.class).selectByUserHistory(users);
	}
}
