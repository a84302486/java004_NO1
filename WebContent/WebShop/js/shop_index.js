
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
	        		if(data[i].status == true){
	        			
	        content +="<div class='col-md-3 col-sm-6 hero-feature'>"
	        		+ 	"<div class=thumbnail>"
	         		+ 		"<img src="+getPicSrc + data[i].productId + " alt>"
	        		+ 			"<div class=caption>"
	        		+ 				"<span class=name>" + data[i].name + "</span>: NT"
	        		+ 				"<span class=price>" + data[i].pgPrice + "</span>"
	        	    + 				"<p>包裝:</p>"
	        	    + 				"<p>"
	        	    + 					"<button id="+ data[i].productId + " class='btn btn-primary'>加入購物車"
	        		+ 						"<input type=hidden value="+ data[i].productId +"|"+ data[i].name 
	        		+						"|images/"+data[i].fileName + "|" + data[i].pgPrice+ ">"
	        		+ 					"</button>" 
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
	
	//點擊商品新增至購物清單,並檢查物品是否重覆------------------
	function include(arr, obj) {
	  for(var i=0; i<arr.length; i++) {
	    if (arr[i] == obj) return true;
	  }
	}
	
	var arr=new Array();
	var storage = sessionStorage;
			
	$('#wrap').on("click","button",function(){
		var thisID = $(this).attr('id');		
		var itemName  = $(this).parent().parent().find('.name').html();
		var itemPrice = $(this).parent().parent().find('.price').html();

		if(include(arr,thisID)){
			//如果清單已有此項物品,改寫清單內的數量/價格/總價
			var price = $('#each-'+thisID).next(".cd-price").find('em').html();
			var qty = $('#each-'+thisID).html();
			qty = parseInt(qty)+parseInt(1);
			
			var total = parseInt(itemPrice)*parseInt(qty);
			$('#each-'+thisID).next(".cd-price").find('em').html(total);
			$('#each-'+thisID).html(qty);
			
			var prev_charges = $('.cd-cart-total b span').html();
			prev_charges = parseInt(prev_charges)-parseInt(price);			
			prev_charges = parseInt(prev_charges)+parseInt(total);
			$('.cd-cart-total b span').html(prev_charges);
			
			var prev_qty = $('.cd-cart-total p span').html();
				prev_qty = parseInt(prev_qty)+1;
			$('.cd-cart-total p span').html(prev_qty);
			
		}else{	
			//如果清單內沒有此項物品,新增至清單
			arr.push(thisID);
			//計算總金額
			var prev_charges = $('.cd-cart-total b span').html();
			var info = $('#'+thisID).find('input').val();
			prev_charges = parseInt(prev_charges)+parseInt(itemPrice);
			$('.cd-cart-total b span').html(prev_charges);
			//計算總數量
			var prev_qty = $('.cd-cart-total p span').html();
				prev_qty = parseInt(prev_qty) + 1;
			$('.cd-cart-total p span').html(prev_qty);
			
			$('.cd-cart-items').append('<li><span class=cd-qty id="each-'+thisID+'">1</span>'+itemName
			+'<div class=cd-price>$<em>'+itemPrice+'</em></div><a class=cd-item-remove cd-img-replace></a>'
			+'<input type=hidden value='+ info +'>'
			+'</li>');
		}		
		//圓球顯示購物車物品總量------------------
		var get_cart_total = $('.cd-cart-total p span').html();	
		$('.cartCount').html(get_cart_total);	
		});
	
		$(this).one("click",function(){
		list.addClass('speed-in');	
	});	
		
	//點擊X刪除該商品--------------------------------
	$(document).on('click','.cd-item-remove',function(){
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
		
		var id = $(this).prevAll().eq(1).attr('id').replace('each-','');;
		var idx = arr.indexOf(id);
		arr.splice(idx,1,0)
		$(this).parent().remove(); 	
	});	
	
	//點擊結算商品--------------------------------
	$(document).on('click','.checkout-btn',function(){	
		for(key=0; key< $('.cd-cart-items li').size();key++){			
		var qty = $('.cd-qty').eq(key).html();
		var info = $('input').eq(key).val();
		storage[key] = info + "|" + qty;
		}
	});
});

