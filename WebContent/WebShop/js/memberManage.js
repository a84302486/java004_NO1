$(document).ready(function(){

	//自動搜尋會員訂單
	orderSelect('../_21_ShoppingOrder/SelectOrder','#orderResult','#memberVal');
	
	$('#orderResult').on('click', '.btn-danger', function() {
		
		var orderId = $(this).attr("id");
		
		if(confirm('您確定要取消訂單編號'+orderId+'的訂單?')){
			location.href ='../_21_ShoppingOrder/DeleteOrder?OrderId='+orderId;
		}else{
			return;
		}
	});
	
	$('#update-member').click(function() {
		
		memberUpdate('../_14_Member/Update', '#update-member-form');
		
	});
	
	$('#update-member-pwd').click(function() {
		
		passwordUpdate('../_14_Member/UpdatePassword', '#update-memberpassword-form');
		
	});
	

//	// 把每一個有 .password 的密碼輸入框做處理
//	$(':password').each(function(){
//		// 先取得 #password1 及產生一個文字輸入框
//		// 並產顯示密碼用的勾選框
//		var $password = $(this), 
//			$checkbox = $('<label><input type="checkbox" />顯示密碼</label>'),
//			$old = null,
//			$new = '<div class="col-sm-6">'
//				  +'<input type="text" id='+$password.attr('id')
//				  +' class="form-control password"'
//				  +' name='+$password.attr('name')
//				  +' value='+$password.val()
//				  +'/>'
//				  +'<label><input type="checkbox" />隱藏密碼</label>'
//				  +'</div>';
//		
//		// 把勾選框加在密碼輸入框的後面
//		$password.after($checkbox);
//		$old = $password.parent().html();
//		
//		// 當勾選顯示密碼框時
//		$checkbox.find(':checkbox').click(function(){
//			// 如果是勾選則...
//			if(this.checked){
//				$(this).parent().parent().html($new);
//			}else{
//				$(this).parent().parent().html($old);
//			}
//		});
//	});
	
	
});

function orderSelect(servelet, resultId, inputId) {
	var queryString = "Username="+$(inputId).val();
	$.ajax({
		url: servelet,
		dataType: 'json',
		resetForm: true,
		data: queryString,
        success: function(result){
        	orderResult(result, resultId, inputId);       	
        }
	});
}

function orderResult(result, resultId, inputId){
	var deleteFlag = true;
	var orderId = "";
	var content =""	
		   +'<section class="order-content">'
		   +'<div class="tab-content">'
		   +'<h3 class="side-heading">'
		   +'<span class="text">訂單歷史紀錄</span>'
		   +'</h3>'
		   +'<hr>'
  
		   +'<div id="order">'
		   +'<div>'
		   +'<table class="table table-order" id="order-record">'
		   +'<tr>'
           +'<th class="col-sm-3 col-md-2 control-label">訂單編號</th>'
           +'<th class="col-sm-3 col-md-2 control-label">訂購時間</th>'
           +'<th class="col-sm-3 col-md-2 control-label">出貨時間</th>'
           +'<th class="col-sm-3 col-md-2 control-label">訂單金額</th>'
           +'<th class="col-sm-3 col-md-2 control-label">訂單狀態</th>'
           +'</tr>';

           $.each(result, function(key, value){
        	   
        	   content +='<tr>';
        	   $.each(value, function(key, value){
        		
        		if(key=='OrderId'){
        			orderId = value;
        			content += "<td class='col-sm-12 col-md-2'><a href=../_21_ShoppingOrder/orderDetail?Username="+$(inputId).val()+"&OrderId="+value+">"+value+"</a></td>";
        			
        		}else{
        			content += "<td class='col-sm-12 col-md-2'>"+value+"</td>";
        		}
        		
        		if(key=='ShippedDate'){
              	    var ShippedDate = value; 
              		var CurrentDate = new Date();
              		if ( (Date.parse(ShippedDate)).valueOf() < (Date.parse(CurrentDate)).valueOf()){
              			deleteFlag = false;
              		}else{
              			deleteFlag = true;
              		}
              	}
        		
	   			});
        	  
        	   if(deleteFlag){
        		   content += "<td class='col-sm-12 col-md-1'>"
        		   	   	+"<button type=button class='btn btn-danger' id="+orderId+">"
        		   	   	+"<span class='glyphicon glyphicon-remove'></span> 取消"
        		   	   	+"</button>"
        		   	   	+"</td>";
        	   }else{
        		   content += "<td class='col-sm-12 col-md-1'>"
       		   	   		+"<button type=button class='btn btn-success' disabled>"
       		   	   		+" 已出貨"
       		   	   		+"</button>"
       		   	   		+"</td>";
        	   }
        	   		
        	   content +='</tr>';
           });
            
  content +='</tbody>'
           +'</table>'
           +'</div>'
           +'</div>'
           +'</div>'
           +'</section>';
            
  $(resultId).html(content);
}

function memberUpdate(servelet, formId) {

	//load的特效
	var options = {
		    bgColor         : '#000',
		    duration        : 800,
		    opacity    	    : 0.6,
		    classOveride    : false
	}
	new ajaxLoader(document.body, options);//load.js
	//-------------------------
	
	setTimeout(function(){		    
		$.ajax({url: servelet,dataType:'html',data: $(formId).serialize(),
			
			success:   function(result){  
	        	alert("編輯帳戶資料成功"); 
	        	location.reload();
	        },
	        error:   function(result){  
	        	alert("編輯帳戶資料 系統發生問題");       	
	        }
		});
	
	},1);
	
}

function passwordUpdate(servelet, formId) {
	    
	$.ajax({url: servelet,dataType:'json',data: $(formId).serialize(),
			
			success:   function(result){
				if(result=="Success"){
					alert("修改密碼成功");
					location.reload();
				}else{
					alert("修改密碼失敗");
				}
	        },
	        error:   function(result){  
	        	alert("修改密碼 系統發生問題");       	
	        }
	});
	

	
}