package com.funfit.service;

import java.util.List;

import com.funfit.bean.Batch;
import com.funfit.dao.BatchDao;

public class BatchService {

	static BatchDao batchDao = new BatchDao();

	public String addBatch(Batch batch) {
		if (batchDao.addBatch(batch) > 0) {
			return "Batch Details added";
		} else {
			return "Batch deatils did't add";
		}
	}

	public List<Batch> viewAllBatch() {
		return batchDao.viewAllBatches();
	}
	
	public boolean deleteBatch(int bid) {
		return batchDao.deleteBatch(bid);
	}
}
