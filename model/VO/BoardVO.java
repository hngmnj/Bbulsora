package gntp.bbulsora.project.vo;

import java.util.List;

import org.springframework.stereotype.Component;

@Component("boardVO")
public class BoardVO {
	private int brdSeq;
	private String brdWriter;
	private String category;
	private String title;
	private String brdContent;
	private String brdDate;
	private String filepath;
	private List<CommentVO> commentList;
	
	public BoardVO() {}
	
	public BoardVO(int brdSeq, String brdWriter, String category, String title, String brdContent, String brdDate,
			String filepath, List<CommentVO> commentList) {

		this.brdSeq = brdSeq;
		this.brdWriter = brdWriter;
		this.category = category;
		this.title = title;
		this.brdContent = brdContent;
		this.brdDate = brdDate;
		this.filepath = filepath;
		this.commentList = commentList;
	}

	public int getBrdSeq() {
		return brdSeq;
	}

	public void setBrdSeq(int brdSeq) {
		this.brdSeq = brdSeq;
	}

	public String getBrdWriter() {
		return brdWriter;
	}

	public void setBrdWriter(String brdWriter) {
		this.brdWriter = brdWriter;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrdContent() {
		return brdContent;
	}

	public void setBrdContent(String brdContent) {
		this.brdContent = brdContent;
	}

	public String getBrdDate() {
		return brdDate;
	}

	public void setBrdDate(String brdDate) {
		this.brdDate = brdDate;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	
	public List<CommentVO> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<CommentVO> commentList) {
		this.commentList = commentList;
	}
}
