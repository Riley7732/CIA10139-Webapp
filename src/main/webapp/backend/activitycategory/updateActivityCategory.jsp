<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.test.activitycategory.entity.*"%>
<%@ page import="com.test.activitycategory.dao.*"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>活動類別管理系統</title>
	
	<%@ include file="/backend/htmlfile/css.html" %>
	
	<style>
		body {
            background-color: #f4f4f4;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        
        h2 {
            /* text-align: center; */
            color: #333;
            margin-top: 20px;
        }
        
        #activity {
            max-width: auto;
            margin: 20px auto;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            overflow-x: auto;
        }
        
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 0 auto; /* 將表格置中 */
        }
        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: center;
        }
        th {
            background-color: #9cb6d2;
            font-weight: bold;
            white-space: nowrap;
            font-size: 16px;
        }
        tr {
            background-color: #f9f9f9;
            font-size: 14px;
        }
        /* 滑鼠指向某一行時，這行的背景顏色會改變。 */
        tr:hover {
            background-color: #f2f2f2;
        }
        
        #update_btn, #cancel_btn{
            padding: 5px 10px;
            background-color: #9cb6d2;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            white-space: nowrap;  /* 讓文字不換行 */
            margin-top: 10px;	/* 設定向下的上邊距 */
            text-decoration: none; /* 取消連結的下劃線 */
        }
        #button-container, #cancel_btn {
        	display: inline-block;
		}
		#update_btn:hover, #cancel_btn:hover {
		    background-color: #0056b3; /* 鼠标悬停时按钮背景颜色 */
		}
		#set {
			text-align: right; /* 讓內容向右對齊 */
		    margin-top: 10px;  /* 這是為了確保與表格之間有一些間距 */
		}
        
	</style>
	
</head>
<body>
	
	<%@ include file="/backend/htmlfile/content1.html" %>
	
	<div class="container-fluid pt-4 px-4">
    <div class="bg-light rounded ">
    <div class="G3_content">
    
    	<h2>活動類別管理系統 — 修改</h2>
    	
    	<%
    	ActivityCategoryEntity activityCategory = (ActivityCategoryEntity) request.getAttribute("activityCategoryEntity"); 
    	%>
    	
    	<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/activitycategory/activitycategory.do">
    	<div id="activity">
    		
    		<%-- 錯誤表列 --%>
		    <c:if test="${not empty errorMsgs}"> 
			<font style="color:red">請修正以下錯誤:</font>
		 	<ul> 
				<c:forEach var="message" items="${errorMsgs}"> 
		 			<li style="color:red">${message.value}</li> 
		 		</c:forEach> 
		 	</ul> 
		    </c:if> 
		    
	    	<table>
	    		<tr>
					<td>活動類別編號：</td>
					<td><%=activityCategory.getActivityCategoryID() %></td>
				</tr>
				<tr>
					<td>活動類別名稱：</td>
					<td><input type="text" name="activityCategoryName" value="<%=activityCategory.getActivityCategoryName() %>"/></td>
				</tr>
				<tr>
					<td>活動類別說明：</td>
					<td><textarea name="activityCategoryInfo"><%=activityCategory.getActivityCategoryInfo() %></textarea></td>
					<%-- <td><input type="text" name="activityCategoryInfo" value="<%=activityCategory.getActivityCategoryInfo() %>"/></td> --%>
				</tr>
			</table>
			
			<div id="set">
				<div id="button-container">
					<input type="submit" value="修改" id="update_btn">
					<input type="hidden" name="activityCategoryID"  value="<%=activityCategory.getActivityCategoryID() %>">
					<input type="hidden" name="action"	value="update">
					
				</div>
				<a href="<%=request.getContextPath()%>/backend/activitycategory/index.jsp" id="cancel_btn">取消</a>
			</div>
    	</div>
    	</FORM>
    
    </div>
    </div>
    </div>

	<%@ include file="/backend/htmlfile/content2.html" %>
	<%@ include file="/backend/htmlfile/script.html" %>

</body>
</html>