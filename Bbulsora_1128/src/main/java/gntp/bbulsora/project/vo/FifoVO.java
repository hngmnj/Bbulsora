package gntp.bbulsora.project.vo;

import org.springframework.stereotype.Component;

@Component("fifoVO")
public class FifoVO {
	private int dlvryQtt;
	private int remainQtt;
	private String lot;
	private int StockQtt;
	private String compCd;
	private String itemCd;
	private String dlvryCd;
	
	public FifoVO() {}
	public FifoVO(String dlvryCd, int remainQtt) {
		this.dlvryCd = dlvryCd;
		this.remainQtt = remainQtt;
	}
	
	public int getDlvryQtt() {
		return dlvryQtt;
	}
	
	public void setDlvryQtt(int dlvryQtt) {
		this.dlvryQtt = dlvryQtt;
	}
	
	public int getRemainQtt() {
		return remainQtt;
	}
	
	public void setRemainQtt(int remainQtt) {
		this.remainQtt = remainQtt;
	}
	
	public String getLot() {
		return lot;
	}
	
	public void setLot(String lot) {
		this.lot = lot;
	}
	
	public int getStockQtt() {
		return StockQtt;
	}
	
	public void setStockQtt(int stockQtt) {
		StockQtt = stockQtt;
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
	
	public String getDlvryCd() {
		return dlvryCd;
	}
	
	public void setDlvryCd(String dlvryCd) {
		this.dlvryCd = dlvryCd;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "FifoVO [lot = "+ lot + ", qtt = " + dlvryQtt + "]";
	}
}
