package gntp.bbulsora.project.vo;

import org.springframework.stereotype.Component;

@Component("stockVO")
public class StockVO {
   private int stockSeq;
   private int stockQtt;
   private String locArea;
   private String lot;
   private int storeSeq;
   private String stateContent;
   private int stockSum;
   private String stateCd;
   private String itemCd;
   private String itemName;
   private String compCd;
   private String compName;
   
   public StockVO() {}

   public StockVO(int stockSeq, int stockQtt, String locArea, String lot, int storeSeq, String stateContent) {
      this.stockSeq = stockSeq;
      this.stockQtt = stockQtt;
      this.locArea = locArea;
      this.lot = lot;
      this.storeSeq = storeSeq;
      this.stateContent = stateContent;
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

   public String getLocArea() {
      return locArea;
   }

   public void setLocArea(String locArea) {
      this.locArea = locArea;
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

   public String getStateContent() {
      return stateContent;
   }

   public void setStateContent(String stateContent) {
      this.stateContent = stateContent;
   }

   public int getStockSum() {
      return stockSum;
   }

   public void setStockSum(int stockSum) {
      this.stockSum = stockSum;
   }

   public String getStateCd() {
      return stateCd;
   }

   public void setStateCd(String stateCd) {
      this.stateCd = stateCd;
   }

   public String getItemCd() {
      return itemCd;
   }

   public void setItemCd(String itemCd) {
      this.itemCd = itemCd;
   }

   public String getItemName() {
      return itemName;
   }

   public void setItemName(String itemName) {
      this.itemName = itemName;
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

}