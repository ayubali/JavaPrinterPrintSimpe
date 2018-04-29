import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.print.simple.StellarPrintableObject;
import com.print.simple.StellarTicketPrinter;

public class SellarPrintFrame {
	JButton print;

	SellarPrintFrame() {
		buildGUI();
		hookUpEvents();
	}

	public void buildGUI() {
		JFrame fr = new JFrame("Program to Print on a Printer");
		JPanel p = new JPanel();
		print = new JButton("Print");
		fr.setPreferredSize(new Dimension(200, 200));
		p.setBackground(Color.black);
		fr.add(p);
		p.add(print, BorderLayout.CENTER);
		fr.pack();
		fr.setVisible(true);
	}

	public void hookUpEvents() {
		print.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				StellarPrintableObject object = new StellarPrintableObject("Stellar Vision", "Physio Therapy", "P-20",
						12, 30);
				StellarTicketPrinter stellarTicketPrinter = new StellarTicketPrinter(object);

				PrinterJob job = PrinterJob.getPrinterJob();
				job.setPrintable(stellarTicketPrinter, stellarTicketPrinter.getPageFormat(job));
				boolean doPrint = job.printDialog();
				if (doPrint) {
					try {
						job.print();
					} catch (PrinterException exc) {
						System.out.println(exc);
					}
				} else {
					System.out.println("You cancelled the print");
				}
			}
		});
	}

	public static void main(String[] args) {
		new SellarPrintFrame();
	}

}
