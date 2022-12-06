package gntp.bbulsora.project.vo;

import org.springframework.stereotype.Component;

@Component("locationVO")
public class LocationVO {
	private String locArea;
	private String locType;
	private int locQtt;
	private int maxQtt;
	private int preQtt;
	
	public LocationVO() {}
	public LocationVO(String locArea, String locType, int locQtt, int maxQtt) {
		this.locArea = locArea;
		this.locType = locType;
		this.locQtt = locQtt;
		this.maxQtt = maxQtt;
	}
	
	public String getLocArea() {
		return locArea;
	}
	
	public void setLocArea(String locArea) {
		this.locArea = locArea;
	}
	
	public String getLocType() {
		return locType;
	}
	
	public void setLocType(String locType) {
		this.locType = locType;
	}
	
	public int getLocQtt() {
		return locQtt;
	}
	
	public void setLocQtt(int locQtt) {
		this.locQtt = locQtt;
	}
	
	public int getMaxQtt() {
		return maxQtt;
	}
	
	public void setMaxQtt(int maxQtt) {
		this.maxQtt = maxQtt;
	}
	
	public int getPreQtt() {
		return preQtt;
	}
	
	public void setPreQtt(int preQtt) {
		this.preQtt = preQtt;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "locArea = "+locArea+", locType = "+locType+", locQtt = "+locQtt+", maxQtt = "+maxQtt+", preQtt = "+preQtt;
	}
}
