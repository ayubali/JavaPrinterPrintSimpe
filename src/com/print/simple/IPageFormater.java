package com.print.simple;

import java.awt.print.PageFormat;
import java.awt.print.PrinterJob;

public interface IPageFormater {
	PageFormat getPageFormat(PrinterJob printerJob);
}
