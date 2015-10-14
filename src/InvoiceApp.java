

import java.util.*;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class InvoiceApp {
	static int invoiceId = 1;
	final static double taxRate = 0.05;
	
	public InvoiceApp() {
		invoiceId++;
	}
	/*
	 * In this app the invoice Id is in each LineItem, but not the other way. So you can navigate from LineItem to invoice only.
	 */
	public static void main(String[] args) {
		double taxableTotal = 0.0, untaxableTotal = 0.0, totalTax = 0.0, grandTotal = 0.0, lineItemTotal = 0.0, lineTax = 0.0;
		int itemCount = 0;
		Scanner kb = new Scanner(System.in);	
		// creating an invoice
		//InvoiceApp theInvoice = new InvoiceApp();
		DateFormat df = new SimpleDateFormat("EEE, MMM d, ' 'yy");
		Date invoiceDate = new Date();
		System.out.println("Invoice " + InvoiceApp.invoiceId + "  on " + df.format(invoiceDate));
		System.out.println();
		System.out.println("Product \t Quantity \t Line Total \t Line Tax");
        NumberFormat currency = NumberFormat.getCurrencyInstance();  
		//creating lineitems
		System.out.println("Enter product barcode");
		String pBarCode = kb.next(); 
        while (!pBarCode.equals("done")){
        	Product theProduct = ProductDB.getProduct(pBarCode);
            LineItem thisLineItem = new LineItem(theProduct, InvoiceApp.invoiceId);
            //LineItem created
    		System.out.println("Enter product unit price");
    		double pUnitPrice = kb.nextDouble();      
    		theProduct.setUnitPrice(pUnitPrice);
    		System.out.println("Enter the quantity purchased");
         	itemCount = kb.nextInt();
		    thisLineItem.setQuantity(itemCount); 
		    // calculate the line item total
		    lineItemTotal = thisLineItem.getQuantity() * theProduct.getUnitPrice();
		    thisLineItem.setLineItemTotal(lineItemTotal);
		    grandTotal = grandTotal + lineItemTotal;
			System.out.println("Is it taxable?");
			Boolean taxFlag = kb.nextBoolean();
			thisLineItem.setTaxable(taxFlag);
			if (taxFlag) {
				lineTax = lineItemTotal * taxRate;
				taxableTotal = taxableTotal + lineItemTotal;
				totalTax = totalTax + lineTax;
			}
			else {
				lineTax = 0.0;
				untaxableTotal = untaxableTotal + lineItemTotal;
			}
			grandTotal = grandTotal + lineTax;
			System.out.println(theProduct.getBarCode() + "\t" + itemCount + "\t" + lineItemTotal + "\t" + lineTax);
			//more LineItems?
			System.out.println("Enter product barcode");
		    pBarCode = kb.next(); 
        }	
        // All LineItem collected, complete the invoice now
       	System.out.println(" Taxable subtotal: " + currency.format(taxableTotal));
       	System.out.println(" Untaxable subtotal: " + currency.format(untaxableTotal));
       	System.out.println(" Tax: " + currency.format(totalTax));
       	System.out.println(" Grand Total: " + currency.format(grandTotal));
       	kb.close();
	}

}
