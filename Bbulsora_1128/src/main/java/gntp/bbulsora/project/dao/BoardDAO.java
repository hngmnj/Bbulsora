package gntp.bbulsora.project.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gntp.bbulsora.project.vo.BoardVO;
import gntp.bbulsora.project.vo.CommentVO;

@Repository("boardDAO")
public class BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;

	//전체조회 및 조건검색
	public void selectByPage(Map<String, Object> obj) {
		obj.put("list", sqlSession.selectList("mapper.board.selectAllBoardList", obj));
		obj.put("total", sqlSession.selectOne("mapper.board.selectTotalCnt", obj));
	}
	
	//전체 글 수 리턴
	public Integer selectTotalNumber() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mapper.board.selectTotalNumber");
	}
	
	//페이징 조회
	public List<BoardVO> selectByPage(int offsetNum) {
		List<BoardVO> list = null;
		list = sqlSession.selectList("mapper.board.selectByPage", offsetNum);
		return list;
	}
	
	//전체조회
	public List<BoardVO> selectAll() {
		List<BoardVO> list = null;
		list = sqlSession.selectList("mapper.board.selectAllBoardList");
		return list;
	}

	//작성자
	public List<BoardVO> selectWriter(String brdWriter) {
		List<BoardVO> list = null;
		list = sqlSession.selectList("mapper.board.selectBoardByBrdWriter", brdWriter);
		return list;
	}
	//카테고리
	public List<BoardVO> selectCategory(String category) {
		List<BoardVO> list = null;
		list = sqlSession.selectList("mapper.board.selectBoardByCategory", category);
		return list;
	}
	//제목
	public List<BoardVO> selectTitle(String title) {
		List<BoardVO> list = null;
		list = sqlSession.selectList("mapper.board.selectBoardByTitle", title);
		return list;
	}
	
	//조건조회
	public BoardVO selectOne(String brdSeq) throws SQLException {
		BoardVO member = null;
		member = (BoardVO)sqlSession.selectOne("mapper.board.selectBoardByBrdSeq", Integer.parseInt(brdSeq));


		return member;
	}

	//사원정보 입력
	public boolean insertOne(BoardVO board) throws SQLException {
		boolean flag = false;
		int affectedCount = sqlSession.insert("mapper.board.insertBoard", board);
		if(affectedCount > 0) {
			flag = true;
		}
		System.out.println(flag);
		return flag;
	}

	//사원정보 수정
	public boolean updateOne(BoardVO board) throws SQLException {
		boolean flag = false;
		int affectedCount = sqlSession.update("mapper.board.updateBoard", board);
		if(affectedCount > 0) {
			flag = true;
		}
		return flag;
	}

	//사원정보 삭제
	public boolean deleteOne(String brdSeq) throws SQLException {
		boolean flag = false;
		int affectedCount = sqlSession.delete("mapper.board.deleteBoard", Integer.parseInt(brdSeq));
		if(affectedCount > 0) {
			flag = true;
		}
		return flag;
	}
	
	public boolean insertComment(CommentVO comment) {
		boolean flag = false;
		int affectedCount = sqlSession.insert("mapper.board.insertComment", comment);
		if(affectedCount > 0) {
			flag = true;
		}
		System.out.println("Insert comment: "+flag);
		return flag;
	}

	public boolean deleteComment(String cmntSeq) throws SQLException {
		boolean flag = false;
		int affectedCount = sqlSession.delete("mapper.board.deleteComment", Integer.parseInt(cmntSeq));
		if(affectedCount > 0) {
			flag = true;
		}
		System.out.println("Delete comment: "+flag);
		return flag;
	}
	
	public boolean updateComment(CommentVO comment) throws SQLException {
		boolean flag = false;
		int affectedCount = sqlSession.delete("mapper.board.updateComment", comment);
		if(affectedCount > 0) {
			flag = true;
		}
		System.out.println("Delete comment: "+flag);
		return flag;
	}



}
