<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="../WebShop/shop_index.jsp">購物平台</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse " id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                	<li>
                	<c:choose>
						<c:when test="${empty MemberLoginOK}">
							<a href="../WebShop/login_and_register.jsp">登入/註冊</a>
						</c:when>
            			<c:otherwise>
            				<a href="../WebShop/memberManage.jsp">會員管理</a>
						</c:otherwise>
        			</c:choose>
                    </li>
					
					<li><a href="../WebShop/cartEdit.jsp">購物車</a></li>
					<li><a href="../WebShop/index.html">觀光工廠</a></li>		
                 </ul>   
            </div>
        </div>
     
    </nav>
