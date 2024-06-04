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

/**
 * Servlet implementation class BatchController
 */
@WebServlet("/BatchController")
public class BatchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BatchService batchService = new BatchService();

	public BatchController() {
		super();

	}

	// view purpose
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		List<Batch> listOfBatch = batchService.viewAllBatch();
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("batches", listOfBatch);

		response.sendRedirect("viewBatches.jsp");
	}

	// store or insert
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		PrintWriter printWriter = response.getWriter();
		response.setContentType("text/html");

		String typeofbatch = request.getParameter("typeofbatch");
		String time = request.getParameter("time");

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("addBatch.jsp");

		Batch batch = new Batch();
		batch.setTypeofbatch(typeofbatch);
		batch.setTime(time);

		String result = batchService.addBatch(batch);
		printWriter.println(result);

		requestDispatcher.include(request, response);
	}
}
