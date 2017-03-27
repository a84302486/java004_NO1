$(document).ready(function(){

	//自動搜尋
	buttonSelect('../_14_Member/Select','#memberResult','#memberSelect');
	//自動搜尋
	buttonSelect('../_21_ShoppingOrder/Select','#orderResult','#orderSelect');
});

//查詢提交 function
function buttonSelect(servelet, resultId, formId) {
	$.ajax({url: servelet,dataType: 'json',resetForm: true,data: $(formId).serialize(),
        success:   function(result){
  
        	selectResponse(result, resultId);       	
        }
	});
}

//查詢成功回傳
function selectResponse(result, resultId) {

	var content="";

	content += "<form id='queryData'>";
	content += "<table>";
	
	//每一筆資料
	$.each(result, function(key, value){
		
		//欄位名稱
		if(key==0){
			content += "<tr><td>#</td>";
			
			$.each(value, function(key, value){
		    	content += "<td>"+key+"</td>";
		    });
			content += "</tr>";
		}
		
		//每一筆資料
		content += "<tr>";
		content += "<td><input type='radio'></td>";
		
	    $.each(value, function(key, value){
	    		content += "<td>"+value+"</td>";    	
	    });
	    content += "</tr>";
	});
	content += "</table>";
	content += "</form>";
	
	$(resultId).html(content);
	//$('#resultIndex')
	
}