<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/WEB-INF/view/include/header.jsp" %>
<c:set var="path" value="${pageContext.request.contextPath }" />
<script type="text/javascript">
$(function(){
    $('#modifyBtn').click(function(){
    	
    	var memberName = $('#memberName').val();
    	var pw1 = $('#pw1').val();
    	var pw2 = $('#pw2').val();
    	/* var memberPw = $('#memberPw').val();
    	var confirmPassword = $('#confirmPassword').val(); */
    	
    	if(memberName.length == 0){
    		$('.memberName').text("이름을 입력해주세요");
    		$('#memberName').focus();
    		return false;
    	}else{
    		$('.errStr').text("");
    	}

    	if(pw1.length == 0){
    		$('.memberPw').text("비밀번호를 입력해주세요");
    		$('#pw1').focus();
    		return false;
    	}else{
    		$('.errStr').text("");
    	}
    	
        	
	    var pwd1 = $("#pw1").val();
	    var pwd2 = $("#pw2").val();
	    if ( pwd1 != '' && pwd2 == '' ) {
	        null;
	    } else if (pwd1 != "" || pwd2 != "") {
	        if (pwd1 == pwd2) {
	        	  $("#alert-success").css('display', 'inline-block');
	              $("#alert-danger").css('display', 'none');
	        } else {
	        	 alert("비밀번호가 일치하지 않습니다. 비밀번호를 재확인해주세요.");
	             $("#alert-success").css('display', 'none');
	             $("#alert-danger").css('display', 'inline-block');
	             return false;
	        }
	    }
    	
    	if(pw2.length == 0){
    		$('.confirmPassword').text("비밀번호 확인를 입력해주세요");
    		$('#pw2').focus();
    		return false;
    	}else{
    		$('.errStr').text("");
    	}
    	
   		var result = confirm('수정하시겠습니까?'); 
    	if(result) { 
    		//액션 경로 지정
    	 	$("#memModForm").attr("action", "${path}/mypage/modify");
    		$("#memModForm").submit();
   		} else {
   			return;
   		}
    });
});
</script>
</head>
<body>
<%@ include file="/WEB-INF/view/include/nav.jsp"%>

<div class="container">
	<form:form id="memModForm" modelAttribute="member">
	
		<div class="memModPage">
			<div class="memModArea">
				<div class="title">회원정보 수정</div>
				<div class="field">
					<div class="label">아이디</div>
					<div class="input"><form:input type="text" path="memberId" readonly="true" value="${member.memberId }"/></div>
				</div>
				<div class="field">
					<div class="label">이름</div>
					<div class="input">
						<form:input type="text" path ="memberName" id="memberName"/>
						<span class="errStr memberName"></span>
					</div>
				</div>
				<div class="field">
					<div class="label">새 비밀번호</div>
					<div class="input">
						<form:password path="memberPw" id="pw1" class="pw"  />
						<span class="errStr memberPw"></span>
					</div>
				</div>
				<div class="field">
					<div class="label">새 비밀번호 확인</div>
					<div class="input">
						<form:password path="confirmPassword" id="pw2" class="pw" />
						<span class="errStr confirmPassword"></span> 
						<span id="alert-success" style="display: none;">비밀번호가 일치합니다.</span>
        				<span id="alert-danger" style="display: none; color: #d92742; font-weight: bold; ">비밀번호가 일치하지 않습니다.</span>
					</div>
					
				</div>
				<div class="ttl">추가 항목</div>
					<div class="field gender">
						<div class="label">성별</div>
						<div class="rad">
							<span>남자</span>
							<span class="male"><form:radiobutton path="memberGen" id="male" name="gender" value="남자" /></span>
							<span>여자</span>
		  					<span class="female"><form:radiobutton path="memberGen" id="female" name="gender" value="여자" /></span>
		  					<span>선택안함</span>
		  					<span class="other"><form:radiobutton path="memberGen" id="other" name="gender" value="선택안함" checked="checked"/></span>
						</div>
					</div>
					
					<div class="field">
						<div class="label">전화번호</div>
						<div class="input"><form:input type="text" path="memberTel" value="${member.memberTel}" /></div>
					</div>
					<form:hidden path="memberNo" value="${member.memberNo }"/>
					<div class="mobtn" align="center" >
					<button type="submit" id="modifyBtn" class="genric-btn success radius modifyBtn">수정하기</button>
					</div>
			</div>
		</div>
	</form:form>
</div>


<%@ include file="/WEB-INF/view/include/footer.jsp"%>
</body>
</html>