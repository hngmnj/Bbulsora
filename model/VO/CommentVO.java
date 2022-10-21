package gntp.bbulsora.project.vo;

import org.springframework.stereotype.Component;

@Component("commentVO")
public class CommentVO {
	private int cmntSeq;
	private String cmntWriter;
	private String cmntContent;
	private String cmntDate;
	private int brdSeq;

	public CommentVO() {}

	public CommentVO(int cmntSeq, String cmntWriter, String cmntContent, String cmntDate, int brdSeq) {
		this.cmntSeq = cmntSeq;
		this.cmntWriter = cmntWriter;
		this.cmntContent = cmntContent;
		this.cmntDate = cmntDate;
		this.brdSeq = brdSeq;
	}

	public int getCmntSeq() {
		return cmntSeq;
	}

	public void setCmntSeq(int cmntSeq) {
		this.cmntSeq = cmntSeq;
	}

	public String getCmntWriter() {
		return cmntWriter;
	}

	public void setCmntWriter(String cmntWriter) {
		this.cmntWriter = cmntWriter;
	}

	public String getCmntContent() {
		return cmntContent;
	}

	public void setCmntContent(String cmntContent) {
		this.cmntContent = cmntContent;
	}

	public String getCmntDate() {
		return cmntDate;
	}

	public void setCmntDate(String cmntDate) {
		this.cmntDate = cmntDate;
	}

	public int getBrdSeq() {
		return brdSeq;
	}

	public void setBrdSeq(int brdSeq) {
		this.brdSeq = brdSeq;
	}



}
