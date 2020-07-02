package com.myhome.www.member.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.myhome.www.article.dto.Pagination;
import com.myhome.www.member.dto.Member;
import com.myhome.www.member.service.AuthInfo;
import com.myhome.www.member.service.MemberService;
import com.myhome.www.store.dto.OrderCommand;
import com.myhome.www.store.service.OrderService;
@Controller
public class MyPageController {

	@Resource(name = "memberService")
	private MemberService memberService;
	
	@Autowired
	private OrderService orderService;
	
	// 마이페이지 이동
	@RequestMapping("/mypage")
	public String goMypage(Member member, 
			HttpSession session, Model model) throws Exception {
		
		if (session.getAttribute("authInfo") != null) {
			AuthInfo newAuthInfo = (AuthInfo) session.getAttribute("authInfo");
			Member mem = memberService.selectMemberByNo(newAuthInfo.getMemberNo());

			model.addAttribute("member", mem);
			return "mypage/mypageModify";
		}
		// 로그인 하지 않은 경우에 마이페이지 진입시 회원로그인 폼으로 보낸다
		return "redirect:/login";
	}
	
	//회원 정보 수정 폼
	@RequestMapping(value = "/mypage/mypageModify", method = RequestMethod.POST) 
	public void myModify(Member member, HttpSession session,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
	  
		int result = memberService.updateMember(member);

		//수정 성공 여부
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		if(result > 0) {
		        writer.println("<script>alert('수정 성공!'); location.href='" + request.getContextPath() + "/';</script>");
		}else {
			writer.println("<script>alert('수정 실패!'); location.href='" + request.getContextPath() + "/mypage/modify/';</script>");
		}
	  }
	
	//나의 주문 내역 리스트 조회
	@RequestMapping(value = "/mypage/myOrder")
	public String myOrder(OrderCommand orderCommand, @RequestParam(defaultValue="1") int curPage,
			HttpSession session, HttpServletRequest request, Model model) throws Exception {
		
		AuthInfo authInfo = null;
		authInfo = (AuthInfo) session.getAttribute("authInfo");
		
		int listCnt = orderService.selectAllCount(authInfo.getMemberNo());
		Pagination pagination = new Pagination(listCnt, curPage);
		
		List<OrderCommand> orderCommandList = null;
		//로그인 한 회원의 번호로 구매내역 조회
		orderCommandList = orderService.selectMyOrderList(authInfo.getMemberNo(), pagination.getStartIndex(), pagination.getPageSize());
		System.out.println(orderCommandList.toString());
		model.addAttribute("orderCommandList", orderCommandList);
		model.addAttribute("listCnt", listCnt);
		model.addAttribute("pagination", pagination);
		return "mypage/mypageOrder";
	}
	
	//마이페이지 주문 내역 삭제
	@RequestMapping(value = "/mypage/myOrderDel/{historyNo}")
	public void myOrderDel(@PathVariable("historyNo") int historyNo,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		AuthInfo authInfo = null;
		authInfo = (AuthInfo) session.getAttribute("authInfo");
		//상품 삭제
		int result = 0;
		try {
			result = orderService.myOrderDelete(authInfo.getMemberNo(), historyNo);
			//삭제 성공 여부
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			if(result > 0) {
		         writer.println("<script>alert('취소 요청 하였습니다!'); location.href='" + request.getContextPath() + "/mypage/myOrder';</script>");
			}else {
				writer.println("<script>alert('취소 요청 불가!'); location.href='" + request.getContextPath() + "/mypage/myOrder';</script>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//내가 쓴 글 리스트
//	@RequestMapping(value = "/mypage/myArticle")
//	public String myArticle() {
//		
//	}
	
	//회원 탈퇴 - 비밀번호 확인창 띄우기
//	@RequestMapping(value = "/mypage/Withdrawal")
//	public String withdrawal(HttpSession session) throws Exception {
//		//비밀번호 확인 후 탈퇴
//		
//		
//		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
//		int memberNo = authInfo.getMemberNo();
//		int result = memberService.deleteMember(memberNo);
//		if(result > 0) {
//			return "index";
//		}else {
//			return "redirect:/mypage";
//		}
//	}
	

}
