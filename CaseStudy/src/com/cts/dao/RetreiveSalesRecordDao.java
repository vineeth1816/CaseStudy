package com.cts.dao;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.cts.model.SalesRecord;

public interface RetreiveSalesRecordDao {

	public List<SalesRecord> getAllRecordsByDate(LocalDate d1,LocalDate d2);
}
