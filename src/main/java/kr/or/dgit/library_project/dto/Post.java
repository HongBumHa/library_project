package kr.or.dgit.library_project.dto;

public class Post {
	private String zipCode;
	private String sido;
	private String sigungu;
	private String doro;
	private String building1;
	private String building2;

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
		return String.format("Post [zipCode=%s, sido=%s, sigungu=%s, doro=%s, building1=%s, building2=%s]", zipCode,
				sido, sigungu, doro, building1, building2);
	}

}
