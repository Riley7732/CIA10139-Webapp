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


	<h2>修改住宿訂單</h2>
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
		
	<table>
		<tr>
			<td>訂單編號:<font color=red><b>*</b></font></td>
			<td>${roomOrder.roomOrderId}</td>
		</tr>
		<tr>
			<td>會員編號:</td><td>${roomOrder.member.memberId}</td>
		</tr>
		<tr>
			<td>會員姓名:</td><td>${roomOrder.member.memberName}</td>
		</tr>
		<tr>
			<td>會員電話:</td><td>${roomOrder.member.memberPhone}</td>
		</tr>
		<tr>
			<td>訂單成立時間:</td><td>${roomOrder.orderDate}</td>
		</tr>
		<tr>
			<td>預定checkin日期:</td><td>${roomOrder.checkInDate}</td>
		</tr>
		<tr>
			<td>預定checkout日期:</td><td>${roomOrder.checkOutDate}</td>
		</tr>
		<tr>
			<td>預定房型內容:</td><td>${roomOrder.member.memberId}</td>
		</tr>
		<tr>
			<td>訂單狀態:</td>
			<td><input type="TEXT" name="roomorderstate" value="${roomOrder.roomOrderState}" size="45"/></td>
		</tr>
		<tr>
			<td>退款狀態:</td>
			<td><input type="TEXT" name="refundstate" value="${roomOrder.refundState}" size="45"/></td>
		</tr>
	</table>	
		
	
		<p><label>特殊需求</label></p>
        
			<c:forEach var="roomOrderItem" items="${roomOrder.roomOrderItems}" varStatus="varIndex">
			<c:if test="${varIndex.index == 0}">
			   <c:set var="specialreq" value="${roomOrderItem.specialREQ}"/>
			</c:if>
			</c:forEach>
		<textarea name="specialreq" rows="10" cols="50">
			${specialreq}
		</textarea>
		
		<p><input type="submit" value="送出"></p>
		<input type="hidden" name="roomOrderId"  value="${roomOrder.roomOrderId}">
		<input type="hidden" name="action" value="updateOne">
	</form>

	<a href="${pageContext.request.contextPath}/backend/roomorder/roomorderselect.jsp">回首頁</a>


</div>
    </div>
    </div>

<%@ include file="/backend/htmlfile/content2.html" %>
<%@ include file="/backend/htmlfile/script.html" %>


</body>
</html>