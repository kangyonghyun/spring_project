package com.myhome.www.store.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myhome.www.store.dto.OrderCommand;
import com.myhome.www.store.dto.OrderDetail;
import com.myhome.www.store.dto.OrderHistory;

public interface OrderDao {

	//주문서 등록
	int insertOrder(OrderDetail orderDetail);
	//주문내역 등록
	int insertOrderHistory(OrderHistory orderHistory);
	//주문내역 리스트(admin)
	List<OrderHistory> selectOrderList() throws Exception;
	//마이페이지 주문내역 리스트 조회
	List<OrderCommand> selectMyOrderList(@Param("memberNo") int memberNo, @Param("startIndex") int startIndex, @Param("pageSize") int pageSize);
	//마이페이지 주문 상품 개수
	int selectAllCount(int memberNo);
	//마이페이지 주문 상품 삭제
	int myOrderDelete(@Param("memberNo") int memberNo, @Param("historyNo") int historyNo);
}
