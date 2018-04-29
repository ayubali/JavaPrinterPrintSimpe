package com.print.simple;

public class StellarPrintableObject {
	private final String hospitalName;
	private final String deptName;
	private final String ticketNumber;
	private final int totalWaiting;
	private final int proxWaitInMin;

	public StellarPrintableObject(String hospitalName, String deptName, String ticketNumber, int totalWaiting,
			int proxWaitInMin) {
		super();
		this.hospitalName = hospitalName;
		this.deptName = deptName;
		this.ticketNumber = ticketNumber;
		this.totalWaiting = totalWaiting;
		this.proxWaitInMin = proxWaitInMin;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public String getDeptName() {
		return deptName;
	}

	public String getTicketNumber() {
		return ticketNumber;
	}

	public int getTotalWaiting() {
		return totalWaiting;
	}

	public int getProxWaitInMin() {
		return proxWaitInMin;
	}

}
