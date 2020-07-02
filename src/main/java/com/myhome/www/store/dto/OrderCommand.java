package com.myhome.www.store.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrderCommand {
	
	private int historyNo;
	private int memberNo;
	private String itemName;
	private LocalDateTime orderDate;
	private int price;
	private int amount;
	private String thumbUrl;
	private String option1Name;
	private String option2Name;
	
	
	public int getHistoryNo() {
		return historyNo;
	}
	public void setHistoryNo(int historyNo) {
		this.historyNo = historyNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getOrderDate() {
		return DateTimeFormatter.ofPattern("yyyy-MM-dd").format(orderDate);
	}
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String getOption1Name() {
		return option1Name;
	}
	public void setOption1Name(String option1Name) {
		this.option1Name = option1Name;
	}
	public String getOption2Name() {
		return option2Name;
	}
	public void setOption2Name(String option2Name) {
		this.option2Name = option2Name;
	}
	public String getThumbUrl() {
		return thumbUrl;
	}
	public void setThumbUrl(String thumbUrl) {
		this.thumbUrl = thumbUrl;
	}
	@Override
	public String toString() {
		return "OrderCommand [memberNo=" + memberNo + ", itemName=" + itemName + ", orderDate=" + orderDate + ", price="
				+ price + ", amount=" + amount + ", thumbUrl=" + thumbUrl + ", option1Name=" + option1Name
				+ ", option2Name=" + option2Name + "]";
	}
	
	
	
}
