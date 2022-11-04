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
	
	public StateVO(String data) {
		String[] temp = data.split(",");
		this.stateCd  = temp[0].trim();
		this.stateContent = temp[1].trim();
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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "stateCd = "+stateCd+", stateContent = "+stateContent;
	}
	
}
