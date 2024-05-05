package com.test.activity.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.activity.entity.ActivityEntity;
import com.test.activity.service.ActivityService;
import com.test.activity.service.ActivityServiceImpl;
import com.test.activitycategory.entity.ActivityCategoryEntity;
import com.test.activitycategory.service.ActivityCategoryService;
import com.test.activitycategory.service.ActivityCategoryServiceImpl;

@WebServlet("/activity/activity.do")
public class ActivityServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ActivityService activityService;

	@Override
	public void init() throws ServletException {
		activityService = new ActivityServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		String forwardPath = "";

		if (action != null) {

			switch (action) {
			case "getOne":
				forwardPath = getOne(req, res);
				break;
			case "updatePage":
				forwardPath = updatePage(req, res);
				break;
			case "update":
				forwardPath = update(req, res);
				break;
			case "add":
				forwardPath = add(req, res);
				break;
			case "compositeQuery":
				forwardPath = getCompositeQuery(req, res);
				break;
			default:
				forwardPath = "/index.jsp";
			}
		} else {
			forwardPath = "/index.jsp";
		}

		res.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPath);
		dispatcher.forward(req, res);
	}

	private String getOne(HttpServletRequest req, HttpServletResponse res) {

		/******************** 1.接收請求參數 ********************/
		Integer activityID = Integer.valueOf(req.getParameter("activityID"));

		/******************** 2.開始查詢資料 ********************/
		ActivityService activityService = new ActivityServiceImpl();
		ActivityEntity activity = activityService.getActivityByID(activityID);

		/******************** 3.查詢完成，準備轉交(Send the Success view) ********************/
		req.setAttribute("activityEntity", activity);
		return "/backend/activity/listOneActivity.jsp";
	}
	
	private String updatePage(HttpServletRequest req, HttpServletResponse res) {

		/******************** 1.接收請求參數 ********************/
		Integer activityID = Integer.valueOf(req.getParameter("activityID"));

		/******************** 2.開始查詢資料 ********************/
		ActivityService activityService = new ActivityServiceImpl();
		ActivityEntity activity = activityService.getActivityByID(activityID);

		/******************** 3.查詢完成，準備轉交(Send the Success view) ********************/
		req.setAttribute("activityEntity", activity);
		return "/backend/activity/updateActivity.jsp";
	}
	
	private String update(HttpServletRequest req, HttpServletResponse res) {
		
		Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
		req.setAttribute("errorMsgs", errorMsgs);
		
		/******************** 1.接收請求參數 ********************/
		Integer activityID = Integer.valueOf(req.getParameter("activityID"));
		
		Integer activityCategoryID = Integer.valueOf(req.getParameter("activityCategoryID"));
		ActivityCategoryService svc = new ActivityCategoryServiceImpl();
		ActivityCategoryEntity activityCategory = svc.getActivityCategoryByID(activityCategoryID);
		
		
		String activityName = req.getParameter("activityName");
		if (activityName == null || (activityName.trim()).length() == 0) {
			errorMsgs.put("activityName", "請輸入活動名稱");
		}
		
		Integer activityPrice = null;
		try {
			activityPrice = Integer.valueOf(req.getParameter("activityPrice").trim());
		} catch (NumberFormatException e) {
			activityPrice = 0;
			errorMsgs.put("activityPrice", "請輸入活動價格");
		}
		
		String activityInfo = req.getParameter("activityInfo");
		
		String activityNotice = req.getParameter("activityNotice");
		
		Boolean activityStatus = Boolean.parseBoolean(req.getParameter("activityStatus"));
		
		ActivityEntity activity = new ActivityEntity(activityID, activityCategory, activityName,
				activityPrice, activityInfo, activityNotice, activityStatus);
		
		if (!errorMsgs.isEmpty()) {
			req.setAttribute("activityEntity", activity);
			return "/backend/activity/updateActivity.jsp";
		}

		/******************** 2.開始查詢資料 ********************/
		ActivityService activityService = new ActivityServiceImpl();
		activity = activityService.updateActivity(activity);

		/******************** 3.查詢完成，準備轉交(Send the Success view) ********************/
		req.setAttribute("activityEntity", activity);
		return "/backend/activity/listOneActivity.jsp";
	}
	
	private String add(HttpServletRequest req, HttpServletResponse res) {

		Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
		req.setAttribute("errorMsgs", errorMsgs);

		/******************** 1.接收請求參數 - 輸入格式的錯誤處理 ********************/
		Integer activityCategoryID = Integer.valueOf(req.getParameter("activityCategoryID"));
		ActivityCategoryService svc = new ActivityCategoryServiceImpl();
		ActivityCategoryEntity activityCategory = svc.getActivityCategoryByID(activityCategoryID);
		
		
		String activityName = req.getParameter("activityName");
		if (activityName == null || (activityName.trim()).length() == 0) {
			errorMsgs.put("activityName", "請輸入活動名稱");
		}
		
		Integer activityPrice = null;
		try {
			activityPrice = Integer.valueOf(req.getParameter("activityPrice").trim());
		} catch (NumberFormatException e) {
			activityPrice = 0;
			errorMsgs.put("activityPrice", "請輸入活動價格");
		}
		
		String activityInfo = req.getParameter("activityInfo");
		
		String activityNotice = req.getParameter("activityNotice");
		
		Boolean activityStatus = Boolean.parseBoolean(req.getParameter("activityStatus"));
		
		ActivityEntity activity = new ActivityEntity(activityCategory, activityName,
				activityPrice, activityInfo, activityNotice, activityStatus);
		
		if (!errorMsgs.isEmpty()) {
			req.setAttribute("activityEntity", activity);
			return "/backend/activity/addActivity.jsp";
		}
		
		/******************** 2.開始新增資料 ********************/
		ActivityService activityService = new ActivityServiceImpl();
		activity = activityService.addActivity(activity);
		
		/******************** 3.新增完成，準備轉交(Send the Success view) ********************/
		req.setAttribute("activityEntity", activity);
		return "/backend/activity/index.jsp";
	}
	
	private String getCompositeQuery(HttpServletRequest req, HttpServletResponse res) {
		Map<String, String[]> map = req.getParameterMap();
				
				if (map != null) {
					List<ActivityEntity> list = activityService.getEmpsByCompositeQuery(map);
					req.setAttribute("list", list);
				} else {
					return "/index.jsp";
				}
				return "/backend/activity/listCompositeQueryActivity.jsp";
			}

}
