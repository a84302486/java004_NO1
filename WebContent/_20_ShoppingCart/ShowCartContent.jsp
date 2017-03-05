<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/shoppingCart.css">
<title>購物清單</title>

</head>
<body>
	<div>
		<table class="shopList">
			<caption>購物清單</caption>
			<tr>
				<th>序號</th>
				<th>圖片</th>
				<th>商品名稱</th>
				<th>單價</th>
				<th>數量</th>
				<th>金額</th>
				<th>操作</th>
			</tr>
			<tr>
				<td>1</td>
				<td></td>
				<td class="name">牛肉麵
					<a href="" target="_blank" title=""></a>
				</td>
				<td class="price">200</td>
				<td>
					<button class="minus" onclick="changeAmount($(this));">－</button> 
					<input class="count" value="2" type="text" size="1" readonly>
					<button class="plus"  onclick="changeAmount($(this));">＋</button>
				</td>
				<td class="total"></td>
				<td>
					<button type="button" class="delete" onclick="setDel($(this));">刪除</button>
				</td>
			</tr>
			<tr>
				<td>2</td>
				<td></td>
				<td>滷肉飯
					<a href="" target="_blank" title=""></a>
				</td>
				<td class="price">100</td>
				<td>
					<button class="minus" onclick="changeAmount($(this));">－</button> 
						<input class="count" value="3" type="text" size="1" readonly >
					<button class="plus" onclick="changeAmount($(this));" >＋</button>
				</td>
				<td class="total"></td>
				<td>
					<button type="button" class="delete" onclick="setDel($(this));">刪除</button>
				</td>
			</tr>
		</table>
		<div class="details">
			已選商品：
			<span class="amount"></span><br>
			合計： 
			<span class="subtotal"></span><br>
			折扣： 
			<span class="mark">
				<span class="discount"></span>
				<span class="discounted"></span>
			</span><br>
			<button type="button" class="billing">結 帳</button>
		</div>
	</div>
</body>
<script src="${pageContext.request.contextPath}/jQuery/jquery-2.2.4.min.js" type="text/JavaScript"></script>
<script src="${pageContext.request.contextPath}/js/shoppingCart.js" type="text/JavaScript"></script>
</html>