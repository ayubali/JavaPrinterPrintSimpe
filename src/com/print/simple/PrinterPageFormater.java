package com.print.simple;

import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterJob;

public class PrinterPageFormater {

	// https://www.javaworld.com/article/2076214/java-se/printing-in-java--part-1.html?page=2
	private static final double CM2INCH = 0.3937;
	private static final double PIXEL_PER_INCHI = 72d;
	private final static PrinterPageFormater INSTANCE = new PrinterPageFormater();

	private PrinterPageFormater() {
	}

	public static PrinterPageFormater getInstance() {
		return INSTANCE;
	}

	public PageFormat getPageFormat(PrinterJob printerJob, PageSize pageSize, double marginInCM, int orientation) {
		PageFormat pageFormat = printerJob.defaultPage();
		Paper paper = pageFormat.getPaper();
		// printer know only point per inch.default value is 72ppi
		double width = convert_CM_To_PPI(pageSize.getWidth());
		double height = convert_CM_To_PPI(pageSize.getHeight());
		double margin = convert_CM_To_PPI(marginInCM);
		// This method sets the physical page size. To define an 8.5-by-11-inch
		// sheet, you would supply 612 and 792 points. Note that the default
		// size is LETTER.
		paper.setSize(width, height);
		// define boarder size after that print area width is about 180 points
		paper.setImageableArea(margin, margin, paper.getWidth() - margin * 2, paper.getHeight() - margin * 2);

		pageFormat.setOrientation(orientation); // select orientation
												// portrait
		// or landscape but for this
		// time portrait eg.
		// 
		pageFormat.setPaper(paper);
		return pageFormat;
	}

	private double convert_CM_To_PPI(double cm) {
		return toPPI(cm * CM2INCH);
	}

	private double toPPI(double inch) {
		return inch * PIXEL_PER_INCHI;
	}
}
