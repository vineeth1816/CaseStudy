package com.cts.model;

public class InsertionSummary {
	private int totalNumberOfRecords;
	private int insertedRecords;
	public InsertionSummary(int totalNumberOfRecords, int insertedRecords) {
		super();
		this.totalNumberOfRecords = totalNumberOfRecords;
		this.insertedRecords = insertedRecords;
	}
	public int getTotalNumberOfRecords() {
		return totalNumberOfRecords;
	}
	public void setTotalNumberOfRecords(int totalNumberOfRecords) {
		this.totalNumberOfRecords = totalNumberOfRecords;
	}
	public int getInsertedRecords() {
		return insertedRecords;
	}
	public void setInsertedRecords(int insertedRecords) {
		this.insertedRecords = insertedRecords;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + insertedRecords;
		result = prime * result + totalNumberOfRecords;
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
		InsertionSummary other = (InsertionSummary) obj;
		if (insertedRecords != other.insertedRecords)
			return false;
		if (totalNumberOfRecords != other.totalNumberOfRecords)
			return false;
		return true;
	}

}
