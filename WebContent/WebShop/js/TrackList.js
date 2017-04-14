
$(function() {
	
	//Ajax呼叫產品資料與圖片--------------------------------
	$(document).ready(function(){
		var productId = "";
		var getPicSrc="http://localhost:8080/java004/_01_Product/getImage?id=";
		$.ajax({
	        url: '../_21_ShoppingOrder/SelectTtacking.do',
	        type:'POST',
	        data : "cmd=ALL" + "&productId=" + productId,
	        dataType:'json',
	        success: function(data){
	        	var content = "";	
	        	for (var i = 0; i < data.length; i++) {
	        		if(data[i].status == true){ //判斷上架還是下架
	
	        content +="<div class='col-md-3 col-sm-6 hero-feature'>"
	        		+ 	"<div class=thumbnail>"
	         		+ 		"<img src="+getPicSrc + data[i].productId + " alt>"
	        		+ 			"<div class=caption>"					
	        		+ 				"<strong><span class=name>" + data[i].name + "</span></strong>  $"
	        		+ 				"<span class=price>" + data[i].pgPrice + "</span><br>"
	        		+ 				"<span class=star-rating-product data-rating="+data[i].score+">"+data[i].score+"<b>星</b></span>"
	        	    + 				"<p>"
	        	    + 					"<button id="+ data[i].productId + " class='btn btn-primary'"						
	        		+ 					"data-toggle=modal data-target=.bs-iot>加入購物車</button>" 
	        	    + 				"</p>"
	        	    + 		"</div>"
	        	    +	"</div>"
	        	    +"</div>";
	        
	        	}
	        	var result = document.getElementById("wrap");
				result.innerHTML = content;
	        	}
	        	getStarRating(15);
	        	getIsotope();
	        }
		});
		
		$.ajax({	
	        url: '../_20_BuyProductServlet/BuyProductServlet.do',
	        type:'GET',
	        dataType:'json',
	        success:function(data){
	        	for(i=0;i<Object.keys(data).length;i++){
	        	arr.push(data[Object.keys(data)[i]].productId);
	        	var total = parseInt(data[Object.keys(data)[i]].qty)*parseInt(data[Object.keys(data)[i]].pgPrice);
	        	$('.cd-cart-items').append("<li id=cart"+data[Object.keys(data)[i]].productId+">"
	        			+"<span class=cd-qty >"+data[Object.keys(data)[i]].qty+"</span>"
	        			+data[Object.keys(data)[i]].name+"<div class=cd-price>$<em>"+total+"</em></div>"
	        			+"<a class=cd-item-remove cd-img-replace></a>"
	        			+"</li>");	
	        	}
	    		calculate();
	        }
		});
	});

	//從追蹤清單移除
	
	$('.modal-content').on('click','.btn-warning',function(){
		var thisID = $('.addcart-Modal_id').attr('id');
		$.ajax({
	        url: '../_22_ShoppingTrackingList/InsertTracking.do',
	        type:'POST',
	        dataType:'json',
	        data: "productId=" +　thisID,
	        success: function(data){
	        	alert(data);
	        },
	        erroe:function(error){
	        	alert("發生錯誤");
	        }
		});
	});

/* ---------------------------以下是共用function----------------------------*/

function getProductInfo(SetData){
	$('#wrap').ready(function(){
	var getPicSrc="http://localhost:8080/java004/_01_Product/getImage?id=";
	$.ajax({
        url: '../_01_Product/SelectProduct.do',
        type:'POST',
        dataType:'json',
        data: SetData,
        success: function(data){
        if(data.length ==0){
        	alert("查無商品資料");
        	return;
        }	
        	var content = "";	
        	for (var i = 0; i < data.length; i++) {
        		if(data[i].status == true){ //判斷上架還是下架

        content +="<div class='col-md-3 col-sm-6 hero-feature'>"
        		+ 	"<div class=thumbnail>"
         		+ 		"<img src="+getPicSrc + data[i].productId + " alt>"
        		+ 			"<div class=caption>"
        		+ 				"<strong><span class=name>" + data[i].name + "</span></strong> $"
        		+ 				"<span class=price>" + data[i].pgPrice + "</span><br>"
        		+ 				"<span class=star-rating-product data-rating="+data[i].score+">"+data[i].score+"<b>星</b></span>"
        	    + 				"<p>"
        	    + 					"<button id="+ data[i].productId + " class='btn btn-primary'"						
        		+ 					"data-toggle=modal data-target=.bs-iot>加入購物車</button>"
        	    + 				"</p>"
        	    + 		"</div>"
        	    +	"</div>"
        	    +"</div>";
        
        	}
        	var result = document.getElementById("wrap");
			result.innerHTML = content;
        	}
        	getStarRating(15);
        	getIsotope();
        }
	});	
	});	
}

function addToCart(thisID,itemName,itemPrice,qty) {
	$.ajax({	
        url: '../_20_BuyProductServlet/BuyProductServlet.do',
        type:'POST',
        data:"productId=" + thisID +"&name=" + itemName 
        	 + "&pgPrice=" + itemPrice + "&qty=" + qty,
        async:false,
        success:function(response){
        	$.ajax({	
    	        url: '../_20_BuyProductServlet/BuyProductServlet.do',
    	        type:'GET',
    	        dataType:'json',
    	        async:false,
    	        success:function(data){
    	        	var prev_charges = $('.cd-cart-total b span').html();
	    			var prev_qty = $('.cd-cart-total p span').html();
    	        	if(include(arr,thisID)){
    	        		$('#cart'+thisID).html("<span class=cd-qty>"+data[thisID].qty+"</span>"
	    	        			+data[thisID].name+"<div class=cd-price>$<em>"+data[thisID].pgPrice+"</em></div>"
	    	        			+"<a class=cd-item-remove cd-img-replace></a>");
    	        		//如果清單已有此項物品,改寫清單內的數量/價格/總價
    	        		//取該ID欄位內的產品價格跟現有數量
    	    			var price = $('#cart'+thisID).children(".cd-price").find('em').html();
    	    			var qty = $('#cart'+thisID).children(".cd-qty").html();		 
    	    			var total = parseInt(price)*parseInt(qty);
    	    			//覆寫該ID欄位內的產品價格
    	    			$('#cart'+thisID).children(".cd-price").find('em').html(total);
    	        	}else{
    	        		//如果清單內無此項物品,新增清單內的數量/價格/總價
    	        		arr.push(thisID);
    	        		$('.cd-cart-items').append("<li id=cart"+data[thisID].productId+">"
	    	        			+"<span class=cd-qty >"+data[thisID].qty+"</span>"
	    	        			+data[thisID].name+"<div class=cd-price>$<em>"+(data[thisID].pgPrice * data[thisID].qty)+"</em></div>"
	    	        			+"<a class=cd-item-remove cd-img-replace></a>"
	    	        			+"</li>");
    	        	}
    	        }
        	});	
        }
    });		
}	

});