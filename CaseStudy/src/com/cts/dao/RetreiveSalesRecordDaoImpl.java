package com.cts.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.cts.model.SalesRecord;

public class RetreiveSalesRecordDaoImpl implements RetreiveSalesRecordDao {

	@Override
	public List<SalesRecord> getAllRecordsByDate(LocalDate d1, LocalDate d2) {
		List<SalesRecord> records = new ArrayList<SalesRecord>();
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CaseStudy", "root", "root");

				PreparedStatement stmt = conn.prepareStatement(
						"SELECT * FROM salesdata WHERE sold_date BETWEEN ? AND ? ORDER BY itemName");) {

			stmt.setDate(1, Date.valueOf(d1));
			stmt.setDate(2, Date.valueOf(d2));
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				SalesRecord r = new SalesRecord();
				r.setReceiptNo(rs.getInt("receipt_no"));
				r.setItemName(rs.getString("itemName"));
				r.setArea(rs.getString("area"));
				r.setUnitsSold(rs.getInt("units_sold"));
				r.setTotalCollection(rs.getInt("total_collection"));
				r.setRate(rs.getInt("rate"));
				r.setSoldDate(rs.getDate("sold_date").toLocalDate());
				records.add(r);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return records.isEmpty()?null:records;
	}

}
