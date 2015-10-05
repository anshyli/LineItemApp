import java.text.NumberFormat;

public class Product {
	private String code;
	private String description;
	private double price;

	// declare a static variable
	private static int objectCount = 0;

	public Product() {
		// code = "";
		// description = "";
		// price = 0;
		objectCount++; // update the static variable
	}

	// get the static variable
	public static int getObjectCount() {
		return objectCount;
	}

	public double getPrice() {

		return price;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public String getFormattedPrice() {
		NumberFormat currency =
	            NumberFormat.getCurrencyInstance();
	        return currency.format(price);

	}

	public void setCode(String productCode) {
		this.code = productCode;
	}

	public void setDescription(String string) {
		this.description = string;
	}

	public void setPrice(double d) {
		this.price = d;
	}

}
