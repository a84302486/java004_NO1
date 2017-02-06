<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登入頁面</title>
</head>
<body>
    輸入密碼登入：<br>
    <hr>
    <form action="http://localhost:8080/java004/_00_Login/Login.jsp" method="POST">
        名稱：<input type="text" name="username"> <br>
        密碼：<input type="password" name="password"> <br>
        <input type="submit" value="登入">
    </form>

</body>
</html>