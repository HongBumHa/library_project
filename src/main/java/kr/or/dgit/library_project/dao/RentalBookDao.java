package kr.or.dgit.library_project.dao;

import kr.or.dgit.library_project.dto.RentalBook;

public interface RentalBookDao {
	public int insertData(RentalBook rentalBook);
	public int deleteByWhereRentalBook(RentalBook rentalBook);
}
