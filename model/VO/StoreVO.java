package gntp.bbulsora.project.vo;

import org.springframework.stereotype.Component;

@Component("storeVO")
public class StoreVO {
	private int storeSeq;
	private int storeQtt;
	private String storeDate;
	private String fromDate;
	private String toDate;
	private String stateCd;
	private int orderSeq;

	public StoreVO() {}

	public StoreVO(int storeSeq, int storeQtt, String storeDate, String stateCd, int orderSeq) {
		this.storeSeq = storeSeq;
		this.storeQtt = storeQtt;
		this.storeDate = storeDate;
		this.stateCd = stateCd;
		this.orderSeq = orderSeq;
	}

	public int getStoreSeq() {
		return storeSeq;
	}
	public void setStoreSeq(int storeSeq) {
		this.storeSeq = storeSeq;
	}
	public int getStoreQtt() {
		return storeQtt;
	}
	public void setStoreQtt(int storeQtt) {
		this.storeQtt = storeQtt;
	}
	public String getStoreDate() {
		return storeDate;
	}
	public void setStoreDate(String storeDate) {
		this.storeDate = storeDate;
	}
	public String getStateCd() {
		return stateCd;
	}
	public void setStateCd(String stateCd) {
		this.stateCd = stateCd;
	}
	public int getOrderSeq() {
		return orderSeq;
	}
	public void setOrderSeq(int orderSeq) {
		this.orderSeq = orderSeq;
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
