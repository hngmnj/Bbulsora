package gntp.bbulsora.project.vo;

import org.springframework.stereotype.Component;

@Component("deliveryVO")
public class DeliveryVO {
	private int dlvrySeq;
	private String dlvryCd;
	private int dlvryQtt;
	private String reqDate;
	private String dlvryDate;
	private String fromDate;
	private String toDate;
	private String compCd;
	private String itemCd;
	private String stateCd;

	public DeliveryVO() {}

	public DeliveryVO(int dlvrySeq, String dlvryCd, int dlvryQtt, String reqDate, String dlvryDate, String compCd,
			String itemCd, String stateCd) {
		this.dlvrySeq = dlvrySeq;
		this.dlvryCd = dlvryCd;
		this.dlvryQtt = dlvryQtt;
		this.reqDate = reqDate;
		this.dlvryDate = dlvryDate;
		this.compCd = compCd;
		this.itemCd = itemCd;
		this.stateCd = stateCd;
	}

	public int getDlvrySeq() {
		return dlvrySeq;
	}
	public void setDlvrySeq(int dlvrySeq) {
		this.dlvrySeq = dlvrySeq;
	}
	public String getDlvryCd() {
		return dlvryCd;
	}
	public void setDlvryCd(String dlvryCd) {
		this.dlvryCd = dlvryCd;
	}
	public int getDlvryQtt() {
		return dlvryQtt;
	}
	public void setDlvryQtt(int dlvryQtt) {
		this.dlvryQtt = dlvryQtt;
	}
	public String getReqDate() {
		return reqDate;
	}
	public void setReqDate(String reqDate) {
		this.reqDate = reqDate;
	}
	public String getDlvryDate() {
		return dlvryDate;
	}
	public void setDlvryDate(String dlvryDate) {
		this.dlvryDate = dlvryDate;
	}
	public String getCompCd() {
		return compCd;
	}
	public void setCompCd(String compCd) {
		this.compCd = compCd;
	}
	public String getItemCd() {
		return itemCd;
	}
	public void setItemCd(String itemCd) {
		this.itemCd = itemCd;
	}
	public String getStateCd() {
		return stateCd;
	}
	public void setStateCd(String stateCd) {
		this.stateCd = stateCd;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	
}
