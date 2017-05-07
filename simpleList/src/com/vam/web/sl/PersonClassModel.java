/*
 * get data from data source
 * 
 */

package com.vam.web.sl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class PersonClassModel {

	private DataSource dataSource;

	public PersonClassModel(DataSource theDataSource) {
		this.dataSource = theDataSource;
	}

	public List<Person> getPerson() throws Exception {
		List<Person> persons = new ArrayList<>();

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {
			// get connection
			myConn = dataSource.getConnection();

			// create sql
			String sql = "select * from person order by last_name";
			myStmt = myConn.createStatement();

			// execute query
			myRs = myStmt.executeQuery(sql);

			// process result set
			while (myRs.next()) {

				// retrieve data from table
				int id = myRs.getInt("id");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");

				// create object
				Person tempPerson = new Person(id, firstName, lastName, email);

				// add to the list
				persons.add(tempPerson);
			}
			return persons;
		} finally {
			// close jdbc
			close(myConn, myStmt, myRs);
		}

	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		try {
			if (myRs != null)
				myRs.close();
			if (myStmt != null)
				myStmt.close();
			if (myConn != null)
				myConn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addPerson(Person thePerson) throws SQLException {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();

			// create sql insert
			String sql = "insert into person " + "(first_name, last_name, email) " + "values(?, ?, ?)";

			// set param values
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, thePerson.getFirstName());
			myStmt.setString(2, thePerson.getLastName());
			myStmt.setString(3, thePerson.getEmail());

			// execute the sql
			myStmt.execute();
		} finally {
			// clean up
			close(myConn, myStmt, null);
		}
	}

	public Person getPerson(String thePersonId) throws Exception {
		Person thePerson = null;
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int personId;

		try {
			// convert id to int
			personId = Integer.parseInt(thePersonId);

			// get connection to database
			myConn = dataSource.getConnection();

			// create sql to get selected statement
			String sql = "select * from person where id =?";

			// create prepared statment
			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setInt(1, personId);

			// execute statement
			myRs = myStmt.executeQuery();

			// retrieve data from result set row
			if (myRs.next()) {
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");

				// use personId during construction
				thePerson = new Person(personId, firstName, lastName, email);
			} else {
				throw new Exception("could not find person id: " + personId);

			}
			return thePerson;

		} finally {
			close(myConn, myStmt, myRs);
		}

	}

	public void updatePerson(Person thePerson) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();

			String sql = "update person " + "set first_name=?, last_name=?, email=? " + "where id=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, thePerson.getFirstName());
			myStmt.setString(2, thePerson.getLastName());
			myStmt.setString(3, thePerson.getEmail());
			myStmt.setInt(4, thePerson.getId());
			myStmt.execute();
		} finally {
			close(myConn, myStmt, null);
		}
	}

	public void delPerson(String thePersonId) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {

			int id = Integer.parseInt(thePersonId);
			myConn = dataSource.getConnection();
			String sql = "delete from person where id=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, id);
			myStmt.execute();

		} finally {
			close(myConn, myStmt, null);
		}
	}

	public List<Person> searchPerson(String theSearchName) throws Exception {
		List<Person> persons = new ArrayList<>();

		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {

			// get connection to database
			myConn = dataSource.getConnection();

			// search by name if theSearchName is not empty
			if (theSearchName != null && theSearchName.trim().length() > 0) {

				// search by name
				String sql = "select * from person where lower(first_name) like ? or lower(last_name) like ?";
				myStmt = myConn.prepareStatement(sql);
				String theSearchNameLike = "%" + theSearchName.toLowerCase() + "%";
				myStmt.setString(1, theSearchNameLike);
				myStmt.setString(2, theSearchNameLike);

			} else {
				// get all
				String sql = "select * from person order by last_name";
				myStmt = myConn.prepareStatement(sql);
			}

			// execute
			myRs = myStmt.executeQuery();

			// retrieve data
			while (myRs.next()) {
				int id = myRs.getInt("id");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");

				Person tempPerson = new Person(id, firstName, lastName, email);

				// add it to the list
				persons.add(tempPerson);
			}

			return persons;
		} finally {
			close(myConn, myStmt, myRs);
		}
	}
}