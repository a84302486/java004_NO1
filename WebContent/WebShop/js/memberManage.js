$(document).ready(function(){

	//自動搜尋
	orderSelect('../_21_ShoppingOrder/SelectOrder','#orderResult','#memberVal');
	
	$('#orderResult').on('click', '.btn-danger', function() {
		
		var orderId = $(this).attr("id");
		
		if(confirm('您確定要取消訂單編號'+orderId+'的訂單?')){
			location.href ='../_21_ShoppingOrder/DeleteOrder?OrderId='+orderId;
		}else{
			return;
		}
	});
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