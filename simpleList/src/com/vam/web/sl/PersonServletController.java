package com.vam.web.sl;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class PersonServletController
 */
@WebServlet("/PersonServletController")
public class PersonServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PersonClassModel personClassModel;
	@Resource(name = "jdbc/simple_list")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();

		// create person db util and pass conn pool/ datasource
		try {
			personClassModel = new PersonClassModel(dataSource);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// read the "command" param in addStudentForm.jsp
			String theCommand = request.getParameter("command");
			if (theCommand == null)
				theCommand = "LIST";

			switch (theCommand) {
			case "LIST":
				listPerson(request, response);
				break;

			case "LOAD":
				loadPerson(request, response);
				break;

			case "DELETE":
				deletePerson(request, response);
				break;
				
			case "UPDATE":
				updatePerson(request, response);
				break;

			case "SEARCH":
				searchPerson(request, response);
				break;

			default:
				listPerson(request, response);
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	private void searchPerson(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read search name from form data
		String theSearchName = request.getParameter("theSearchName");

		// search person from db util
		List<Person> persons = personClassModel.searchPerson(theSearchName);

		// add person to the request
		request.setAttribute("PERSON_LIST", persons);

		// send to JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/listPersonView.jsp");
		dispatcher.forward(request, response);
	}

	private void deletePerson(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String thePersonId = request.getParameter("personId");
		personClassModel.delPerson(thePersonId);
		listPerson(request, response);
	}

	private void updatePerson(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("personId"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");

		Person thePerson = new Person(id, firstName, lastName, email);

		personClassModel.updatePerson(thePerson);

		listPerson(request, response);
	}

	private void loadPerson(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// read person id from form
		String thePersonId = request.getParameter("personId");

		// get person from util
		Person thePerson = personClassModel.getPerson(thePersonId);

		// place person in request attribute
		request.setAttribute("the_person", thePerson);

		// send to jsp updatePersonForm.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("/updatePersonForm.jsp");
		dispatcher.forward(request, response);
	}

	private void addPerson(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// read data from form
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");

		// create person object
		Person theStudent = new Person(firstName, lastName, email);

		// add person to database
		personClassModel.addPerson(theStudent);

		response.sendRedirect(request.getContextPath() + "/PersonServletController?command=LIST");
	}

	private void listPerson(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// get person from db util
		List<Person> persons = personClassModel.getPerson();

		// add person to request
		request.setAttribute("PERSON_LIST", persons);

		// send to jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("/listPersonView.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			
			// route to the appropriate method
			switch (theCommand) {
			
			case "ADD":
				addPerson(request, response);
				break;

			default:
				listPerson(request, response);
			}

		} catch (Exception exc) {
			throw new ServletException(exc);
		}

	}

}
