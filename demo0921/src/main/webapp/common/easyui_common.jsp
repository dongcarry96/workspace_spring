<%
// 확장자를 jsp로 해야 스클립틀릿 사용이 가능함
// 프로젝트 이름마다 경로가 다를 수 있다
// 매번 그때마다 경로를 수정한다???
// WAS에서 관리하는 server.xml문서에서 Context에 정보를 가져오는 메소드 호출임

	StringBuilder path = new StringBuilder(request.getContextPath());
	path.append("/");
%>   
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=path.toString() %>themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=path.toString() %>demo/demo.css">
<link rel="stylesheet" type="text/css" href="<%=path.toString() %>themes/icon.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.js"></script>