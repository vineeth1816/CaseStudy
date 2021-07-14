package com.cts.dao;

import java.sql.*;
import java.text.SimpleDateFormat;

import com.cts.model.SalesRecord;

public class InsertSalesRecordDaoImpl implements InsertSalesRecordDao {

	@Override
	public SalesRecord insertRecord(SalesRecord record) {
		if (record != null) {
			try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CaseStudy", "root", "root");
					PreparedStatement stmt = conn.prepareStatement("INSERT INTO salesdata VALUES(?,?,?,?,?,?,?)");) {

				stmt.setInt(1, record.getReceiptNo());
				stmt.setString(2, record.getItemName());
				stmt.setString(3, record.getArea());
				stmt.setInt(4, record.getUnitsSold());
				stmt.setInt(5, record.getTotalCollection());
				stmt.setInt(6, record.getRate());
				stmt.setDate(7, Date.valueOf(record.getSoldDate()));

				stmt.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return record;
	}

	@Override
	public boolean checkRecord(int receiptID) {
		boolean exists = false;
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CaseStudy", "root", "root");
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM salesdata WHERE receipt_no=?");) {

			stmt.setInt(1, receiptID);
			ResultSet rs = stmt.executeQuery();
			exists = rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return exists;

	}

}
