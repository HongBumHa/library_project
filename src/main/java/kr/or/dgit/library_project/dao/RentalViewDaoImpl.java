package kr.or.dgit.library_project.dao;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.library_project.dto.Book;
import kr.or.dgit.library_project.dto.RentalView;

public class RentalViewDaoImpl implements RentalViewDao {

	private SqlSession sqlSession;
	private static final Log log = LogFactory.getLog(RentalViewDaoImpl.class);
	private String namespace = "kr.or.dgit.library_project.dao.RentalViewDao";

	private RentalViewDaoImpl() {}

	public RentalViewDaoImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	public static Log getLog() {
		return log;
	}

	@Override
	public List<RentalView> selectAllRentalView() {
		log.debug("selectAllRentalView()");
		return sqlSession.getMapper(RentalViewDao.class).selectAllRentalView();
	}

	@Override
	public List<RentalView> selectByWhereRentalView(RentalView rentalview) {
		log.debug("selectByWhereRentalView()");
//		Vector<RentalView> vv = new Vector<>();
		/*List<RentalView> lists =  sqlSession.selectList(namespace + ".selectByWhereRentalView", rentalview);
		for(RentalView rv : lists) {
			vv.add(rv);
		}
		return vv;*/
		return sqlSession.selectList(namespace+".selectByWhereRentalView", rentalview);
	}

	@Override
	public List<RentalView> selectAllRentalViewMap() {
		log.debug("selectAllRentalViewMap()");
		return sqlSession.selectList(namespace+".selectAllRentalViewMap");
	}
	
	@Override
	public List<RentalView> selectByWhereRentalViewMap(Map<String, Object> map) {
		log.debug("selectByWhereRentalViewMap");
		return sqlSession.selectList(namespace+".selectByWhereRentalViewMap", map);
	}

	@Override
	public RentalView selectByBookDataRentalView(Book book) {
		log.debug("selectByBookDataRentalView");
		return sqlSession.selectOne(namespace+".selectByBookDataRentalView", book);
	}
}
