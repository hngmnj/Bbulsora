package gntp.bbulsora.project.vo;

import java.util.List;

import org.springframework.stereotype.Component;

@Component("storeVO")
public class StoreVO {
	private int storeSeq;
	private int storeQtt;
	private String storeDate;
	private String stateCd;
	private String locArea;
	private int orderSeq;
	private String orderCd;
	private String stateContent;
	private String itemCd;
	private List<StateVO> stateList;

	public StoreVO() {}

	public StoreVO(int storeSeq, int storeQtt, String storeDate, String stateCd, String locArea, int orderSeq, String orderCd, String stateContent) {
		this.storeSeq = storeSeq;
		this.storeQtt = storeQtt;
		this.storeDate = storeDate;
		this.stateCd = stateCd;
		this.locArea = locArea;
		this.orderSeq = orderSeq;
		this.orderCd = orderCd;
		this.stateContent = stateContent;

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

	public String getLocArea() {
		return locArea;
	}

	public void setLocArea(String locArea) {
		this.locArea = locArea;
	}

	public int getOrderSeq() {
		return orderSeq;
	}

	public void setOrderSeq(int orderSeq) {
		this.orderSeq = orderSeq;
	}

	public String getOrderCd() {
		return orderCd;
	}

	public void setOrderCd(String orderCd) {
		this.orderCd = orderCd;
	}

	public String getStateContent() {
		return stateContent;
	}

	public void setStateContent(String stateContent) {
		this.stateContent = stateContent;
	}

	public String getItemCd() {
		return itemCd;
	}

	public void setItemCd(String itemCd) {
		this.itemCd = itemCd;
	}

	public List<StateVO> getStateList() {
		return stateList;
	}

	public void setStateList(List<StateVO> stateList) {
		this.stateList = stateList;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "StoreVO [storeSeq= "+storeSeq+", storeQtt= "+storeQtt+", storeDate= "+storeDate+", stateCd= "+stateCd+", locArea= "+locArea
				+", orderSeq= "+orderSeq+", orderCd= "+orderCd+", stateContent= "+stateContent+", itemCd= "+itemCd+"]";
	}   
}
