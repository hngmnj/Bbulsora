package gntp.bbulsora.project.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gntp.bbulsora.project.vo.EmployeeVO;


@Repository("EmployeeDAO")
public class EmployeeDAO {
	
	@Autowired
	private SqlSession sqlSession;

	//전체조회
	public List<EmployeeVO> selectAll() throws SQLException{
		List<EmployeeVO> list = null;
		list = sqlSession.selectList("mapper.employee.selectAllEmployeeList");
		
		return list;
	}

	//조건조회
	public EmployeeVO selectOne(String empNo) throws SQLException {
		EmployeeVO member = null;
		member = (EmployeeVO)sqlSession.selectOne("mapper.employee.selectMemberByEmpNo", Integer.parseInt(empNo));


		return member;
	}

	//사원정보 입력
	public boolean insertOne(EmployeeVO employee) throws SQLException {
		boolean flag = false;
		int affectedCount = sqlSession.insert("mapper.employee.insertEmployee", employee);
		if(affectedCount > 0) {
			flag = true;
		}
		System.out.println(flag);
		return flag;
	}
	
	//사원정보 수정
	public boolean updateOne(EmployeeVO employee) throws SQLException {
		boolean flag = false;
		int affectedCount = sqlSession.update("mapper.employee.updateEmployee", employee);
		if(affectedCount > 0) {
			flag = true;
		}
		return flag;
	}
	
	//사원정보 삭제
	public boolean deleteOne(String empNo) throws SQLException {
		boolean flag = false;
		int affectedCount = sqlSession.delete("mapper.employee.deleteEmployee", Integer.parseInt(empNo));
		if(affectedCount > 0) {
			flag = true;
		}
		return flag;
	}
	
	
	

}
