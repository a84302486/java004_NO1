
$(function(){
	$('ul.drop-down-menu ul li').click(function(){
		var $tab = $(this);
		var _getHerf = $($tab).find('a').attr('class');
		alert(_getHerf);
		$('ul.tabs li:last').after("<li><a href=#tab4>會員資料表 <i><img id=cross></i></a></li>");
		$('div.abgne_tab div:last').after("<div id=tab4 class=tab_content><h2>123456789<h2></div>");
		$('#tab4').load(_getHerf);
		
//		var txt1="<b>I </b>";                    // 以 HTML 创建元素
//		var txt2=$("<i></i>").text("love ");     // 通过 jQuery 创建元素
//		var txt3=document.createElement("big");  // 通过 DOM 创建元素
//		txt3.innerHTML="jQuery!";
//		$("img").after(txt1,txt2,txt3);          // 在 img 之后插入新元素
		
		});
	});	

//------------------------------------------------------
$(function(){
	// 預設顯示第一個 Tab
	var _showTab = 0;
	$('.abgne_tab').each(function(){
		// 目前的頁籤區塊
		var $tab = $(this);
 
		var $defaultLi = $('ul.tabs li', $tab).eq(_showTab).addClass('active');
		$($defaultLi.find('a').attr('href')).siblings().hide();
 
		// 當 li 頁籤被點擊時...
		// 若要改成滑鼠移到 li 頁籤就切換時, 把 click 改成 mouseover
		$('ul.tabs li', $tab).click(function() {
			// 找出 li 中的超連結 href(#id)
			var $this = $(this),_clickTab = $this.find('a').attr('href');
			// 把目前點擊到的 li 頁籤加上 .active, 並把兄弟元素中有 .active 的都移除 class
			$this.addClass('active').siblings('.active').removeClass('active');
			// 淡入相對應的內容並隱藏兄弟元素
			$(_clickTab).stop(false, true).fadeIn().siblings().hide();
 
			return false;
		}).find('a').focus(function(){
			this.blur();
		});
	});
});

//刪除Tab並跳回第一頁------------------------------------------------------
$(function(){
	//點擊X觸發事件
	$('ul.tabs li a i').click(function(){
		//找出對應的div#id並刪除
		var _getHerf = $(this).parent().attr('href');
		//找出被點擊X所對應的li並刪除
		$(this).parent().parent().remove();
		$(_getHerf).contents().remove();
		//此語法會找出第一個a連結內的herf
		var _getfFstHerf = $('a').attr('href'); 
		//顯示找到的herf(此連結是連到div#id),顯示此id對應的div並隱藏其他div
		$(_getfFstHerf).stop(false, true).fadeIn().siblings().hide();
		//將預設顯示的li設為index=0(第一個li)顯示
		$('.abgne_tab').each(function(){
		var $tab = $(this),$defaultLi = $('ul.tabs li', $tab).eq(0).addClass('active');
		$($defaultLi.find('a').attr('href')).siblings().hide();
		});
    });
});

