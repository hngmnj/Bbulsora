package gntp.bbulsora.project.vo;

import org.springframework.stereotype.Component;

@Component("majorVO")
public class MajorVO {
	private String ctgrMajor;
	
	public MajorVO() {}
	
	public MajorVO(String ctgrMajor) {
		this.ctgrMajor = ctgrMajor;
	}

	public String getCtgrMajor() {
		return ctgrMajor;
	}

	public void setCtgrMajor(String ctgrMajor) {
		this.ctgrMajor = ctgrMajor;
	}


}
