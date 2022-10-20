package gntp.bbulsora.project.vo;

import org.springframework.stereotype.Component;

@Component("companyVO")
public class CompanyVO {
	private String compCd;
	private String compName;
	private String repName;
	private String address;
	private String compCall;
	private String sort;
	
	public CompanyVO() {}
	
	public CompanyVO(String compCd, String compName, String repName, String address, String compCall, String sort) {
	
		this.compCd = compCd;
		this.compName = compName;
		this.repName = repName;
		this.address = address;
		this.compCall = compCall;
		this.sort = sort;
	}

	public String getCompCd() {
		return compCd;
	}

	public void setCompCd(String compCd) {
		this.compCd = compCd;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getRepName() {
		return repName;
	}

	public void setRepName(String repName) {
		this.repName = repName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompCall() {
		return compCall;
	}

	public void setCompCall(String compCall) {
		this.compCall = compCall;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}



}
