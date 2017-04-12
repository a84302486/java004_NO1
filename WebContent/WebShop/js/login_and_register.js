(function($) {
	$.extend(
		$.validator.messages,
			{
						required : "*必填欄位",
						remote : "Please fix this field.",
						email : "請輸入正確的email",
						url : "Please enter a valid URL.",
						date : "日期格式錯誤",
						dateISO : "Please enter a valid date (ISO).",
						number : "Please enter a valid number.",
						digits : "Please enter only digits.",
						equalTo : "密碼不相同",
						maxlength : $.validator.format("長度最多{0}個字元"),
						minlength : $.validator.format("長度最少{0}個字元"),
						rangelength : $.validator
								.format("Please enter a value between {0} and {1} characters long."),
						range : $.validator
								.format("Please enter a value between {0} and {1}."),
						max : $.validator
								.format("Please enter a value less than or equal to {0}."),
						min : $.validator
								.format("Please enter a value greater than or equal to {0}."),
						step : $.validator
								.format("Please enter a multiple of {0}.")
					});
}(jQuery));


$(document).ready(function() {
	
	$('#drag').drag();
	
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
	$('.dropdown-menu').find('form').click(function(e) {
		e.stopPropagation();
	});
	
	//地址自動完成
	setAddressInput($("#dvAddress"));
	
	var check ="usable";
	var Username = "";
	$.validator.addMethod("usernameCheck", function(value) {
		
		Username = value;
		$.ajax({
			url : "usernameCheck.do",
			cache: false,
			data : {member_Username:Username},//$(this).serialize()
			type : "POST",
			dataType : 'text',
			async: false,

			success : function(response){
		    		check = response;
					//alert(check);	
		    }		
		});
		
		if(check.match('usable')){
            return true;
        }else if(check.match('exist')){  
            return false;      
        }else{
        	alert("檢查帳號發生問題!");
        	return true;
        }
	}, "帳號已註冊");
	

	
	//email檢查
	$.validator.addMethod("emailCheck", function(value, element) {
		if (/^([a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4})*$/.test(value)) {
            return true;
        } else {
            return false;
        };
	}, "請輸入正確的email");
	
	//生日檢查
	$.validator.addMethod("dayCheck", function(value, element) {
		var dtToday = new Date();
		var mydate = new Date(value);
		var result;
		if (mydate <= dtToday) {
			result = true;
		} else { //日期必需要小於今天
			result = false;
		}
		return this.optional(element) || result;
	}, "生日輸入錯誤");
	
	
	//英文字母和數字組成
	$.validator.addMethod("atoz_number", function (value, element) {
        if (/^([a-zA-Z]+\d+|\d+[a-zA-Z]+)[a-zA-Z0-9]*$/.test(value)) {
            return true;
        } else {
            return false;
        };
    }, "英文字母和數字組成");
	
	//手機號碼檢查
	$.validator.addMethod("cellphonecheck", function (value, element) {
        if (/^09\d{2}-?\d{3}-?\d{3}$/.test(value)) {
            return true;
        } else {
            return false;
        };
    }, "手機號碼輸入錯誤");
	
	//註冊欄位檢查
	$("#register-form").validate({
		
		event: "change",
		showErrors: function(errorMap, errorList) {

	          // Clean up any tooltips for valid elements
	          $.each(this.validElements(), function (index, element) {

	              var $element = $(element);

	              $element.data("title", "") // Clear the title - there is no error associated anymore
	                  .removeClass("error")
	                  .text("")
	              	  .addClass("valid")
	              	  .tooltip("destroy");
//	              	  .append('<span class="glyphicon glyphicon-ok form-control-feedback"></span>');
	          });

	          // Create new tooltips for invalid elements
	          $.each(errorList, function (index, error) {

	              var $element = $(error.element);
	              $element.tooltip("destroy") // Destroy any pre-existing tooltip so we can repopulate with new tooltip content

	                  .data("title", error.message)
	                  .removeClass("valid")
	                  .addClass("error")
	                  .tooltip(); // Create a new tooltip based on the error messsage we just set in the title
	          });

	    },
		rules : {
			member_Username:{
				minlength : 4,
				maxlength : 20
			},
			Password:{
				minlength : 6,
				maxlength : 20
			},
			Password2:{
				minlength : 6,
				maxlength : 20,
				equalTo : "#PasswordID"
			},
			Name:{
				maxlength : 20
			}
		},//rules
		submitHandler : function(form) {
			
			//load的特效
			var options = {
				    bgColor         : '#000',
				    duration        : 800,
				    opacity    	    : 0.8,
				    classOveride    : false
			}
			new ajaxLoader(document.body, options);//load.js
			//-------------------------
			
			setTimeout(function(){		    
			$.ajax({url: '../_14_Member/Insert',dataType: 'json',data: $(form).serialize(),
		        success:   function(result){
		        
//		        	location.href ='../WebShop/registerSuccess.jsp';
//		        	$.ajax({url: '../_14_Member/JavaMail',data:{'Username':Username}});
//		        	alert('感謝您加入會員，請到您的信箱收取認證信');
		        	location.href ='../_14_Member/JavaMail?Username='+Username;
		        	    //寄出認證信
		        }
			});
			
			},1);

		}
	});

});






