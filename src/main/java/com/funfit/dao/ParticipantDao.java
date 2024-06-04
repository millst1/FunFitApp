package com.funfit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.funfit.bean.Batch;
import com.funfit.bean.Participant;
import com.funfit.resource.DbResource;

public class ParticipantDao {

	public int addParticipant(Participant participant) {
		try {
			Connection connection = DbResource.getDbConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into participants(fname,age,phonenumber,bid) values(?,?,?,?);");
			
			preparedStatement.setString(1, participant.getFirstName());
			preparedStatement.setInt(2, participant.getAge());
			preparedStatement.setString(3, participant.getPhoneNumber());
			preparedStatement.setInt(4, participant.getBid());
			
			return preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
			
			return 0;
		}
	}

	public List<Participant> viewAllParticipants() {
		List<Participant> listOfParticipats = new ArrayList<>();
		try {
			Connection connection = DbResource.getDbConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from participants");
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Participant participant = new Participant();
				participant.setPid(resultSet.getInt(1));
				participant.setFirstName(resultSet.getString(2));
				participant.setAge(resultSet.getInt(3));
				participant.setPhoneNumber(resultSet.getString(4));
				participant.setBid(resultSet.getInt(5));
				listOfParticipats.add(participant);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return listOfParticipats;
	}
	
	public boolean deleteParticipant(int pid) {
		try {
			Connection connection = DbResource.getDbConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM participants WHERE pid=" + pid);
			int resultSet = preparedStatement.executeUpdate();
			
			return true;
		} catch (Exception e) {
			System.err.println(e);
			
			return false;
		}
	}
}
