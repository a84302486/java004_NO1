<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    
    
    if(username == null || password == null) {
        response.setHeader("Refresh", "0; " + "Home.jsp");
    }
    else if(username.equals("user") && password.equals("1234")) {
        session.setAttribute("username", username);
        response.setHeader("Refresh", "1; " + "http://localhost:8080/java004/TopMenu.jsp");
        out.println(username + "歡迎登入！1秒後進入主選單！");
    }
    else {
        response.setHeader("Refresh", "1; " + "Home.jsp");
        out.println("使用者或密碼錯誤，請重新登入（1秒後回到登入表單）");
    }
%>