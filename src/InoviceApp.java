import java.util.Scanner;

public class InoviceApp {
	public static Invoice invoice = new Invoice();
	final static boolean taxable = true;
	public static void main(String args[]){
		System.out.println("Welcome to the invoice application .\n");
		getLineItems();
		displayInvoice();
	}
	public static void getLineItems(){
		Scanner sc = new Scanner(System.in);
		String choice ="y";
		while (choice.equalsIgnoreCase("y"))
		{//get the input from the user
			String 	productCode = Validator.getString(sc, "Enter product code: ");
			int quantity = Validator.getInt(sc,"Enter quantity: ",0,1000);
			
			Product product = ProductDB.getProduct(productCode);
			invoice.addItem(new LineItem(product,quantity, taxable));
			choice =Validator.getString(sc, "Another line item? (y/n):");
			System.out.println();
			
		}
	}
	public static void displayInvoice(){
		System.out.println("Code\tDescription\t\t\tprice\tQty\tTotal");
		System.out.println("----\t-----------\t\t\t-----\t---\t-----");
		for (LineItem lineItem : invoice.getLineItems()){
			Product product=lineItem.getTheProduct();
			String s = product.getBarCode()
			+"\t" + product.getDescription()
			+"\t\t" + product.getFormattedPrice(product.getUnitPrice())
			+"\t" + lineItem.getQuantity()
			+"\t" + lineItem.getFormattedTotal();
		System.out.println(s);
			
		}
		System.out.println("\n\t\t\t\t\tInvoice total:\t" +invoice.getFormattedTotal()+"\n");
	}

}
