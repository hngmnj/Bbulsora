package gntp.bbulsora.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService {
//	@Autowired
//	private MemberDAO memberDAO;

//	public MemberVO memberCheck(String id, String name, String company, String phoneNo) {
//		MemberVO member = new MemberVO();
//		member.setId(id);
//		member.setName(name);
//		member.setCompany(company);
//		member.setPhoneNo(phoneNo);
//		return member;
//	}
	
//	public boolean createMember(MemberVO member) {
//		boolean flag = false;
//		int affectedCount = memberDAO.insertOne(member);
//		if(affectedCount>0) {
//			flag = true;
//		return flag;
//	}
	
	public boolean idCheck(String id) {
		boolean flag = false;
//		flag = memberDAO.isSameId(id);
		return flag;
	}
	
}