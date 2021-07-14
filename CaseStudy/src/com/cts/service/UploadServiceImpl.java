package com.cts.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Scanner;

import com.cts.dao.InsertSalesRecordDaoImpl;
import com.cts.exceptions.InvalidUploadFileException;
import com.cts.model.InsertionSummary;
import com.cts.model.SalesRecord;
import com.cts.dao.InsertSalesRecordDao;

public class UploadServiceImpl {

	private InsertSalesRecordDao dao;

	public UploadServiceImpl() {
		this.dao = new InsertSalesRecordDaoImpl();
	}

	public InsertionSummary uploadData(String fileName) throws InvalidUploadFileException {

		InsertionSummary summary = new InsertionSummary(0, 0);
		File f = new File(fileName);
		int totalrecords = 0;
		int insertedRecords = 0;
		if (!f.exists())
			throw new InvalidUploadFileException("The given file does not exists");
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName));) {

			List<String> errors = new ArrayList<String>();

			summary.setTotalNumberOfRecords((int) reader.lines().count());
			Optional<Integer> totalInsertedRecords = reader.lines().map(record -> {

				int count = 0;
				String[] data = record.split(",");

				if (data.length != 7) {
					errors.add("Invalid record format");
				} else {
					try {
						dao.insertRecord(parse(data));
						count++;
					} catch (InvalidUploadFileException e) {
						errors.add(e.getMessage());
					}
				}
				return count;

			}).reduce((n1, n2) -> n1 + n2);

			if (!errors.isEmpty())
				throw new InvalidUploadFileException(errors.toString());

			summary.setInsertedRecords(totalInsertedRecords.get());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return summary;
	}

	public SalesRecord parse(String[] details) throws InvalidUploadFileException {
		List<String> errors = new ArrayList<String>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		SalesRecord record = new SalesRecord();

		if (details[0].matches("[0-9]+"))
			record.setReceiptNo(Integer.parseInt(details[0]));
		else
			errors.add(record.getReceiptNo() + " receipt no is not valid number");

		record.setItemName(details[1]);
		record.setArea(details[2]);

		if (details[3].matches("[0-9]+"))
			record.setUnitsSold(Integer.parseInt(details[3]));
		else
			errors.add("units sold is not valid number");

		if (details[4].matches("[0-9]+"))
			record.setTotalCollection(Integer.parseInt(details[4]));
		else
			errors.add(" TotalCollection no is not valid number");

		if (details[5].matches("[0-9]+"))
			record.setRate(Integer.parseInt(details[5]));
		else
			errors.add(" Rate is not valid number");

		record.setSoldDate(LocalDate.parse(details[6], formatter));// Include regex for date

		if (dao.checkRecord(record.getReceiptNo())) {

			errors.add(record.getReceiptNo() + "Receipt no already exists");
		}

		if (!errors.isEmpty())
			throw new InvalidUploadFileException(errors.toString());
		return record;
	}

}
