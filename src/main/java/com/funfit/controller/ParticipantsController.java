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
@WebServlet("/ParticipantsController")
public class ParticipantsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ParticipantService participantService = new ParticipantService();

	public ParticipantsController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		HttpSession httpSession = request.getSession();
		
		List<Participant> listOfParticipants = participantService.viewAllParticipants();
		httpSession.setAttribute("participants", listOfParticipants);
		
		response.sendRedirect("viewParticipants.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		
		PrintWriter printWriter = response.getWriter();
		response.setContentType("text/html");
		String firstName = request.getParameter("firstName");
		int age = Integer.parseInt(request.getParameter("age"));
		String phoneNumber = request.getParameter("phoneNumber");
		int bid = Integer.parseInt(request.getParameter("bid"));
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("addParticipants.jsp");
		
		Participant participant = new Participant();
		participant.setFirstName(firstName);
		participant.setAge(age);
		participant.setPhoneNumber(phoneNumber);
		participant.setBid(bid);

		String result = participantService.addParticipants(participant);
		printWriter.print(result);
		
		requestDispatcher.include(request, response);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
