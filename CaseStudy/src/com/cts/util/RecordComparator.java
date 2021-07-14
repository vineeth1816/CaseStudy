package com.cts.util;

import java.util.Comparator;

import com.cts.model.SalesRecord;

public class RecordComparator implements Comparator<SalesRecord> {

	@Override
	public int compare(SalesRecord o1, SalesRecord o2) {
		
		return o1.getSoldDate().compareTo(o2.getSoldDate());
	}

}
