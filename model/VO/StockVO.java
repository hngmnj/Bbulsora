package gntp.bbulsora.project.vo;

import org.springframework.stereotype.Component;

@Component("stockVO")
public class StockVO {
	private int stockSeq;
	private int stockQtt;
	private String loc;
	private String lot;
	private int storeSeq;
	private String stateCd;
	
	public StockVO() {}

	public StockVO(int stockSeq, int stockQtt, String loc, String lot, int storeSeq) {
		this.stockSeq = stockSeq;
		this.stockQtt = stockQtt;
		this.loc = loc;
		this.lot = lot;
		this.storeSeq = storeSeq;
	}

	public int getStockSeq() {
		return stockSeq;
	}

	public void setStockSeq(int stockSeq) {
		this.stockSeq = stockSeq;
	}

	public int getStockQtt() {
		return stockQtt;
	}

	public void setStockQtt(int stockQtt) {
		this.stockQtt = stockQtt;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getLot() {
		return lot;
	}

	public void setLot(String lot) {
		this.lot = lot;
	}

	public int getStoreSeq() {
		return storeSeq;
	}

	public void setStoreSeq(int storeSeq) {
		this.storeSeq = storeSeq;
	}

	public String getStateCd() {
		return stateCd;
	}

	public void setStateCd(String stateCd) {
		this.stateCd = stateCd;
	}
	
	
}
