

//Insert:新增該資料,並由Servelet回傳是否成功的json字串,再顯示至畫面-----
$("#loadPageDiv").on("click", "#insertStockBtn", function() {
	var productId = $("input[name='productId']").val();
	var quantity =  $("input[name='quantity']").val();

	$.ajax({
		url:"../_05_Stock/InsertStock.do",
		data : "productId=" + productId + "&quantity=" + quantity,
		type : 'POST',
		dataType : 'json',
		cache : false ,		
		success : function(responseText) {
			$('#insertResult').text(responseText);
			var name = "productId" , value="";
			getStockData(name , value);
		},
		error : function(responseText) {
			alert("發生錯誤,請連絡管理人員");
		},
	});
	
});


// Insert跟Update時使用的方法,會取出Form內每個name的value值----------------
function setQueryString() {
	queryString = "";
	var frm = document.forms[0];
	var numberElements = frm.elements.length;
	for (var i = 0; i < numberElements; i++) {
		if (i < numberElements - 1) {
			// alert(frm.elements[i].name);
			// alert(frm.elements[i].value);
			queryString += frm.elements[i].name + "="
					+ encodeURIComponent(frm.elements[i].value) + "&";
		} else {
			queryString += frm.elements[i].name + "="
					+ encodeURIComponent(frm.elements[i].value);
		}
	}
	return queryString;
}

// 搜尋載入頁面替換Section內容----------------------------------------------
$("#loadPageDiv").on("click", "input[type='button']", function() {
	var $this = $(this).attr("id");

	var val = null;
	if($this == "productId" ){
		val = $("input[name='productId']").val();
	}else if($this == "stockMFG"){
		val = $("input[name='mfg']").val();
	}else if($this == "stockEXP"){
		val = $("input[name='exp']").val();
	}

	getStockData($this , val);
	
});
	


function getStockData(name , value) {
	
	var content = "<table>" + "<tr><td>選取</td><td>庫存序號</td>"
	+ "<td>產品序號</td>" + "<td>製造日</td>"
	+ "<td>到期日</td>" + "<td>數量</td></tr>";
	
	$.ajax({
		url : "../_05_Stock/SelectStock.do",
		data :"cmd=" + name + "&val=" + value,
		type : 'POST',
		dataType : 'json',
		cache : false,
		success : function(data) {
			for (var i = 0; i < data.length; i++) {
				content += "<tr>"
						+ "<td><input type=radio name=productId value="
						+ data[i].productId + ">" + "<td>" + data[i].stockId
						+ "</td>" + "<td>" + data[i].productId + "</td>"
						+ "<td>" + data[i].mfg + "</td>" + "<td>" + data[i].exp
						+ "</td>" + "<td>" + data[i].quantity + "</td>"
						+ "</tr>"
			}
			content += "</table>";
			$('#showResult').html(content);
		},
		error : function(data) {
			alert("發生錯誤,請連絡管理人員");
		},
	})
};
// Select讀取透過Servelet取出的Json資料,替換Section內容------------------------------


// Delete:判斷讀取到的name並取出值,判斷是否刪除該筆資料,並由Servelet回傳是否成功的json字串,再顯示至畫面--------
//$("#loadPageDiv").on("click",'.delete',function() {
//			var setServlet;
//			var getName = $('input:radio:checked').attr('name');
//			var selected = $("input:radio[name=" + getName + "]:checked").val();
//
//			if (selected != null) { // 如果有被選取,不是空值
//				if (confirm("確定要刪除" + selected + "嗎?")) {
//					var xhr = new XMLHttpRequest();
//					xhr.open("POST", "DeleteProduct.do", true);// send要傳參數一定要用POST
//					xhr.setRequestHeader("Content-type",
//							"application/x-www-form-urlencoded");
//					xhr.send(getName + "=" + selected);
//					xhr.onreadystatechange = function() {
//						if (xhr.readyState == 4 && xhr.status == 200) {
//							var data = JSON.parse(xhr.responseText);
//							var result = document.getElementById("showDAOJsp");
//							result.innerHTML = "<h3>" + data + "<h3>";
//							getQueryData('SelectProduct.do');
//						}
//					}
//				}	
//			} else {
//				alert("請選勾選要刪除的資料");
//			}
//		});




// 被點選的Radio改變背景顏色-------------------------
$("#loadPageDiv").on("change",'input:radio',function() {
	if ($(this).is(':checked')) {// 判斷radio是否勾選
		$(this).parent().parent().addClass('highlight').siblings()
		.removeClass('highlight');// 被點擊的增加CSS樣式並移除其他radio的CSS樣式
		}
	});


