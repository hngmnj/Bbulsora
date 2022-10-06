package gntp.bbulsora.project.vo;

import org.springframework.stereotype.Component;

@Component("employeeVO")
public class EmployeeVO {
	private int empNo;
	private String name;
	private String birthDate;
	private String phoneNum;
	private String email;
	private String gender;
	private String address;
	private String postNum;
	private String regiNum;
	private String deptmt;
	private String position;
	private String startDate;
	private String endDate;
	
	public EmployeeVO() {}
	public EmployeeVO(int empNo, String name, String birthDate, String phoneNum, String email, String gender,
			String address, String postNum, String regiNum, String deptmt, String position, String startDate, String endDate) {
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
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
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
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
}
