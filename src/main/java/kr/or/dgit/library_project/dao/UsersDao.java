package kr.or.dgit.library_project.dao;

import java.util.List;

import kr.or.dgit.library_project.dto.Users;

public interface UsersDao {
	List<Users> selectUserByAll();
}
