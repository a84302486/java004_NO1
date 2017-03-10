<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <%  	
    
     String username = (String) session.getAttribute("username");
     if(username == null) {
         response.setHeader("Refresh", "0; " + "http://localhost:8080/Java004NO1/_00_Login/Home.jsp");
         return;
    }
     else {
        // 立即登出
         session.invalidate();
   }
%> --%>
	<table style="border: 5px double rgb(109, 2, 107); height: 150px; background-color: rgb(255, 255, 255); width: 400px;" >

		<tbody>
		<tr>
			<td>產品資訊
				<a href="_01_Product/ProductMain.jsp">產品</a>
				<a href="_02_Taste/TasteMain.jsp">口味</a> 
				<a href="_03_Package/PackageMain.jsp">包裝</a> 
				<a href="_05_Composition/CompositionMain.jsp">成份</a> 
				<a href="_04_">產品型錄</a> 
			</td>
		</tr>
		<tr>
			<td>基本資料 
				<a href="_06_Supplier/SupplierMain.jsp">廠商資料</a>
				<a href="_07_Customer/CustomerMain.jsp">客戶資料</a> 
				<a href="_08_">員工資料</a> 
				<a href="_14_Member/MemberMain.jsp">會員資料</a>
			</td>
		</tr>
		<tr>
			<td>庫存管理 
				<a href="_10_Warehouse/WarehouseMain.jsp">產品庫存</a>
				<a href="_11_StockUpdate/StockUpdateMain.jsp">實盤更新</a>
				
			</td>
		</tr>
		<tr>
			<td>交易系統
				<a href="_08_Discount/DiscountMain.jsp">折扣</a>
				<a href="_09_Commission/CommissionMain.jsp">佣金</a>
			</td>
		</tr>
		</tbody>

	</table>
</body>
</html>