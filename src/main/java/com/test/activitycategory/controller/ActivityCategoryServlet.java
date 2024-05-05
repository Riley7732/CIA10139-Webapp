package com.test.activitycategory.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.activitycategory.entity.ActivityCategoryEntity;
import com.test.activitycategory.service.ActivityCategoryService;
import com.test.activitycategory.service.ActivityCategoryServiceImpl;

@WebServlet("/activitycategory/activitycategory.do")
public class ActivityCategoryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ActivityCategoryService activityCategoryService;

	@Override
	public void init() throws ServletException {
		activityCategoryService = new ActivityCategoryServiceImpl();
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
			// 接收jsp的action
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
		Integer activityCategoryID = Integer.valueOf(req.getParameter("activityCategoryID"));

		/******************** 2.開始查詢資料 ********************/
		ActivityCategoryService activityCategoryService = new ActivityCategoryServiceImpl();
		ActivityCategoryEntity activityCategory = activityCategoryService.getActivityCategoryByID(activityCategoryID);

		/******************** 3.查詢完成，準備轉交(Send the Success view) ********************/
		req.setAttribute("activityCategoryEntity", activityCategory);
		return "/backend/activitycategory/listOneActivityCategory.jsp";
	}

	private String updatePage(HttpServletRequest req, HttpServletResponse res) {

		/******************** 1.接收請求參數 ********************/
		Integer activityCategoryID = Integer.valueOf(req.getParameter("activityCategoryID"));

		/******************** 2.開始查詢資料 ********************/
		ActivityCategoryService activityCategoryService = new ActivityCategoryServiceImpl();
		ActivityCategoryEntity activityCategory = activityCategoryService.getActivityCategoryByID(activityCategoryID);

		/******************** 3.查詢完成，準備轉交(Send the Success view) ********************/
		req.setAttribute("activityCategoryEntity", activityCategory);
		return "/backend/activitycategory/updateActivityCategory.jsp";
	}

	private String update(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
		req.setAttribute("errorMsgs", errorMsgs);

		/******************** 1.接收請求參數 - 輸入格式的錯誤處理 ********************/
		Integer activityCategoryID = Integer.valueOf(req.getParameter("activityCategoryID"));

		String activityCategoryName = req.getParameter("activityCategoryName");
		if (activityCategoryName == null || (activityCategoryName.trim()).length() == 0) {
			errorMsgs.put("activityCategoryName", "請輸入活動類別名稱");
		}

		String activityCategoryInfo = req.getParameter("activityCategoryInfo");
		
		ActivityCategoryEntity activityCategory = new ActivityCategoryEntity(activityCategoryID, activityCategoryName,
				activityCategoryInfo);
		
		if (!errorMsgs.isEmpty()) {
			req.setAttribute("activityCategoryEntity", activityCategory);
			return "/backend/activitycategory/updateActivityCategory.jsp";
		}

		/******************** 2.開始修改資料 ********************/
		ActivityCategoryService activityCategoryService = new ActivityCategoryServiceImpl();
		activityCategory = activityCategoryService.updateActivityCategory(activityCategory);

		/******************** 3.修改完成，準備轉交(Send the Success view) ********************/
		req.setAttribute("activityCategoryEntity", activityCategory);
		return "/backend/activitycategory/listOneActivityCategory.jsp";
	}

	private String add(HttpServletRequest req, HttpServletResponse res) {

		Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
		req.setAttribute("errorMsgs", errorMsgs);

		/******************** 1.接收請求參數 - 輸入格式的錯誤處理 ********************/
		String activityCategoryName = req.getParameter("activityCategoryName");
		if (activityCategoryName == null || (activityCategoryName.trim()).length() == 0) {
			errorMsgs.put("activityCategoryName", "請輸入活動類別名稱");
		}

		String activityCategoryInfo = req.getParameter("activityCategoryInfo");
		
		ActivityCategoryEntity activityCategory = new ActivityCategoryEntity(activityCategoryName,
				activityCategoryInfo);
		
		if (!errorMsgs.isEmpty()) {
			req.setAttribute("activityCategoryEntity", activityCategory);
			return "/backend/activitycategory/addActivityCategory.jsp";
		}

		/******************** 2.開始新增資料 ********************/
		ActivityCategoryService activityCategoryService = new ActivityCategoryServiceImpl();
		activityCategory = activityCategoryService.addActivityCategory(activityCategory);

		/******************** 3.新增完成，準備轉交(Send the Success view) ********************/
		req.setAttribute("activityCategoryEntity", activityCategory);
		return "/backend/activitycategory/index.jsp";
	}

}
