package com.myhome.www.article.dto;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*@Data
@AllArgsConstructor
@NoArgsConstructor*/
public class Article {

	private int articleNo;						//글번호
	private String writerId;					//작성자 id
	private String writerName;					//작성자 이름
	private String articleTitle;				//글제목
	private String articleContent;				//글내용
	private LocalDateTime regdate;						//작성일
	private LocalDateTime moddate;						//수정일
	private String articleImgUrl;				//이미지저장 경로
	private String articleThumbUrl;				//썸네일이미지 저장 경로
	private MultipartFile multipartFile;		//업로드 파일
	private int readCount;						//조회수
	private int startIndex;						//페이지 시작 글
	private int cntPerPage;						//페이지 수
	
	
	
	public int getArticleNo() {
		return articleNo;
	}



	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}



	public String getWriterId() {
		return writerId;
	}



	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}



	public String getWriterName() {
		return writerName;
	}



	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}



	public String getArticleTitle() {
		return articleTitle;
	}



	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}



	public String getArticleContent() {
		return articleContent;
	}



	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
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



	public String getArticleImgUrl() {
		return articleImgUrl;
	}



	public void setArticleImgUrl(String articleImgUrl) {
		this.articleImgUrl = articleImgUrl;
	}



	public String getArticleThumbUrl() {
		return articleThumbUrl;
	}



	public void setArticleThumbUrl(String articleThumbUrl) {
		this.articleThumbUrl = articleThumbUrl;
	}



	public MultipartFile getMultipartFile() {
		return multipartFile;
	}



	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}



	public int getReadCount() {
		return readCount;
	}



	public void setReadCount(int readCount) {
		this.readCount = readCount;
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
		return "Article [articleNo=" + articleNo + ", writerId=" + writerId + ", writerName=" + writerName
				+ ", articleTitle=" + articleTitle + ", articleContent=" + articleContent + ", regdate=" + regdate
				+ ", moddate=" + moddate + ", articleImgUrl=" + articleImgUrl + ", articleThumbUrl=" + articleThumbUrl
				+ ", multipartFile=" + multipartFile + ", readCount=" + readCount + ", startIndex=" + startIndex
				+ ", cntPerPage=" + cntPerPage + "]";
	}

}
