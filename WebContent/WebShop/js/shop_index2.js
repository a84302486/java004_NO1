
$(function() {
	//點擊呼叫購物清單--------------------------------
	var list = $('#cd-cart'),
	trigger = $('#cd-cart-trigger');

	trigger.on('click', function(){
		if( list.hasClass('speed-in')) {
			list.removeClass('speed-in');
		} else {
			list.addClass('speed-in');
		}
	});
	
	//Ajax呼叫產品資料與圖片--------------------------------
	$(document).ready(function(){
		var getPicSrc="http://localhost:8080/java004/_01_ProductTest/getImage?id=";
		$.ajax({
	        url: '../_01_ProductTest/SelectProduct.do',
	        type:'POST',
	        dataType:'json',
	        success: function(data){
	        	var content = "<p>產品列</p>";	
	        	for (var i = 0; i < data.length; i++) {
	        		if(data[i].status == true){ //判斷上架還是下架
	
	        content +="<div class='col-md-3 col-sm-6 hero-feature'>"
	        		+ 	"<div class=thumbnail>"
	         		+ 		"<img src="+getPicSrc + data[i].productId + " alt>"
	        		+ 			"<div class=caption>"
	        		+ 				"<span class=name>" + data[i].name + "</span>: NT"
	        		+ 				"<span class=price>" + data[i].pgPrice + "</span>"
	        	    + 				"<p>包裝:</p>"
	        	    + 				"<p>"
	        	    + 					"<button id="+ data[i].productId + " class='btn btn-primary'>"						
	        		+ 					"加入購物車</button>" 
	        		+ 					"<a href=# class='btn btn-default'>More Info</a>"
	        	    + 				"</p>"
	        	    + 		"</div>"
	        	    +	"</div>"
	        	    +"</div>";
	        	}
	        	var result = document.getElementById("wrap");
				result.innerHTML = content;
	        	}
	        }
		});
	});
			
	$('#wrap').on("click","button",function(){			
		var thisID = $(this).attr('id');		
		var itemName  = $(this).parent().parent().find('.name').html();
		var itemPrice = $(this).parent().parent().find('.price').html();

		$.ajax({	
	        url: '../_20_BuyProductServlet/BuyProductServlet.do',
	        type:'POST',
	        data:"productId=" + thisID +"&name=" + itemName 
	        	 + "&pgPrice=" + itemPrice + "&qty=1",
	        async:false,
	    });
		

		//設置總數量至彈跳示窗購物清單--------------
		var price = $(thisID).next(".cd-price").find('em').html();
		var qty = $(thisID).html();
//		qty = parseInt(qty)+parseInt(1);
		
		var total = parseInt(itemPrice)*parseInt(qty);
		$(thisID).next(".cd-price").find('em').html(total);
		$('.cd-cart-total').html(qty);
		
		
		var prev_charges = $('.cd-cart-total b span').html();
		
		//圓球顯示購物車物品總量------------------
		var get_cart_total = $('.cd-cart-total p span').html();	
		$('.cartCount').html(get_cart_total);	
	});
	
		//點擊時觸發一次購物車彈出------------------
		$(this).one("click",function(){
		list.addClass('speed-in');	
		});	
		
	//點擊X刪除該商品--------------------------------
	$(document).on('click','.cd-item-remove',function(){

		var id = $(this).prevAll().eq(1).attr('id');		
		$.ajax({	
	        url: '../_20_ShoppingCart/UpdateProductServlet.do',
	        type:'POST',
	        data:"cmd=DEL" + "&productId=" + id ,
	    });
		
		//計算總金額
		var p = $(this).parent().find('em').html();
		var prev_charges = $('.cd-cart-total b span').html();
		prev_charges = parseInt(prev_charges)- parseInt(p);
		$('.cd-cart-total b span').html(prev_charges);
		//計算總數量
		var q = $(this).parent().find('.cd-qty').html();
		var prev_qty = $('.cd-cart-total p span').html();
		prev_qty = parseInt(prev_qty)- parseInt(q);
		$('.cd-cart-total p span').html(prev_qty);
		
		//計算圓球購物車物品總量------------------
		var get_cart_total = $('.cd-cart-total p span').html();	
		$('.cartCount').html(get_cart_total);	
		
		$(this).parent().remove(); 	
	});	
});
