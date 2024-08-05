package com.trainSchedule.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trainSchedule.dao.trainScheduleDAO;
import com.trainSchedule.model.trainSchedule;

@WebServlet("/")
public class trainScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private trainScheduleDAO trainScheduDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public trainScheduleServlet() {
		this.trainScheduDAO = new trainScheduleDAO();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
		case "/new":
			showNewForm(request, response);
			break;
		case "/insert":
			try {
				inserttrainSchedule(request, response);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/delete":
			try {
				deletetrainSchedule(request, response);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/edit":
			showEditForm(request, response);
			break;
		case "/update":
			try {
				updatetrainSchedule(request, response);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		default:
			// Handle list
			listtrainSchedule(request, response);
			break;
		}

	}

	private void listtrainSchedule(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<trainSchedule> listtrainSchedule = trainScheduDAO.selectAlltrainSchedules();
		request.setAttribute("listtrainSchedule", listtrainSchedule);
		RequestDispatcher dispatcher = request.getRequestDispatcher("trainschedu-list.jsp");
		dispatcher.forward(request, response);
	}

	private void updatetrainSchedule(HttpServletRequest request, HttpServletResponse response)
			throws IOException, SQLException {
		int trainID = Integer.parseInt(request.getParameter("trainID"));
		String trainName = request.getParameter("trainName");
		String frmStation = request.getParameter("frmStation");
		String toStation = request.getParameter("toStation");
		String Price = request.getParameter("Price");
		String departTime = request.getParameter("departTime");
		String arriveTime = request.getParameter("arriveTime");

		trainSchedule trainschedu = new trainSchedule(trainID, trainName, frmStation, toStation, Price, departTime,
				arriveTime);
		trainScheduDAO.updatetrainSchedule(trainschedu);
		response.sendRedirect("list");
	}

	private void deletetrainSchedule(HttpServletRequest request, HttpServletResponse response)
			throws IOException, SQLException {
		int trainID = Integer.parseInt(request.getParameter("id"));
		trainScheduDAO.deletetrainSchedule(trainID);
		response.sendRedirect("list");
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int trainID = Integer.parseInt(request.getParameter("id"));
		trainSchedule existingtrainSchedule = trainScheduDAO.selecttrainSchedule(trainID);
		RequestDispatcher dispatcher = request.getRequestDispatcher("trainschedu-form.jsp");
		request.setAttribute("trainschedu", existingtrainSchedule);
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("trainschedu-form.jsp");
		dispatcher.forward(request, response);
	}

	private void inserttrainSchedule(HttpServletRequest request, HttpServletResponse response)
			throws IOException, SQLException {
		String trainName = request.getParameter("trainName");
		String frmStation = request.getParameter("frmStation");
		String toStation = request.getParameter("toStation");
		String Price = request.getParameter("Price");
		String departTime = request.getParameter("departTime");
		String arriveTime = request.getParameter("arriveTime");
		trainSchedule newtrainSchedule = new trainSchedule(trainName, frmStation, toStation, Price, departTime,
				arriveTime);
		trainScheduDAO.inserttrainSchedule(newtrainSchedule);
		response.sendRedirect("list");

	}

}
