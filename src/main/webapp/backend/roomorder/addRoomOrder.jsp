<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%@ include file="/backend/htmlfile/css.html" %>

<style type="text/css">
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


	<h4>新增住宿訂單</h4>
	<%-- 錯誤表列 --%>
    <c:if test="${not empty errorMsgs}"> 
	<font style="color:red">請修正以下錯誤:</font>
 	<ul> 
		<c:forEach var="message" items="${errorMsgs}"> 
 			<li style="color:red">${message.value}</li> 
 		</c:forEach> 
 	</ul> 
    </c:if> 

    <form action="${pageContext.request.contextPath}/roomorder/roomorder.do" method="post">
		<p><label>會員電話：</label></p> 	
		<input type="text" name="memberphone"><br>
		<!--  <p><label>員工職位：</label></p>
		<select name="job">
			<option value="">選取職位</option>
			<option value="PRESIDENT">PRESIDENT</option>
			<option value="MANAGER">MANAGER</option>
			<option value="SALESMAN">SALESMAN</option>
			<option value="CLERK">CLERK</option>
			<option value="ANALYST">ANALYST</option>
		</select>-->
		
		
		
		<p><label>預定checkin日期：</label></p>
		<input type="date" name="checkindate"><br>
		<p><label>預定checkout日期：</label></p>
		<input type="date" name="checkoutdate"><br>
		<p><label>房型選擇1</label></p>
        <input type="text" name="roomtypeid1">
		<p><label>間數</label></p>
        <input type="text" name="roomamount1"><br>
<!-- 		<p><label>房型選擇2</label></p> -->
<!--         <input type="text" name="roomtypeid2"> -->
<!-- 		<p><label>間數</label></p> -->
<!--         <input type="text" name="roomamount2"><br> -->
<!--         <p><label>房型選擇3</label></p> -->
<!--         <input type="text" name="roomtypeid3"> -->
<!-- 		<p><label>間數</label></p> -->
<!--         <input type="text" name="roomamount3"><br> -->
		<p><label>特殊需求</label></p>
        <textarea name="specialreq" rows="10" cols="50">
			請輸入訂單特殊需求
		</textarea>
		
		<p><input type="submit" value="送出"></p>
		<input type="hidden" name="action" value="addOne">
	</form>

	<a href="${pageContext.request.contextPath}/backend/roomorder/roomorderselect.jsp">回首頁</a>


</div>
    </div>
    </div>

<%@ include file="/backend/htmlfile/content2.html" %>
<%@ include file="/backend/htmlfile/script.html" %>


</body>
</html>