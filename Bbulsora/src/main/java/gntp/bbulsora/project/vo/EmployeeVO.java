package gntp.bbulsora.project.vo;

import java.sql.Timestamp;

public class EmployeeVO {
	private int empNo;
	private String name;
	private Timestamp birthDate;
	private String phoneNum;
	private String email;
	private char gender;
	private String address;
	private String postNum;
	private String regiNum;
	private String deptmt;
	private String position;
	private Timestamp startDate;
	private Timestamp endDate;
	
	public EmployeeVO() {}
	public EmployeeVO(int empNo, String name, Timestamp birthDate, String phoneNum, String email, char gender,
			String address, String postNum, String regiNum, String deptmt, String position, Timestamp startDate, Timestamp endDate) {
		this.empNo = empNo;
		this.name = name;
		this.birthDate = birthDate;
		this.phoneNum = phoneNum;
		this.email = email;
		this.gender = gender;
		this.address = address;
		this.postNum = postNum;
		this.regiNum = regiNum;
		this.deptmt = deptmt;
		this.position = position;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Timestamp birthDate) {
		this.birthDate = birthDate;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostNum() {
		return postNum;
	}
	public void setPostNum(String postNum) {
		this.postNum = postNum;
	}
	public String getRegiNum() {
		return regiNum;
	}
	public void setRegiNum(String regiNum) {
		this.regiNum = regiNum;
	}
	public String getDeptmt() {
		return deptmt;
	}
	public void setDeptmt(String deptmt) {
		this.deptmt = deptmt;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Timestamp getStartDate() {
		return startDate;
	}
	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}
	public Timestamp getEndDate() {
		return endDate;
	}
	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "empNo: "+ empNo + " name: " + name + " birthdate: " + birthDate + " phoneNum: " + phoneNum
				+ " email: " + email + " gender: " + gender + " address: " + address + " postNum: " + postNum
				+ " regiNum: " + regiNum + " deptmt: " + deptmt + " position: " + position + " startdate: " + startDate
				+ " endDate: " + endDate ;
	}
	
}
