<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pass");
	String url = "login.jsp";
	String msg = "�α��ο� ���� �Ͽ����ϴ�.";


	if(id.equals("himan@naver.com")&&pwd.equals("11")){
		session.setAttribute("idKey" ,id);
		msg = "�α��ο� ���� �Ͽ����ϴ�.";
		url = "main.jsp";
	}
%>
<script>
	alert("<%=msg%>");
	location.href="<%=url%>";
</script>