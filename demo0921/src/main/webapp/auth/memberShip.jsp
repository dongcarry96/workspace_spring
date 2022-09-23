<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원등록</title>
<%@ include file="../common/easyui_common.jsp" %>
<script>
/* zipcodeList.jsp에 있는 함수임 -> 본진인 memberShip.jsp에 스크립트 관리함 */
	function choice(zipcode, address){
		console.log(zipcode);
		$("#_easyui_textbox_input4").val(zipcode);
		$("#_easyui_textbox_input5").val(address);
		$("#dlg_zipcode").dialog('close');
	}
	function zipcodeSearch(){
		const u_dong = $("#dong").textbox('getValue'); // 사용자가 입력한 동 정보
		console.log(u_dong);
		$.ajax({
			url: "/zipcode/zipcodeList?dong="+u_dong
		   ,method:"GET"
		   ,success:function(data){
			   //$("#d_zipcode").text(data); -> 이렇게 하면 글자만 나옴
			   $("#d_zipcode").html(data);
			   }
		});
	}
	function searchForm(){
		$("#dlg_zipcode").dialog({
			title: "우편번호 찾기",
			href:"zipcodeForm.jsp",
			modal: true,
			closed: true
		});
		$("#dlg_zipcode").dialog('open');
	}
	function memberShip(){
		alert($("#mem_zipcode").textbox('getValue')+","+$("#mem_address").textbox('getValue'));
		$("#f_member").submit();
	}
</script>
</head>
<body>
	<div style="margin: 5px 0;"></div>
	HOME > 회원관리 > 회원목록
	<hr>
	<div style="margin: 20px 0;"></div>
	<div>
	<form action="/member/memberInsert" method="get" id="f_member" >
		<label for="mem_id">아이디</label>
		<input id="mem_id" name="mem_id" class="easyui-textbox" style="width:100px" />
		<br>
		<label for="mem_pw">비 번</label>
		<input id="mem_pw" name="mem_pw" class="easyui-textbox" style="width:100px" />
		<br>
		<label for="mem_name">이 름</label>
		<input id="mem_name" name="mem_name" class="easyui-textbox" style="width:100px" />
		<br>
		<label for="mem_zipcode">우편번호</label>
		<input id="mem_zipcode" name="mem_zipcode" class="easyui-textbox" style="width:100px" />
		<a href="javascript:searchForm()" class="easyui-linkbutton">우편번호찾기</a>
		<br>
		<label for="mem_address">주 소</label>
		<input id="mem_address" name="mem_address" class="easyui-textbox" style="width:200px" />
		<br>
	</form>
		<a href="javascript:memberShip()" class="easyui-linkbutton">회원가입</a>
	</div>
	
<!-- [[우편번호 검색기 다이얼로그 화면 시작]] -->
	<div id="dlg_zipcode" footer="#btn_zipcode" class="easyui-dialog"
		 title="우편번호 검색하기" data-options="modal:true,closed:true"
		 style="width: 600px; height: 400px; padding: 10px">
		<div id="btn_zipcode" align="right">
			<a href="javascript:zipcodeClose()" class="easyui-linkbutton" iconCls="icon-clear">닫기</a>
		</div>
	</div>
<!-- [[우편번호 검색기 다이얼로그 화면  끝]] -->
</body>
</html>