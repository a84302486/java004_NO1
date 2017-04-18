<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- <html> -->
<!-- <head> -->
<!-- <link rel='stylesheet' -->
<!-- 	href='${pageContext.request.contextPath}/css/product_main2.css' -->
<!-- 	type="text/css" /> -->

<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<!-- <title>MVC</title> -->
<!-- </head> -->
<!-- <body> -->


<Form name="form1" id="form1" action="InsertProduct2.do" method="post" enctype="multipart/form-data">
	<div class="row">
		<div class="col-md-2">
			<label >產品序號</label>
			<div>
				<input type="text" name="productId" value="000">
			</div>
		</div>
		<div class="col-md-2">
			<label>產品定價</label>
			<div>
				<input type="text" name="PGPrice" value="80">
			</div>
		</div>
		<div class="col-md-2">
			<label>產品品名</label>
			<div>
				<input type="text" name="name" value="炸豬排">
			</div>
		</div>
		<div class="col-md-2">
			<label>產品成本</label>
			<div>
				<input type="text" name="avgCost" value="50">
			</div>
		</div>
		<div class="col-md-2">
			<label>產品生產地</label>
			<div>
				 <input type="text" name="oPlace" value="台灣屏東">
			</div>
		</div>
		<div class="col-md-2">
			<label>產品保存期</label>
			<div>
				 <input type="text" name="sLife" value="360">
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-2">
			<label >產品供應商</label>
			<div>
				<input type="text" name="suppierId" value="A">
			</div>
		</div>
		<div class="col-md-2">
			<label>產品圖片</label>
			<div>
				<input type="file" name="fileName" id=ProductPic size="40" required>
			</div>
		</div>
		
	</div>
	<br>
	<div class="row">
		<div class="col-md-2">
			<div>
				<input type="submit" name="upload" id="upLoadPic" value="提交">
			</div>
		</div>
	</div>
	
</Form>
<div>
		<div id="insertResult"></div>
	</div>

<!-- </body> -->
<!-- </html> -->
