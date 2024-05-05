<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/backend/htmlfile/css.html" %>

<style type="text/css">
h1 {
    margin-top: 0; /* 移除标题顶部间距 */
    margin-bottom: 20px; /* 添加标题底部间距 */
}

table {
    width: 100%; /* 表格宽度填满父容器 */
    text-align: center; /* 居中对齐表格内容 */
    margin-top: 20px; /* 表格顶部间距 */
    border-collapse: collapse; /* 合并表格边框 */
}

th, td {
    padding: 10px; /* 单元格内边距 */
    border: 1px solid #dddddd; /* 单元格边框 */
}

th {
    background-color: #0056b3; /* 表头背景颜色 */
    color: white; /* 表头文字颜色 */
}

th:nth-child(1), td:nth-child(1) {
    width: 10%; /* 调整订单编号列宽度 */
}

th:nth-child(2), td:nth-child(2) {
    width: 15%; /* 调整会员姓名列宽度 */
}

th:nth-child(3), td:nth-child(3) {
    width: 20%; /* 调整订单成立日期时间列宽度 */
}

th:nth-child(4), td:nth-child(4) {
    width: 10%; /* 调整付款金额列宽度 */
}

th:nth-child(5), td:nth-child(5) {
    width: 15%; /* 调整check in 日期列宽度 */
}

th:nth-child(6), td:nth-child(6) {
    width: 15%; /* 调整check out 日期列宽度 */
}

th:nth-child(7), td:nth-child(7) {
    width: 5%; /* 调整订单状态列宽度 */
}

th:nth-child(8), td:nth-child(8) {
    width: 5%; /* 调整退款状态列宽度 */
}

th {
    background-color: #004080; /* 深蓝色表头背景 */
    color: white; /* 表头文字颜色 */
}

tr:nth-child(even) {
    background-color: #f2f2f2; /* 偶数行背景颜色 */
}

a {
    text-decoration: none; /* 移除链接下划线 */
    color: #007bff; /* 链接颜色 */
}

a:hover {
    text-decoration: underline; /* 鼠标悬停时添加下划线 */
}

input[type="submit"] {
    background-color: #007bff; /* 浅蓝色按钮背景颜色 */
    color: #ffffff; /* 按钮文字颜色 */
    border: none; /* 移除按钮边框 */
    border-radius: 5px; /* 圆角按钮 */
    padding: 8px 16px; /* 按钮内边距 */
    cursor: pointer; /* 鼠标悬停时显示手型 */
}

input[type="submit"]:hover {
    background-color: #4d94ff; /* 鼠标悬停时按钮背景颜色 */
}

</style>



<title>List RoomOrders</title>
</head>
<body>

<%@ include file="/backend/htmlfile/content1.html" %>
	
	<div class="container-fluid pt-4 px-4">
    <div class="bg-light rounded ">
    <div class="G3_content">
    


	<h1>住宿訂單列表</h1>
	<c:if test="${PageQty > 0}">
  		<b><font color=red>第${currentPage}/${PageQty}頁</font></b>
	</c:if>
	
	<table>
		<tr>
			<th>住宿訂單編號</th>
			<th>會員姓名</th> 
			<th>訂單成立日期時間</th>
			<th>付款金額</th>
			<th>check in 日期</th>
			<th>check out 日期</th>
			<th>訂單狀態</th>
			<th>退款狀態</th>
			<th>訂單狀態更新</th>
		</tr>
		
		<c:forEach var="roomOrder" items="${roomOrderList}">
			<tr>
				<td>${roomOrder.roomOrderId}</td>
				<td>${roomOrder.member.memberName}</td> 
				<td>${roomOrder.orderDate}</td>		
			<c:forEach var="roomOrderItem" items="${roomOrder.roomOrderItems}">
			<c:set var="priceTotal" value="${priceTotal+roomOrderItem.roomPrice}"/>
			</c:forEach>
				<td>${priceTotal}</td>
			<c:remove var="priceTotal"/>     
				<td>${roomOrder.checkInDate}</td>
				<td>${roomOrder.checkOutDate}</td>
				<td>
					<c:choose>
			                <c:when test="${roomOrder.roomOrderState == '0'}">已取消</c:when>
			                <c:when test="${roomOrder.roomOrderState == '1'}">成立</c:when>
			                <c:when test="${roomOrder.roomOrderState == '2'}">完成</c:when>
			                <c:when test="${roomOrder.roomOrderState == '3'}">取消中</c:when>
			        </c:choose>
				
				
				
				</td>
				<td>
				    <c:choose>
			                <c:when test="${roomOrder.refundState == '0'}">無退款</c:when>
			                <c:when test="${roomOrder.refundState == '1'}">退款中</c:when>
			                <c:when test="${roomOrder.refundState == '2'}">退款完成</c:when>
			        </c:choose>
				
				
				
				</td>
				<td>
				<c:choose>
			        <c:when test="${roomOrder.roomOrderState == '0'||roomOrder.roomOrderState == '2'}"> </c:when>
			        
			        <c:when test="${roomOrder.roomOrderState == '1'}">
				
				  		<FORM METHOD="post" ACTION="${pageContext.request.contextPath}/roomorder/roomorder.do" style="margin-bottom: 0px;">
				     	<input class="room_order_cancel" type="submit" value="取消" data-check-in-date="${roomOrder.checkInDate}">
				     	<input type="hidden" name="roomOrderId"  value="${roomOrder.roomOrderId}">
				     	<input type="hidden" name="action"	value="getOneToCancel"></FORM>
				     	
				     	<FORM METHOD="post" ACTION="${pageContext.request.contextPath}/roomorder/roomorder.do" style="margin-bottom: 0px;">
				     	<input type="submit" value="完成">
				     	<input type="hidden" name="roomOrderId"  value="${roomOrder.roomOrderId}">
				     	<input type="hidden" name="action"	value="getOneToComplete"></FORM>
				     	
			     	</c:when>
			     	
			     	<c:when test="${roomOrder.roomOrderState == '3'}">
			     		
			     		<FORM METHOD="post" ACTION="${pageContext.request.contextPath}/roomorder/roomorder.do" style="margin-bottom: 0px;">
				     	<input type="submit" value="退款完成">
				     	<input type="hidden" name="roomOrderId"  value="${roomOrder.roomOrderId}">
				     	<input type="hidden" name="action"	value="getOneToRefund"></FORM>
			     	</c:when>
			     	
			    </c:choose>
			    	
				</td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${currentPage > 1}">
		<a href="${pageContext.request.contextPath}/roomorder/roomorder.do?action=getAll&page=1">至第一頁</a>&nbsp;
	</c:if>
	<c:if test="${currentPage - 1 != 0}">
		<a href="${pageContext.request.contextPath}/roomorder/roomorder.do?action=getAll&page=${currentPage - 1}">上一頁</a>&nbsp;
	</c:if>
	<c:if test="${currentPage + 1 <= PageQty}">
		<a href="${pageContext.request.contextPath}/roomorder/roomorder.do?action=getAll&page=${currentPage + 1}">下一頁</a>&nbsp;
	</c:if>
	<c:if test="${currentPage != PageQty}">
		<a href="${pageContext.request.contextPath}/roomorder/roomorder.do?action=getAll&page=${PageQty}">至最後一頁</a>&nbsp;
	</c:if>
	<br>
	
	
	<a href="${pageContext.request.contextPath}/backend/roomorder/roomorderselect.jsp">回首頁</a>	


    </div>
    </div>
    </div>

<%@ include file="/backend/htmlfile/content2.html" %>
<%@ include file="/backend/htmlfile/script.html" %>


	<script type="text/javascript">
	var buttons = document.getElementsByClassName("room_order_cancel");
	for (var i = 0; i < buttons.length; i++) {
	    buttons[i].addEventListener("click", function(){
	        var roomOrderCheckInDate = this.getAttribute("data-check-in-date"); 
	        var today = new Date();
            var checkInDate = new Date(roomOrderCheckInDate); // 使用 JavaScript 变量的值
            var differenceInTime = checkInDate.getTime() - today.getTime();
            var differenceInDays = differenceInTime / (1000 * 3600 * 24);

            if (differenceInDays <= 3) {
                alert("距離入住日期不足三天，無法退款。");
            } else{
            	alert("請進行退款作業。");
            }
	        
	        
	        
	    });
	}
	
	</script>


</body>
</html>