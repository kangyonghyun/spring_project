package com.myhome.www.item.service;

import java.util.List;

public class ItemPage {
	
	private int total; 
	private int currentPage; 
	private int totalPages; 
	private int startPage; 
	private int endPage;
	private List<ItemCommand> content;

	public ItemPage(int total, int currentPage, int size, List<ItemCommand> content) {
		this.total = total; //상품 총 개수
		this.currentPage = currentPage; //현재 페이지
		this.content = content; //출력 내용
		if (total == 0) { 
			totalPages = 0; startPage = 0; endPage = 0;
		} else {
			totalPages = total / size; //전체 페이지수
			if (total % size > 0) {
				totalPages++;
			}
			int modVal = currentPage % 5; // 블럭수(range):5개
			startPage = currentPage / 5 * 5 + 1; //시작페이지
			if (modVal == 0) startPage -= 5; //5페이지 넘어가면 
			endPage = startPage + 4; //끝페이지
			if (endPage > totalPages) endPage = totalPages;}} //끝페이지 맞춰줌
	
	public List<ItemCommand> getContent() {
		return content;
	}

	public int getTotal() {
		return total;
	}
	
	public boolean hasNoItems() {
		return total == 0;
	}
	
	public boolean hasItems() {
		return total > 0;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public int getStartPage() {
		return startPage;
	}
	
	public int getEndPage() {
		return endPage;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
}
