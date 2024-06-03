package com.funfit.service;

import java.util.List;

import com.funfit.bean.Batch;
import com.funfit.dao.BatchDao;

public class BatchService {

	BatchDao db = new BatchDao();

	public String addBatch(Batch batch) {
		if (db.addBatch(batch) > 0) {
			return "Batch Details added";
		} else {
			return "Batch deatils did't add";
		}
	}

	public List<Batch> viewAllBatch() {
		return db.viewAllBatches();
	}
}
