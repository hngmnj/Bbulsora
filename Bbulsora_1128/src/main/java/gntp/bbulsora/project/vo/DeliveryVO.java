package gntp.bbulsora.project.vo;

import java.util.List;

import org.springframework.stereotype.Component;

@Component("deliveryVO")
public class DeliveryVO {
   private int dlvrySeq;
   private String dlvryCd;
   private int dlvryQtt;
   private String reqDate;
   private String dlvryDate;
   private String compCd;
   private String compName;
   private String itemCd;
   private String itemName;
   private String stateCd;
   private String stateContent;
   private int cnt;
   private String locArea;
   private List<StateVO> stateList;

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
   
   public String getCompName() {
      return compName;
   }

   public void setCompName(String compName) {
      this.compName = compName;
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

   public int getCnt() {
      return cnt;
   }

   public void setCnt(int cnt) {
      this.cnt = cnt;
   }
   
   public List<StateVO> getStateList() {
      return stateList;
   }

   public void setStateList(List<StateVO> stateList) {
      this.stateList = stateList;
   }

   public String getLocArea() {
      return locArea;
   }

   public void setLocArea(String locArea) {
      this.locArea = locArea;
   }

   @Override
   public String toString() {
      return "dlvryCd : "+dlvryCd+", dlvryQtt : "+dlvryQtt+", reqDate : "+reqDate+", compCd : "+compCd+", itemCd : "+itemCd+", stateCd : "+stateCd
            +", locArea : "+locArea;
   }
}
