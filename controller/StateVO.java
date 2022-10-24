package gntp.bbulsora.project.vo;

import org.springframework.stereotype.Component;

@Component("stateVO")
public class StateVO {
	private String stateCd;
	private String stateContent;
	
	public StateVO() {}
	public StateVO(String stateCd, String stateContent) {
		this.stateCd = stateCd;
		this.stateContent = stateContent;
	}
	
	public String getStateCd() {
		return stateCd;
	}
	
	public void setStateCd(String stateCd) {
		this.stateCd = stateCd;
	}
	
	public String getStateContent() {
		return stateContent;
	}
	
	public void setStateContent(String stateContent) {
		this.stateContent = stateContent;
	}
}
