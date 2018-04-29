package com.print.simple;

import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterJob;

public class PageFormaterFactory {
	
	
	 
	private static final PageFormaterFactory INSTANCE = new PageFormaterFactory();
	
	public static PageFormaterFactory getInstance() {
		return INSTANCE;
	}
	
	

	
}
