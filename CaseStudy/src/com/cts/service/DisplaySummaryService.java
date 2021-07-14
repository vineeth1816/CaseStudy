package com.cts.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import com.cts.dao.RetreiveSalesRecordDaoImpl;
import com.cts.dao.RetreiveSalesRecordDao;
import com.cts.model.SalesRecord;
import com.cts.util.RecordComparator;

public class DisplaySummaryService {

	Scanner sc = new Scanner(System.in);
	RetreiveSalesRecordDao getAll = new RetreiveSalesRecordDaoImpl();

	@SuppressWarnings("deprecation")
	public void displayRecords() {
		String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		try {
			DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MMM-yyyy");
			System.out.println("Please enter the start date in dd-MMM-yyyy format");
			LocalDate d1=LocalDate.parse(sc.nextLine(), formatter);
			
			System.out.println("Please enter the start date in dd-MMM-yyyy format");
			LocalDate d2=LocalDate.parse(sc.nextLine(), formatter);
			
			List<SalesRecord> filteredRecords = getAll.getAllRecordsByDate(d1, d2);
			Set<String> items=new TreeSet<String>();
			System.out.print("\t");
			int y1 = d1.getYear() + 1900;
			int y2 = d2.getYear() + 1900;
			if (y2 - y1 == 0) {
				for (int i = d1.getMonthValue(); i <= d2.getMonthValue(); i++)
					System.out.print(months[i] + y1 + "\t");
				System.out.println();

				for (SalesRecord r : filteredRecords)
					items.add(r.getItemName());
				for (String item : items) {
					System.out.print(item + "\t");
					for (SalesRecord r : filteredRecords) {
						if (r.getItemName().equals(item)) {
							for (int i = d1.getMonthValue(); i <= d2.getMonthValue(); i++) {
								if (r.getSoldDate().getMonthValue() == i) {
									System.out.print(r.getUnitsSold() + " " + r.getTotalCollection() + "\t");
								}

							}
						}
					}

					System.out.println();
				}

			} else {
				for (int i = d1.getMonthValue(); i <= 11; i++)
					System.out.print(months[i] + y1 + "\t");
				for (int i = 0; i <= d2.getMonthValue(); i++)
					System.out.print(months[i] + y2 + "\t");

			}
			System.out.println();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
