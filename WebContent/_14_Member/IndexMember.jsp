<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<div>
	<table id="navBar">
		<tr class="abgne_tab" style="width:50em;">
			<td>
				<ul class="tabs">
					<li><a href="#member1">會員資料管理</a></li>
				</ul>
			</td>

			<td id="toolBar" style="width:30em;">
<!-- 				<div class="col-md-4 col-md-1-offset"> -->
				
				<button class="insert" id='buttoninsert'></button>
				<button class="delete" id='buttondelete'></button>
				<button class="update" id='buttonupdate'></button>
<!-- 				</div>	 -->

				<Form id="formSelect">

					<input type="text" name="Username" id="M_Username" value=""
						size="20" placeholder="輸入帳號查詢" />
		
					<input type="hidden" name="pageNo" id="pageNo" value="1" />


					<button type="submit" id="buttonsearch"><img src="../image/search.png"></button>
			

				</Form>
<!-- 				</div> -->

			<td>
		</tr>
	</table>
	<div class="tab_container">
		<div id="member1" class="tab_content">
			<section class="container-fuild" id='showDAOJsp'>
				<h4>請選擇功能</h4>
			</section>
			<section class="container-fuild" id='showResult'>
			</section>
		</div>

	</div>
</div>
