package kr.or.dgit.library_project.dto;

public class Post {
	private String zipCode;
	private String sido;
	private String sigungu;
	private String doro;
	private String building1;
	private String building2;

	public Post(String sido, String doro) {
		this.sido = sido;
		this.doro = doro;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getSido() {
		return sido;
	}

	public void setSido(String sido) {
		this.sido = sido;
	}

	public String getSigungu() {
		return sigungu;
	}

	public void setSigungu(String sigungu) {
		this.sigungu = sigungu;
	}

	public String getDoro() {
		return doro;
	}

	public void setDoro(String doro) {
		this.doro = doro;
	}

	public String getBuilding1() {
		return building1;
	}

	public void setBuilding1(String building1) {
		this.building1 = building1;
	}

	public String getBuilding2() {
		return building2;
	}

	public void setBuilding2(String building2) {
		this.building2 = building2;
	}

	public Post() {}
	
	@Override
	public String toString() {
		return String.format("%s %s %s %s %s",
				sido, sigungu, doro, building1, building2);
	}
	
	public Post(String sido, String sigungu, String doro, String building1, String building2) {
		this.sido = sido;
		this.sigungu = sigungu;
		this.doro = doro;
		this.building1 = building1;
		this.building2 = building2;
	}

	public Object[] toArray() {
		return new Object[]{zipCode,sido,sigungu,doro,building1,building2};
	}
}
