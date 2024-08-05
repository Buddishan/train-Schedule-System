package com.trainSchedule.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.trainSchedule.model.trainSchedule;

//This DAO class provides CRUD database operations for the table users in the table.
public class trainScheduleDAO<trainSchedules> {
	private String jdbcURL = "jdbc:mysql://localhost:3306/trainreservation?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "qwerty1234";

	private static final String INSERT_TRAINRESERVATION_SQL = "INSERT INTO trainschedule"
			+ " (trainName, frmStation, toStation, Price, departTime, arriveTime) VALUES" + " (?, ?, ?, ?, ?, ?) ";
	private static final String SELECT_TRAINSCHEDULES_BY_TRAINID = "select trainID,trainName, frmStation, toStation, Price, departTime, arriveTime from trainschedule where trainID =?";
	private static final String SELECT_ALL_TRAINSCHEDULES = "select * from trainschedule";
	private static final String DELETE_TRAINSCHEDULE_SQL = "delete from trainschedule where trainID = ?;";
	private static final String UPDATE_TRAINSCHEDULE_SQL = "update trainschedule set trainName = ?, frmStation = ?, toStation = ?, Price = ?, departTime = ?, arriveTime = ? where trainID = ?;";

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

	// Create or Insert Train schedule
	public void inserttrainSchedule(trainSchedule trainschedu) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TRAINRESERVATION_SQL)) {
			preparedStatement.setString(1, trainschedu.getTrainName());
			preparedStatement.setString(2, trainschedu.getFrmStation());
			preparedStatement.setString(3, trainschedu.getToStation());
			preparedStatement.setString(4, trainschedu.getPrice());
			preparedStatement.setString(5, trainschedu.getDepartTime());
			preparedStatement.setString(6, trainschedu.getArriveTime());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Update Train Schedule
	public boolean updatetrainSchedule(trainSchedule trainschedu) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_TRAINSCHEDULE_SQL);) {
			statement.setString(1, trainschedu.getTrainName());
			statement.setString(2, trainschedu.getFrmStation());
			statement.setString(3, trainschedu.getToStation());
			statement.setString(4, trainschedu.getPrice());
			statement.setString(5, trainschedu.getDepartTime());
			statement.setString(6, trainschedu.getArriveTime());
			statement.setInt(7, trainschedu.getTrainID());

			rowUpdated = statement.executeUpdate() > 0;
		}

		return rowUpdated;

	}

	// Select train by ID
	public trainSchedule selecttrainSchedule(int trainID) {
		trainSchedule trainschedu = null;

		// Step 01 - Establishing a connection
		try (Connection connection = getConnection();

				// Step 02 - Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TRAINSCHEDULES_BY_TRAINID);) {
			preparedStatement.setInt(1, trainID);
			System.out.println(preparedStatement);

			// Step 03 - Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 04 - Process the ResultSet object
			while (rs.next()) {
				String trainName = rs.getString("trainName");
				String frmStation = rs.getString("frmStation");
				String toStation = rs.getString("toStation");
				String Price = rs.getString("Price");
				String departTime = rs.getString("departTime");
				String arriveTime = rs.getString("arriveTime");
				trainschedu = new trainSchedule(trainID, trainName, frmStation, toStation, Price, departTime,
						arriveTime);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trainschedu;
	}

	// Select all users
	public List<trainSchedules> selectAlltrainSchedules() {
		List<trainSchedules> trainschedu = new ArrayList<>();

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TRAINSCHEDULES);) {

			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int trainID = rs.getInt("trainID");
				String trainName = rs.getString("trainName");
				String frmStation = rs.getString("frmStation");
				String toStation = rs.getString("toStation");
				String Price = rs.getString("Price");
				String departTime = rs.getString("departTime");
				String arriveTime = rs.getString("arriveTime");
				trainschedu.add((trainSchedules) new trainSchedule(trainID, trainName, frmStation, toStation, Price,departTime, arriveTime));
			}
		} catch

		(SQLException e) {
			e.printStackTrace();
		}
		return trainschedu;
	}

	// Delete Train Schedule
	public boolean deletetrainSchedule(int trainID) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_TRAINSCHEDULE_SQL);) {
			statement.setInt(1, trainID);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
}
