package kr.or.dgit.library_project.dto;

public class Publisher {
	private String publicCode;
	private String publicName;

	public Publisher() {
	}

	public String getPublicCode() {
		return publicCode;
	}

	public void setPublicCode(String publicCode) {
		this.publicCode = publicCode;
	}

	public String getPublicName() {
		return publicName;
	}

	public void setPublicName(String publicName) {
		this.publicName = publicName;
	}

	@Override
	public String toString() {
		return String.format("Publisher [publicCode=%s, publicName=%s]", publicCode, publicName);
	}

}
