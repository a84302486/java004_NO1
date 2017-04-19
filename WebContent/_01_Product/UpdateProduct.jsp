<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<%-- <link rel='stylesheet' href='${pageContext.request.contextPath}/css/product_main2.css' type="text/css" /> --%>
<%-- <script src="${pageContext.request.contextPath}/js/product_new2.js" type="text/JavaScript"></script> --%>

<Form Action="Javascript:%200">
	<div class="row" id="updateTable">
		<div class="col-md-2">
			<label >產品序號</label>
			<div>
				<input type="text" name="productId" value="" readonly>
			</div>
		</div>
		<div class="col-md-2">
			<label>產品定價</label>
			<div>
				<input type="text" name="PGPrice" value="">
			</div>
		</div>
		<div class="col-md-2">
			<label>產品品名</label>
			<div>
				<input type="text" name="name" value="">
			</div>
		</div>
		<div class="col-md-2">
			<label>產品成本</label>
			<div>
				<input type="text" name="avgCost" value="">
			</div>
		</div>
		<div class="col-md-2">
			<label>產品生產地</label>
			<div>
				 <input type="text" name="oPlace" value="">
			</div>
		</div>
		<div class="col-md-2">
			<label>產品保存期</label>
			<div>
				 <input type="text" name="sLife" value="">
			</div>
		</div>
		<div class="col-md-2">
			<label>產品供應商</label>
			<div>
				<input type="text" name="suppierId" value="">
			</div>
		</div>
	</div>




	<br>
	<div class="row">
		<div class="col-md-2">
			<div>
				<button onclick="getData();">選取該筆資料</button>
				<input type="submit" value="提交" onclick="getUpdateData('UpdateProduct.do');"/>
				<div id="updateResult"></div>
			</div>
		</div>
	</div>	
</Form>	