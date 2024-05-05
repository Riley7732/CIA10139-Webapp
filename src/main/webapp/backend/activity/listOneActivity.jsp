<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.test.activity.dao.*"%>
<%@ page import="com.test.activity.entity.*"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>活動管理系統</title>
	
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
        
        #query {
            max-width: auto;
            margin: 20px auto;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 10px;
            overflow-x: auto;
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
        
        #update_btn, #query_btn {
            padding: 5px 10px;
            background-color: #9cb6d2;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            white-space: nowrap;  /* 讓文字不換行 */
        }
        #update_btn:hover, #query_btn:hover {
		    background-color: #0056b3; /* 鼠标悬停时按钮背景颜色 */
		}
	</style>
</head>
<body>
	
	<%@ include file="/backend/htmlfile/content1.html" %>
	
	<div class="container-fluid pt-4 px-4">
    <div class="bg-light rounded ">
    <div class="G3_content">
    
    	<h2>活動類別管理系統</h2>
    	
    	<div id="query">
		
			<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/activity/activity.do" >
				<label>選擇活動：</label>
				<select name="activityID">
					<%
					ActivityDAOImpl dao = new ActivityDAOImpl();
					List<ActivityEntity> list = dao.getAll();
					int activityID = 1;
					for(ActivityEntity activity : list) {
					%>
					<option value="<%=activityID %>"><%=activity.getActivityName() %>
					<%
					activityID ++;
					} 
					%>
				</select>
				<input type="hidden" name="action" value="getOne">
				<input type="submit" value="查詢" id="query_btn">
			</FORM>
			
		</div>
    	
		<div id="activity">
			<table>
				<tr>
	                <th>活動編號</th>
	                <th>活動類別</th>
	                <th>活動名稱</th>
	                <th>活動價格</th>
	                <th>活動資訊</th>
	                <th>活動注意事項</th>
	                <th>活動狀態</th>
	                <th>修改資訊</th>
				</tr>
				
				<%
				ActivityEntity activity = (ActivityEntity) request.getAttribute("activityEntity");
				%>
				
				<tr>
					<td><%=activity.getActivityID() %></td>
					<td><%=activity.getActivityCategoryID().getActivityCategoryName() %></td>
					<td><%=activity.getActivityName() %></td>
					<td><%=activity.getActivityPrice() %></td>
					<td><%=activity.getActivityInfo() %></td>
					<td><%=activity.getActivityNotice() %></td>
					<td><%=activity.getActivityStatus() ? "上架" : "下架" %></td>
					<td>
						<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/activity/activity.do">
						<input type="submit" value="修改" id="update_btn">
						<input type="hidden" name="activityID"  value="<%=activity.getActivityID() %>">
						<input type="hidden" name="action"	value="updatePage">
						</FORM>
					</td>
				</tr>
				
			</table>
		</div>
		<a href="<%=request.getContextPath()%>/backend/activity/index.jsp" id="back">回首頁</a>
    
    </div>
    </div>
    </div>

	<%@ include file="/backend/htmlfile/content2.html" %>
	<%@ include file="/backend/htmlfile/script.html" %>

</body>
</html>