package com.cts.model;

import java.time.LocalDate;
import java.util.Date;

public class SalesRecord {
	private int receiptNo;
	private String itemName;
	private String area;
	private int unitsSold;
	private int totalCollection;
	private int rate;
	private LocalDate soldDate;

	public SalesRecord() {

	}

	public SalesRecord(int receiptNo, String itemName, String area, int unitsSold, int totalCollection, int rate,
			LocalDate soldDate) {
		super();
		this.receiptNo = receiptNo;
		this.itemName = itemName;
		this.area = area;
		this.unitsSold = unitsSold;
		this.totalCollection = totalCollection;
		this.rate = rate;
		this.soldDate = soldDate;
	}
	

	public int getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(int receiptNo) {
		this.receiptNo = receiptNo;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getUnitsSold() {
		return unitsSold;
	}

	public void setUnitsSold(int unitsSold) {
		this.unitsSold = unitsSold;
	}

	public int getTotalCollection() {
		return totalCollection;
	}

	public void setTotalCollection(int totalCollection) {
		this.totalCollection = totalCollection;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public LocalDate getSoldDate() {
		return soldDate;
	}

	public void setSoldDate(LocalDate soldDate) {
		this.soldDate = soldDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + rate;
		result = prime * result + receiptNo;
		result = prime * result + ((soldDate == null) ? 0 : soldDate.hashCode());
		result = prime * result + totalCollection;
		result = prime * result + unitsSold;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalesRecord other = (SalesRecord) obj;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (rate != other.rate)
			return false;
		if (receiptNo != other.receiptNo)
			return false;
		if (soldDate == null) {
			if (other.soldDate != null)
				return false;
		} else if (!soldDate.equals(other.soldDate))
			return false;
		if (totalCollection != other.totalCollection)
			return false;
		if (unitsSold != other.unitsSold)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SalesRecord [receiptNo=" + receiptNo + ", itemName=" + itemName + ", area=" + area + ", unitsSold="
				+ unitsSold + ", totalCollection=" + totalCollection + ", rate=" + rate + ", soldDate=" + soldDate
				+ "]";
	}

}
