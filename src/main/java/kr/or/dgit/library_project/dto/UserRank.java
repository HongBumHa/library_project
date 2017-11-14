package kr.or.dgit.library_project.dto;

public class UserRank {
	private int rankCode;
	private String rankName;
	public int getRankCode() {
		return rankCode;
	}
	public void setRankCode(int rankCode) {
		this.rankCode = rankCode;
	}
	public String getRankName() {
		return rankName;
	}
	public void setRankName(String rankName) {
		this.rankName = rankName;
	}
	@Override
	public String toString() {
		return "UserRank [rankCode=" + rankCode + ", rankName=" + rankName + "]";
	}
	public UserRank(int rankCode, String rankName) {
		this.rankCode = rankCode;
		this.rankName = rankName;
	}
	
	
}
