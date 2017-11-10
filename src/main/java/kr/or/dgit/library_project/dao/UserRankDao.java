package kr.or.dgit.library_project.dao;

import java.util.List;

import kr.or.dgit.library_project.dto.UserRank;

public interface UserRankDao {
	List<UserRank> selectUserRankByAll();
}
