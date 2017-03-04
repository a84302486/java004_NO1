<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
	response.setHeader("Cache-Control", "no-cache"); //Forces caches to obtain a new copy of the page from the origin server 
	response.setHeader("Cache-Control", "no-store"); //Directs caches not to store the page under any circumstance 
	response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale" 
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0 backward compatibility
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function confirmDelete(n) {
	if (confirm("確定刪除此項商品 ? ") ) {
		document.forms[0].action="<c:url value='UpdateItem.do?cmd=DEL&bookID=" + n +"' />" ;
		document.forms[0].method="POST";
		document.forms[0].submit();
	} else {
	
	}
}
function modify(key, qty, index) {
	var x = "newQty" + index;
	var newQty = document.getElementById(x).value;
	if  (newQty < 0 ) {
		window.alert ('數量不能小於 0');
		return ; 
	}
	if  (newQty == 0 ) {
		window.alert ("請執行刪除功能來刪除此項商品");
		document.getElementById(x).value = qty;
		return ; 
	}
	if  (newQty == qty ) {
		window.alert ("新、舊數量相同，不必修改");
		return ; 
	}
	if (confirm("確定將此商品的數量由" + qty + " 改為 " + newQty + " ? ") ) {
		document.forms[0].action="<c:url value='UpdateItem.do?cmd=MOD&bookID=" + key + "&newQty=" + newQty +"' />" ;
		document.forms[0].method="POST";
		document.forms[0].submit();
	} else {
		document.getElementById(x).value = qty;
	}
}
function isNumberKey(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode
   if (charCode > 31 && (charCode < 48 || charCode > 57)){
      return false;
   }
   return true;
}
function Checkout(qty) {
	if (qty == 0)  {
		alert("無購買任何商品，不需結帳");
		return false;
	}
	if (confirm("再次確認訂單內容 ? ") ) {
		return true;
	} else {
		return false;
	}
}
function Abort() {
	if (confirm("確定放棄購物 ? ") ) {
		return true;
	} else {
		return false;
	}
}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>購物清單</title>
</head>
<body>
	<table>
		<caption>購物車</caption>
		<tr>
			<th>序號</th>
			<th>商品信息</th>
			<th>單價（元）</th>
			<th>數量</th>
			<th>金額（元）</th>
			<th>操作</th>
		</tr>

		<tr>
			<td></td>
			<td><a href="" target="_blank" title=""></a></td>
			<td class="bold"></td>
			<td>
				<button type="button" class="btn btn-default btn-xs">－</button> <input
				type="text" size="5">
				<button type="button" class="btn btn-default btn-xs">＋</button>
			</td>
			<td class="bold mark"></td>
			<td>
				<button type="button" class="btn btn-default btn-xs">刪除</button>
			</td>
		</tr>
	</table>
	<div class="empty">購物車空空，快去尋找寶貝</div>
	<div class="total">
		已選商品：<span>123</span> 合計： <span class=" mark">456</span> <span
			class=" mark"> 789<span class="btn btn-xs">(9折)</span> <span
			class="discount">555</span>
		</span>
		<button type="button" class="btn btn-primary btn-sm">結 算</button>
	</div>
</body>
</html>