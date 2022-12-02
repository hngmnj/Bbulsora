package gntp.bbulsora.project.vo;

import java.util.List;

import org.springframework.stereotype.Component;

@Component("orderVO")
public class OrderVO {
	private int orderSeq;
	private String orderCd;
	private int orderQtt;
	private String submitDate;
	private String orderDate;
	private String compCd;
	private String itemCd;
	private String stateCd;
	private String cnt;
	private String itemName;
	private String compName;
	private String compNameCli;
	private String unit;
	private String stateContent;
	private List<StateVO> stateList;

	public OrderVO() {}

	public OrderVO(int orderSeq, String orderCd, int orderQtt, String submitDate, String orderDate, String compCd,
			String itemCd, String stateCd) {
		this.orderSeq = orderSeq;
		this.orderCd = orderCd;
		this.orderQtt = orderQtt;
		this.submitDate = submitDate;
		this.orderDate = orderDate;
		this.compCd = compCd;
		this.itemCd = itemCd;
		this.stateCd = stateCd;
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
	public int getOrderQtt() {
		return orderQtt;
	}
	public void setOrderQtt(int orderQtt) {
		this.orderQtt = orderQtt;
	}
	public String getSubmitDate() {
		return submitDate;
	}
	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
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

	public String getCnt() {
		return cnt;
	}

	public void setCnt(String cnt) {
		this.cnt = cnt;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getStateContent() {
		return stateContent;
	}

	public void setStateContent(String stateContent) {
		this.stateContent = stateContent;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public List<StateVO> getStateList() {
		return stateList;
	}

	public void setStateList(List<StateVO> stateList) {
		this.stateList = stateList;
	}

	/**
	 * @return the compNameCli
	 */
	public String getCompNameCli() {
		return compNameCli;
	}

	/**
	 * @param compNameCli the compNameCli to set
	 */
	public void setCompNameCli(String compNameCli) {
		this.compNameCli = compNameCli;
	}


}
