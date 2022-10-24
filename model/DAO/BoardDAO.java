package gntp.bbulsora.project.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gntp.bbulsora.project.vo.BoardVO;
import gntp.bbulsora.project.vo.CommentVO;

@Repository("boardDAO")
public class BoardDAO {

	@Autowired
	private SqlSession sqlSession;

	//전체
	public List<BoardVO> selectAll() throws SQLException{
		List<BoardVO> list = null;
		list = sqlSession.selectList("mapper.board.selectAllBoardList");
		return list;
	}

	public BoardVO selectOne(String brdSeq) {
		BoardVO board = null;
		board = (BoardVO)sqlSession.selectOne("mapper.board.selectBoardByBrdSeq",Integer.parseInt(brdSeq));
		return board;
	}

	//작성자
	public List<BoardVO> selectWriter(String category) throws SQLException{
		List<BoardVO> list = null;
		list = sqlSession.selectList("mapper.board.selectBoardByBrdWriter");
		return list;
	}
	//카테고리
	public List<BoardVO> selectCategory(String category) throws SQLException{
		List<BoardVO> list = null;
		list = sqlSession.selectList("mapper.board.selectBoardByCategory");
		return list;
	}
	//제목
	public List<BoardVO> selectTitle(String category) throws SQLException{
		List<BoardVO> list = null;
		list = sqlSession.selectList("mapper.board.selectBoardByTitle");
		return list;
	}
	public boolean insertBoard(BoardVO board) throws SQLException {
		boolean flag = false;
		int affectedCount = sqlSession.insert("mapper.board.insertBoard", board);
		if(affectedCount > 0) {
			flag = true;
		}
		System.out.println("Insert board: "+flag);
		return flag;
	}

	public boolean updateBoard(BoardVO board) throws SQLException {
		boolean flag = false;
		int affectedCount = sqlSession.update("mapper.board.updateBoard", board);
		if(affectedCount > 0) {
			flag = true;
		}
		return flag;
	}

	public boolean deleteBoard(String brdSeq) throws SQLException {
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

}
