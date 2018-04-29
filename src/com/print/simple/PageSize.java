package com.print.simple;

public enum PageSize {
	A0(84.1d, 118.9d), A1(59.4d, 84.1d), A2(42.0d, 59.4d), A3(29.7d, 42.0d), A4(21.0d, 29.7d), C_STELLAR_TICKET(12.0d, 10d);

	private PageSize(double widht, double height) {
		this.width = widht;
		this.height = height;
	}

	private double width;
	private double height;
	
	public double getHeight() {
		return height;
	}
	
	public double getWidth() {
		return width;
	}
}
