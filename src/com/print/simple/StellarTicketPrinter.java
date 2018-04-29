package com.print.simple;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.time.LocalDate;
import java.time.LocalTime;

public class StellarTicketPrinter implements IPageFormater, Printable {

	private PrinterPageFormater printerPageFormater;
	private final Font regularFont = new Font("Monospaced", Font.PLAIN, 8);
	private final Font ticketNumerFont = new Font("Monospaced", Font.BOLD, 16);
	private final Font headerFont = new Font("Monospaced", Font.BOLD, 12);
	private final StellarPrintableObject printObject;

	public StellarTicketPrinter(StellarPrintableObject printObject) {
		printerPageFormater = PrinterPageFormater.getInstance();
		this.printObject = printObject;
	}

	@Override
	public PageFormat getPageFormat(PrinterJob printerJob) {
		PageFormat pageFormat = printerPageFormater.getPageFormat(printerJob, PageSize.C_STELLAR_TICKET, 0.5d,
				PageFormat.PORTRAIT);
		return pageFormat;
	}

	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		if (pageIndex != 0) {
			return NO_SUCH_PAGE;
		}

		Graphics2D g2d = (Graphics2D) graphics;
		g2d.translate((int) pageFormat.getImageableX(), (int) pageFormat.getImageableY());
		try {
			int y = 20;
			int yShift = 10;
			g2d.drawString("**********************************************", 10, y);
			g2d.setFont(headerFont);
			y += yShift;
			g2d.drawString(String.format("     %s      ", printObject.getHospitalName()), 12, y);
			y += yShift;
			g2d.setFont(regularFont);
			g2d.drawString(String.format("          %s      ", printObject.getDeptName()), 12, y);
			y += yShift;
			g2d.drawString("        Your Ticket Number    ", 12, y);
			y += yShift + 5;
			g2d.setFont(ticketNumerFont);
			g2d.drawString(String.format("      %s    ", printObject.getTicketNumber()), 10, y);
			y += yShift + 5;
			g2d.setFont(regularFont);
			g2d.drawString("---------------------------------------------", 10, y);
			y += yShift;
			g2d.drawString("Please proceed to Physio Therapy and ", 12, y);
			y += yShift;
			g2d.drawString("wait until your Ticket number is called", 12, y);
			y += yShift;
			g2d.drawString(String.format("Total customer(s) waiting: %d  ", printObject.getTotalWaiting()), 12, y);
			y += yShift;
			g2d.drawString(String.format("You will be called in approximately %d Minute(s)    ",
					printObject.getProxWaitInMin()), 12, y);
			y += yShift;
			g2d.drawString("********************************************", 10, y);
			y += yShift;
			g2d.drawString("             THANKS YOU   ", 15, y);
			LocalDate today = LocalDate.now();
			LocalTime time = LocalTime.now();
			g2d.drawString(today.toString(), 10, y);
			g2d.drawString(time.toString(), 140, y);
			y += yShift;
			g2d.drawString("********************************************", 10, y);

		} catch (Exception r) {
			r.printStackTrace();
		}
		return PAGE_EXISTS;
	}
	
}
