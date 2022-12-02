package gntp.bbulsora.project.vo;

import org.springframework.stereotype.Component;

@Component("minorVO")
public class MinorVO {
	private String ctgrMinor;

	public MinorVO() {}
	public MinorVO(String ctgrMinor) {
		this.ctgrMinor = ctgrMinor;
	}
	public String getCtgrMinor() {
		return ctgrMinor;
	}
	public void setCtgrMinor(String ctgrMinor) {
		this.ctgrMinor = ctgrMinor;
	}

}
