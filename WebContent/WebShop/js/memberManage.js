$(document).ready(function(){

	//自動搜尋
	orderSelect('../_21_ShoppingOrder/SelectOrder','#orderResult','#memberVal');
});




function orderSelect(servelet, resultId, inputId) {
	var queryString = "Username="+$(inputId).val();
	$.ajax({url: servelet,dataType: 'json',resetForm: true,data: queryString,
        success:   function(result){
  
        	orderResult(result, resultId);       	
        }
	});
}

function orderResult(result, resultId, inputId){
	
var content =""	
		   +'<section class="order-content">'
		   +'<div class="tab-content">'
		   +'<h3 class="side-heading">'
		   +'<span class="text">訂單歷史紀錄</span>'
		   +'</h3>'
  
		   +'<div id="order">'
		   +'<div>'
		   +'<table class="table table-order" id="order-record">'
		   +'<tr style="text-align:center">'
           +'<th>訂單編號</th>'
           +'<th>訂購時間</th>'
           +'<th>出貨時間</th>'
           +'<th>總金額</th>'
           +'</tr>';

           $.each(result, function(key, value){
        	   
        	   content +='<tr>';
        	   $.each(value, function(key, value){
        		
        		if(key=='OrderId'){
        			content += "<td><a href=../_21_ShoppingOrder/orderDetail?Username="+$(inputId).val()+"&OrderId="+value+">"+value+"</a></td>";
        			
        		}else{
        			content += "<td>"+value+"</td>";
        		}
        		
	   			});
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