<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<%@ include file="/backend/htmlfile/css.html" %>

<style type="text/css">
body {
	padding-left: 20px;
}
table, th, td {
  border:1px solid black;
}
th, td {
	height: 50px;
	width: 100px;
}

input[type="submit"] {
    margin-top: 5px; /* 添加输入框和按钮之间的间距 */
    padding: 5px; /* 添加输入框和按钮的内边距 */
}

input[type="submit"] {
    background-color: #007bff; /* 按钮背景颜色 */
    color: #ffffff; /* 按钮文字颜色 */
    border: none; /* 移除按钮边框 */
    cursor: pointer; /* 鼠标悬停时显示手型 */
}

input[type="submit"]:hover {
    background-color: #0056b3; /* 鼠标悬停时按钮背景颜色 */
}

</style>



<title>Demo</title>
</head>

<body>
	<%@ include file="/backend/htmlfile/content1.html" %>
	
	<div class="container-fluid pt-4 px-4">
    <div class="bg-light rounded ">
    <div class="G3_content">
	
	
	<h2>住宿訂單系統</h2>
	<div>
	<a href="${pageContext.request.contextPath}/roomorder/roomorder.do?action=getAll">查詢所有訂單</a>
	<br>
	<a href="${pageContext.request.contextPath}/backend/roomorder/addRoomOrder.jsp">新增一筆訂單</a>
	<br><br>
	</div>
	<h3><b>複合查詢 (使用 Criteria Query)：</b></h3>
	<form action="${pageContext.request.contextPath}/roomorder/roomorder.do" method="post">
		<p><label>會員名字模糊查詢：</label></p> 	
		<input type="text" name="membername"><br>
		<!--  <p><label>員工職位：</label></p>
		<select name="job">
			<option value="">選取職位</option>
			<option value="PRESIDENT">PRESIDENT</option>
			<option value="MANAGER">MANAGER</option>
			<option value="SALESMAN">SALESMAN</option>
			<option value="CLERK">CLERK</option>
			<option value="ANALYST">ANALYST</option>
		</select>-->
		<p><label>會員id查詢：</label></p> 	
		<input type="text" name="memberid">
		<p><label>預定checkin日期間範圍</label></p>
		<input type="date" name="startcheckindate"> ～ <input type="date" name="endcheckindate"><br>
		<p><label>預定checkout日期間範圍</label></p>
		<input type="date" name="startcheckoutdate"> ～ <input type="date" name="endcheckoutdate"><br>
		<p><label>訂單成立期間範圍</label></p>
		<input type="date" name="startorderdate"> ～ <input type="date" name="endorderdate"><br>
		<p><input type="submit" value="送出"></p>
		<input type="hidden" name="action" value="compositeQuery">
	</form>
	
	</div>
    </div>
    </div>


<%@ include file="/backend/htmlfile/content2.html" %>
<%@ include file="/backend/htmlfile/script.html" %>


</body>
</html>