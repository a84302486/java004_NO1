<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<c:remove var="MemberLoginOK" />
<%
	session.invalidate();
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {

		try {
			for (int i = 0; i < cookies.length; i++) {
				//System.out.println(cookies[i].getName() ":" cookies[i].getValue())；
				Cookie cookie = new Cookie(cookies[i].getName(), null);
				cookie.setMaxAge(0);
				cookie.setPath("/");
				response.addCookie(cookie);
			}
			System.out.println("登出刪除cookies 成功");
		} catch (Exception ex) {
			System.out.println("登出刪除cookies 異常");
		}

	}
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script>
	alert("您已經成功登出!!");
	document.location.href="shop_index.jsp";
</script>
<title>登出</title>
</head>
<body>
您已經登出<P/>
<!-- 
<a href="../index.jsp">回首頁</a>
 -->
<a href="<c:url value='../WebShop/shop_index.jsp' /> ">回首頁</a>
</body>
</html>