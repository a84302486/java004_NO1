
$(function() {
	$(document).ready(function(){
		var items = $('.thumbnail').each(function(){
			var productId = $(this).attr('id');		
	
	        	$.ajax({
	        		 url: '../_05_Stock/getProductStock.do',
	     	        type:'POST',
	     	        data : "productId=" + productId,
	     	        dataType:'json',
	     	        success: function(quantity){	
	     	        	if(quantity ==0){
	     	        		$('#'+productId).find('.btn-primary').prop("disabled",true);
	     	        		$('#'+productId).find('.price').after("<span id=mark>已售完</span>");
	     	        	}
	     	        	
	     	        	$.ajax({	
		     	   	        url: '../_20_BuyProductServlet/BuyProductServlet.do',
		     	   	        type:'GET',
		     	   	        dataType:'json',
		     	   	        success:function(cart){
		     	   	        var newQty = parseInt(quantity - cart[productId].qty);  
		     	   	        if(newQty ==0 || newQty ==null ){
		     	   	        $('#'+productId).find('.btn-primary').prop("disabled",true);
	     	        		$('#'+productId).find('.price').after("<span id=mark>已售完</span>");
		     	   	        }
	     	   	        }
	     	   		});  	        
	     	     }
	        });
		});
	});
	
	
	
	
	// 從追蹤清單移除
	$('#warp').on('click','.btn-danger',function(){
		var thisID = $('.thumbnail').attr('id');
		$.ajax({
	        url: '../_22_ShoppingTrackingList/DeleteTracking.do',
	        type:'POST',
	        dataType:'json',
	        data: "productId=" +　thisID,
	        success: function(data){
	        	alert(data);
	        },
	        complete: function(data){
	        	location.reload();
	        },
	        erroe:function(error){
	        	alert("發生錯誤");
	        }
		});	
	});

	$('#warp').on('click','.btn-primary',function(){
		var thisID = $('.thumbnail').attr('id');
		var itemName  = $('#'+thisID).find('.name').text();
		var itemPrice = $('#'+thisID).find('.price').text();
		var qty = "1";
		$.ajax({	
	        url: '../_20_BuyProductServlet/BuyProductServlet.do',
	        type:'POST',
	        data:"productId=" + thisID +"&name=" + itemName 
	        	 + "&pgPrice=" + itemPrice + "&qty=" + qty,
	        async:false,
	        complete:function(){
	        	alert("加入購物清單成功");
	        }
	    });	
	});

		// 取得星級評價
		$('.star-rating-product').starRating({
			totalStars : 5,
			starSize : 15,
			emptyColor : 'lightgray',
			hoverColor : 'salmon',
			useGradient : false,
			readOnly : true,
		});

		// 如果追蹤清單是空的,顯示的文字
		if( $('.thumbnail').length==0){
			var txt1=$("<h3 class=alertMsg></h3>")
				.text("目前您的追蹤清單是空的").css("color","red");					
			$('#warp').append(txt1,"<h2><a href=../WebShop/shop_index.jsp>"
				+ "您可以前往我們商城，加入您喜歡的商品。</a></h2>");
		}	
});