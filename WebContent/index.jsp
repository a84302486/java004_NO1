<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/bootstrap-theme.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/test.css">
<title>work</title>
</head>
<body>
	<header class="container-fuild">
		<h4 class="text-center">
			<strong>Window</strong>
		</h4>
	</header>
	<section class="container-fuild" id="about">
		<div class="row">

			<select class="col-md-3">
				<option value="no1">主選單</option>
			</select> <input type="text" name="TextBox1" value="TextBox1" class="col-md-6">
			<input type="datetime-loca" name="time" value="time" class="col-md-3">
		</div>
	</section>

	<section class="container-fuild" id="services">Tab</section>

	<section class="container-fuild" id="portfolio">
		<!-- <button><strong>ESC<br>結束</strong> </button>
	<button><strong>F1<br>說明</strong></button>
	<button><strong>F2<br>新增</strong></button>
	<button><strong>F3<br>修改</strong></button>
	<button><strong>F4<br>刪除</strong></button>
	<button><strong>F5<br>列印</strong></button> -->
		<nav class="container-fuild">
			<div class="container-fluid">
				<ul class="nav navbar-nav">
					<button>
						<strong>ESC<br>結束
						</strong>
					</button>
					<button>
						<strong>F1<br>說明
						</strong>
					</button>
					<button>
						<strong>F2<br>新增
						</strong>
					</button>
					<button>
						<strong>F3<br>修改
						</strong>
					</button>
					<button>
						<strong>F4<br>刪除
						</strong>
					</button>
					<button>
						<strong>F5<br>列印
						</strong>
					</button>
					<button>
						<strong>PgDn<br>查詢
						</strong>
					</button>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<button>
						<strong><midde>首頁</midde></strong>
					</button>
					<button>
						<strong>上頁</strong>
					</button>
					<button>
						<strong>下頁</strong>
					</button>
					<button>
						<strong>尾頁</strong>
					</button>
				</ul>
			</div>
		</nav>
	</section>
	<section class="container-fuild" id="price">price
		<c:set var="funcName" value="IND" scope="session"/>
	
	</section>
		
	<section class="container-fuild" id="connect">contact
		<c:set var="funcName" value="IND" scope="session"/>
		
	</section>

	<footer class="container-fuild">footer</footer>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>