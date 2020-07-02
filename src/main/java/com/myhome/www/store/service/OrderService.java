package com.myhome.www.store.service;

import java.util.List;

import com.myhome.www.store.dto.CartCommand;
import com.myhome.www.store.dto.OrderCommand;
import com.myhome.www.store.dto.OrderDetail;
import com.myhome.www.store.dto.OrderHistory;

public interface OrderService {

	//주문하기
	int order(OrderDetail orderDetail) throws Exception;
	//주문내역 리스트(admin)
	List<OrderHistory> selectOrderList() throws Exception;
	//마이페이지 주문내역 조회
		List<OrderCommand> selectMyOrderList(int memberNo, int startIndex, int pageSize) throws Exception;
		//마이페이지 주문 상품 개수
		int selectAllCount(int memberNo) throws Exception;
		//마이페이지 주문 상품 삭제
		int myOrderDelete(int memberNo, int historyNo) throws Exception;
	
}
