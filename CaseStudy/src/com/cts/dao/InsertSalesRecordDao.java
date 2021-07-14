package com.cts.dao;

import com.cts.model.SalesRecord;

public interface InsertSalesRecordDao {
	
	public SalesRecord insertRecord(SalesRecord record);
	public boolean checkRecord(int receiptID);

}
