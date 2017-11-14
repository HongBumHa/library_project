package kr.or.dgit.library_project.dao;

import java.util.List;
import java.util.Vector;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.library_project.dto.RentalView;

public class RentalViewDaoImpl implements RentalViewDao {

	private SqlSession sqlSession;
	private static final Log log = LogFactory.getLog(RentalViewDaoImpl.class);
	private String namespace = "kr.or.dgit.library_project.dao.RentalViewDao";

	public RentalViewDaoImpl() {}

	public RentalViewDaoImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<RentalView> selectAllRentalView() {
		log.debug("selectAllRentalView()");
		return sqlSession.getMapper(RentalViewDao.class).selectAllRentalView();
	}

	@Override
	public Vector<RentalView> selectByWhereRentalView(RentalView rentalview) {
		log.debug("selectByWhereRentalView()");
		Vector<RentalView> vv = new Vector<>();
		List<RentalView> lists =  sqlSession.selectList(namespace + ".selectByWhereRentalView", rentalview);
		for(RentalView rv : lists) {
			vv.add(rv);
		}
		return vv;
	}
}