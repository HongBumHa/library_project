package kr.or.dgit.library_project.dto;

public class Users {
	private String userId;
	private String userName;
	private String userPw;
	private String userAddr;
	private String userTel;
	private String userEmail;
	private int delayDay;
	private int rankCode;
	private String userLeave;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserAddr() {
		return userAddr;
	}
	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public int getDelayDay() {
		return delayDay;
	}
	public void setDelayDay(int delayDay) {
		this.delayDay = delayDay;
	}
	public int getRankCode() {
		return rankCode;
	}
	public void setRankCode(int rankCode) {
		this.rankCode = rankCode;
	}
	public String getUserLeave() {
		return userLeave;
	}
	public void setUserLeave(String userLeave) {
		this.userLeave = userLeave;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", userPw=" + userPw + ", userAddr=" + userAddr
				+ ", userTel=" + userTel + ", userEmail=" + userEmail + ", delayDay=" + delayDay + ", rankCode="
				+ rankCode + ", userLeave=" + userLeave + "]";
	}
	public Users(String userId) {
		
		this.userId = userId;
	}
	
	public Users(String userId, String userName, String userPw, String userAddr, String userTel, String userEmail,
			int delayDay, int rankCode, String userLeave) {
		this.userId = userId;
		this.userName = userName;
		this.userPw = userPw;
		this.userAddr = userAddr;
		this.userTel = userTel;
		this.userEmail = userEmail;
		this.delayDay = delayDay;
		this.rankCode = rankCode;
		this.userLeave = userLeave;
	}
	public Users(int delayDay) {
		
		this.delayDay = delayDay;
	}
	
}
