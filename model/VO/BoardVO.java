package gntp.bbulsora.project.vo;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component("boardVO")
public class BoardVO {
	private int brdSeq;
	private String brdWriter;
	private String category;
	private String title;
	private String brdContent;
	private String brdDate;
	private String filename;
	private String filepath;
	private List<CommentVO> commentList;
	private MultipartFile uploadFile;
	
	public BoardVO() {}
	
	public BoardVO(int brdSeq, String brdWriter, String category, String title, String brdContent, String brdDate,
			String filename, String filepath, List<CommentVO> commentList) {
		this.brdSeq = brdSeq;
		this.brdWriter = brdWriter;
		this.category = category;
		this.title = title;
		this.brdContent = brdContent;
		this.brdDate = brdDate;
		this.filename = filename;
		this.filepath = filepath;
		this.commentList = commentList;
	}

	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
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

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
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