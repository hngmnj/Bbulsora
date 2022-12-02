package gntp.bbulsora.project.vo;

import org.springframework.stereotype.Component;

@Component("middleVO")
public class MiddleVO {
	private String ctgrMiddle;

	public MiddleVO() {}
	public MiddleVO(String ctgrMiddle) {
		this.ctgrMiddle = ctgrMiddle;
	}
	public String getCtgrMiddle() {
		return ctgrMiddle;
	}
	public void setCtgrMiddle(String ctgrMiddle) {
		this.ctgrMiddle = ctgrMiddle;
	}



}
