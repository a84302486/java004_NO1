

$(document).ready(function() {

    $('#login-form-link').click(function(e) {

		$("#login-form").delay(100).fadeIn(100);
 		$("#register-form").fadeOut(100);
		$('#register-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});
	$('#register-form-link').click(function(e) {

		$("#register-form").delay(100).fadeIn(100);
 		$("#login-form").fadeOut(100);
		$('#login-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});

	//Handles menu drop down
    $('.dropdown-menu').find('form').click(function (e) {
        e.stopPropagation();
    });
    
    //帳號檢查
    $('#usernameCheck').click(function(){
        var URLs = "usernameCheck.do";
        var context = null;
        var id = $('#Username123').val();
        if(!id){
        	//沒有輸入帳號馬上回傳錯誤訊息
        	context='<div class="alert alert-danger" role="alert">請先輸入帳號</div>';
        	$('#usernameCheckResult').html(context);
        
        	return;
        }
        var queryString = 'Username='+id;
        $.ajax({
            url: URLs,
            data: queryString,
            type:"POST",
            dataType:'text',

            success: function(msg){
            	
                if(msg.match('usable')){
                	
                	context='<div class="alert alert-success" role="alert">帳號可使用</div>';
                }else{
                
                	if(msg.match('exist')){
                		
                	context='<div class="alert alert-danger" role="alert">帳號已存在</div>';	
                	}else{
                	context='<div class="alert alert-danger" role="alert">請先輸入帳號</div>';	
                	}
                }
                $('#usernameCheckResult').html(context);
            },

             error:function(xhr, ajaxOptions, thrownError){ 
                alert('發生錯誤 '+xhr.status+' '+thrownError+',請洽詢工程師'); 
                
             }
        });
    });
    
    
    
});
