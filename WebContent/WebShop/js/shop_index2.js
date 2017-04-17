
$(function() {
	//點擊呼叫購物清單--------------------------------
	var list = $('#cd-cart');

	$('#cd-cart-trigger').on('click', function(){
		if( list.hasClass('speed-in')) {
			list.removeClass('speed-in');
		} else {
			list.addClass('speed-in');
		}
	});
	
	//Ajax呼叫產品資料與圖片--------------------------------
	$(document).ready(function(){
		var productId = "";
		var getPicSrc="http://localhost:8080/java004/_01_Product/getImage?id=";
		$.ajax({
	        url: '../_01_Product/SelectProduct.do',
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
	
	//點擊商品新增至陣列內,並檢查物品是否重覆------------------
	var arr=new Array();
	function include(arr, obj) {
		  for(var i=0; i<arr.length; i++) {
		    if (arr[i] == obj) return true;
		  }
		}

	//點擊X刪除該商品--------------------------------
	$(document).on('click','.cd-item-remove',function(){
		var id = $(this).parent().attr('id').replace('cart','');
		//點刪除該商品session--------------------------------
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
		
		//將該商品從陣列內刪除------------------
		var idx = arr.indexOf(id);
		arr.splice(idx,1,0)
	
		$(this).parent().remove(); 	 	
	});	
	
	//預設所有產品為被點擊
	$('#filter li').eq(0).addClass('active');
	//點產品類別增加active
	$('.nav-justified li').click(function(){	
		$(this).addClass('active').siblings('.active').removeClass('active');
		var getType = $(this).attr('id');
		getProductInfo(getType)
	});
	
	//搜尋產品
	$('#search').click(function(){	
		var string = $('.form-control').val(); 		
		var data ="cmd=Name&productName=" + string; 	
		if(string.length ==0 || string.trim()==null){
			alert("請輸入搜尋條件");
		}else{
			getProductInfo(data);
		}
	});
	
	
	//點主頁加入購物車,顯示modal內容
	$('#wrap').on('click','.btn-primary',function(){	
		$('.btn-submit').removeAttr('disabled');
		$('.extra_cart p').remove();
		$('#star-rating-modal').remove();
		$('#star-score').remove();
		$('#modal-count').val("1");
		var productId = $(this).attr('id');
		var getPicSrc="http://localhost:8080/java004/_01_Product/getImage?id=";
		$.ajax({
	        url: '../_01_Product/SelectProduct.do',
	        type:'POST',
	        data : "cmd=SINGLE" + "&productId=" + productId,
	        dataType:'json',
	        success: function(data){
	        	
	        	$('.modal-content h3').html(data[0].name)
	        		.after("<div id=star-score><span>已有" +data[0].comments+"個人評價"
	        			 + "</sapn><br><span id=star-rating-modal></span>"
	        			 + "</sapn> " +　data[0].score + "星" +　"</span></div>");
	        	$('.toggle-image img').attr("src", getPicSrc + data[0].productId);
	        	$('.col-md-8 h4').html("$"+data[0].pgPrice);  
	        	$('.addcart-Modal_id').attr('id',data[0].productId);
	        	
	    		getStarModal(data[0].score);
	        	$.ajax({
	        		 url: '../_05_Stock/getProductStock.do',
	     	        type:'POST',
	     	        data : "productId=" + productId,
	     	        dataType:'json',
	     	        success: function(quantity){
	     	        	$('.addcart-Modal_id').val(quantity);
	     	        	if(quantity <=0 || quantity ==null ){
	     	        		$('.btn-submit').prop("disabled",true); 
	     	        		$('.btn-warning').after("<p>已售完</p>");
	     	        		$('#modal-count').val("0");
	     	        	}
	     	        	
	     	        	$.ajax({	
		     	   	        url: '../_20_BuyProductServlet/BuyProductServlet.do',
		     	   	        type:'GET',
		     	   	        dataType:'json',
		     	   	        success:function(cart){
		     	   	        
		     	   	        var newQty = parseInt(quantity - cart[productId].qty);
		     	   	        $('.addcart-Modal_id').val(newQty);  
		     	   	        if(newQty ==0 || newQty ==null ){
	     	        		$('.btn-submit').prop("disabled",true);  
	     	        		$('.btn-warning').after("<p>已售完</p>");
	     	        		$('#modal-count').val("0");
		     	   	        }
	     	   	        }
	     	   		});  	        
	     	        }
	        	});
	        }
	    });
	});
	
//計算modal內的modal-count欄位的數量
$(document).on('click','.number-spinner button',function() {
		 var btn = $(this), 
		 	 quantity = parseInt($('.addcart-Modal_id').val()),
		 	 oldValue = btn.closest('.number-spinner').find('input').val().trim(), 
		 	 newVal = 0;
		 
		 if (btn.attr('data-dir') == 'up') {
			 newVal = parseInt(oldValue) + 1;
			 if (newVal > quantity) {
				 if(quantity>0){
						alert("目前庫存只剩" + quantity + "個");
						newVal = quantity;
					}else if(quantity<=0){
						alert("目前庫存只剩0個");
						newVal = 0;
					}
			 	}
			} else if(btn.attr('data-dir') == 'dwn') {
				if (oldValue > 1) {
					newVal = parseInt(oldValue) - 1;					
				}else{
					newVal = 1; 
				}
			}		
			btn.closest('.number-spinner').find('input').val(newVal);	
	});

//計算modal內的modal-count欄位的數量變更時
	$(document).on('change','#modal-count',function() {
				var quantity = $('.addcart-Modal_id').val(), 
					newVal = $('#modal-count').val().trim();

				if (newVal > quantity) {
					if(quantity>0){
						alert("目前庫存只剩" + quantity + "個");
						newVal = quantity;
					}else if(quantity<=0){
						alert("目前庫存只剩0個");
						newVal = 0;
					}					
				}else if(newVal <= 0){
					newVal = 1;
				}
				
				$('#modal-count').val(newVal);
			});
	
	//點modal 內的button後加入購物車
	$('.modal-content').on('click','.btn-submit',function(){
		var thisID = $('.addcart-Modal_id').attr('id');  	
		var itemName  = $('.modal-content h3').html();
		var itemPrice = $('.col-md-8 h4').html().replace('$','');
		var qty = $('#modal-count').val();
			
		addToCart(thisID,itemName,itemPrice,qty);	
		calculate();
		
		//點擊時觸發購物車彈出------------------
		$('#cd-cart').addClass('speed-in');
	});

	//加入追蹤清單
	
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
        if(data.length ==0 || data==null){
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

//計算清單各欄數量及金額
function calculate(){
	var amount = 0 ;
	var t_qty = 0 ;
	for(i=0;i < $('.cd-cart-items li').length; i++){	
		var qty = parseInt($('.cd-cart-items li').eq(i).children(".cd-qty").html());
		var price = parseInt($('.cd-cart-items li').eq(i).children(".cd-price").find('em').html());		
		t_qty += qty;
		amount += price;
	}
	//設置總數量至彈跳示窗購物清單--------------
	$('.cd-cart-total p span').html(t_qty);
	$('.cd-cart-total b span').html(amount);
	//圓球顯示購物車物品總量------------------
	var get_cart_total = $('.cd-cart-total p span').html();	
	$('.cartCount').html(get_cart_total);
	//設定modal-count為1-----------------
	$('#modal-count').val("1");
}

//取得星級評價
function getStarRating(size){
		$('.star-rating-product').starRating({
			totalStars : 5,
			starSize : size,
			emptyColor : 'lightgray',
			hoverColor : 'salmon',
			useGradient : false,
			readOnly : true,
		});
	}

//Modal內取得星級評價
function getStarModal(score){
		$('#star-rating-modal').starRating({
			totalStars : 5,
			starSize : 20,
			initialRating: score,
			emptyColor : 'lightgray',
			hoverColor : 'salmon',
			useGradient : false,
			readOnly : true,
		});
	}

//設置Isotope屬性
function getIsotope(){	
	var $grid =  $("#wrap");
	$grid.isotope('destroy');
	 
	 $grid.isotope({        		
		itemSelector: '.hero-feature',
		layoutMode: 'fitRows',
		getSortData: {
		name:'.name',
		price: function( itemElem ) {        		
			var price = $( itemElem ).find('.price').text();
			return parseFloat( price);
		},
		priceDESC: function( itemElem ) {        		
			var price = $( itemElem ).find('.price').text();
			return parseFloat( price);
		},
		star: function( itemElem ) {	  
    		var star = $( itemElem ).find("span[data-rating]").text();
    		return parseFloat( star);
		},
		starDESC: function( itemElem ) {	  
    		var star = $( itemElem ).find("span[data-rating]").text();
    		return parseFloat( star);
		},
	}
});
		        		      
// bind sort button click
$('#sort').on( 'click', 'li', function() { 
	var sortValue = $(this).attr('data-sort-by');  
	$grid.isotope({ 
		sortBy: sortValue ,		
			sortAscending:{
				priceDESC:false,
				starDESC: false
			}       		
		});
	});
}
});