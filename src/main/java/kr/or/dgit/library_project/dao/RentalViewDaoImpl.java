package kr.or.dgit.library_project.dao;

import java.util.List;

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
	public List<RentalView> selectByWhereRentalView(RentalView rentalview) {
		log.debug("selectByWhereRentalView()");
		return sqlSession.selectList(namespace + ".selectByWhereRentalView", rentalview);
	}
}
