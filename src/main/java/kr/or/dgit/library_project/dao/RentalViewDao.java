package kr.or.dgit.library_project.dao;

import java.util.List;

import kr.or.dgit.library_project.dto.RentalView;

public interface RentalViewDao {
	public List<RentalView> selectAllRentalView();
	public List<RentalView> selectByWhereRentalView(RentalView rentalview);
}
