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

import com.funfit.bean.Participant;
import com.funfit.service.ParticipantService;

/**
 * Servlet implementation class ParticipantsController
 */
@WebServlet("/ParticipantsDeleteController")
public class ParticipantsDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ParticipantService participantService = new ParticipantService();

	public ParticipantsDeleteController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String participantId = request.getParameter("batchId");
		System.out.println(participantId);
		if (participantId != null) {
			int bid = Integer.parseInt(participantId);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("deleteParticipant.jsp");
		
			boolean result = participantService.deleteParticipant(bid);
		
			requestDispatcher.include(request, response);
		}
		response.sendRedirect("deleteParticipant.jsp");
	}
}
