package com.myhome.www.article.dto;

import java.time.LocalDateTime;

public class Comment {

	private int commentNo;
	private int articleNo;
	private int memberNo;
	private String commentContent;
	private LocalDateTime regdate;
	private LocalDateTime moddate;
	private int startIndex;
	private int cntPerPage;
	
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public int getArticleNo() {
		return articleNo;
	}
	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public LocalDateTime getRegdate() {
		return regdate;
	}
	public void setRegdate(LocalDateTime regdate) {
		this.regdate = regdate;
	}
	public LocalDateTime getModdate() {
		return moddate;
	}
	public void setModdate(LocalDateTime moddate) {
		this.moddate = moddate;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getCntPerPage() {
		return cntPerPage;
	}
	public void setCntPerPage(int cntPerPage) {
		this.cntPerPage = cntPerPage;
	}
	
	@Override
	public String toString() {
		return "Comment [commentNo=" + commentNo + ", articleNo=" + articleNo + ", memberNo=" + memberNo
				+ ", commentContent=" + commentContent + ", regdate=" + regdate + ", moddate=" + moddate + "]";
	}
	
}
