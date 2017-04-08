
$(function() {
$('.star-rating-product').starRating({
		totalStars : 5,
		starSize : 20,
		emptyColor : 'lightgray',
		hoverColor : 'salmon',
		useGradient : false,
		readOnly : false,
		callback : function(score ,$el) {
			alert('rated= ' + score);
			var productId = $($el).attr('id');
			var orderId = $('.text a').text().replace('訂單編號：','');
			alert(productId);
			alert(orderId);

			$.ajax({
				url : '../_21_ShoppingOrder/getScoreServlet.do',
				type : 'POST',
				data : "score="+score+"&orderId="+orderId+"&productId="+productId,
				success:function(data){
					 $($el).parent().find('b').text("已評分");
				 }
			});

		}
	});

$('.star-rated-product').starRating({
		totalStars : 5,
		starSize : 20,
		useGradient : false,
		readOnly : true,
	});
});

