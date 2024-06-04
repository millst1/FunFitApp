package com.funfit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.funfit.bean.Batch;
import com.funfit.service.BatchService;
import com.funfit.service.ParticipantService;

/**
 * Servlet implementation class BatchController
 */
@WebServlet("/BatchDeleteController")
public class BatchDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BatchService batchService = new BatchService();
	ParticipantService participantService = new ParticipantService();

	public BatchDeleteController() {
		super();

	}

	// view purpose
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		System.out.println("DELETE CONTROLLER");
		String batchId = request.getParameter("batchId");
		System.out.println(batchId);
		if (batchId != null) {
			int bid = Integer.parseInt(batchId);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("deleteBatch.jsp");
		
			boolean result = batchService.deleteBatch(bid);
		
			requestDispatcher.include(request, response);
		}
		response.sendRedirect("deleteBatch.jsp");
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		int bid = Integer.parseInt(request.getParameter("batchId"));
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("deleteBatch.jsp");
		
		batchService.deleteBatch(bid);
		
		
		requestDispatcher.include(request, response);
	}
}
