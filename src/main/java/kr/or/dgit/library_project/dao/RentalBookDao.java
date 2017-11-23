package kr.or.dgit.library_project.dao;

import java.util.List;

import kr.or.dgit.library_project.dto.RentalBook;
import kr.or.dgit.library_project.dto.Users;

public interface RentalBookDao {
	public List<RentalBook> selectRentalBookByCode(RentalBook rentalBook);
	public int insertData(RentalBook rentalBook);
	public int deleteByWhereRentalBook(RentalBook rentalBook);
	
	RentalBook selectByUserRentalCount(Users user);
}
