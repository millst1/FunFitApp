package com.funfit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.funfit.bean.Batch;
import com.funfit.bean.Participant;
import com.funfit.resource.DbResource;

public class BatchDao {

	public int addBatch(Batch batch) {
		try {
			Connection connection = DbResource.getDbConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("insert into batch(typeofbatch,time) values(?,?)");
			
			preparedStatement.setString(1, batch.getTypeofbatch());
			preparedStatement.setString(2, batch.getTime());
			
			return preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}

	public List<Batch> viewAllBatches() {
		List<Batch> listOfBatch = new ArrayList<>();
		try {
			Connection connection = DbResource.getDbConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from batch");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Batch batch = new Batch();
				batch.setBid(resultSet.getInt(1));
				batch.setTypeofbatch(resultSet.getString(2));
				batch.setTime(resultSet.getString(3));
				listOfBatch.add(batch);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return listOfBatch;
	}
	
	public boolean deleteBatch(int bid) {
		try {
			Connection connection = DbResource.getDbConnection();
			System.out.println("bid="+bid);
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM batch WHERE bid=" + bid);
			System.out.println("execute");
			int resultSet = preparedStatement.executeUpdate();
			
			return true;
		} catch (Exception e) {
			System.err.println(e);
			
			return false;
		}
	}
}
