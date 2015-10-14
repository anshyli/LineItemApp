
import java.text.NumberFormat;

public class Product {
	protected static int count = 0;
	private String barCode;
	private String category;
	private String description;
	private double unitPrice;
	private Boolean inStock;
	
	public Product() {
		count++;
	}
	
	public Product(String barCode) {
		super();
		this.barCode = barCode;
	}
	
	public Product (String barCode, String category, String description, double unitPrice, Boolean inStock) {
		super();
		this.barCode = barCode;
		this.category = category;
		this.description = description;
		this.unitPrice = unitPrice;
		this.inStock = inStock;
	}
	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Product.count = count;
	}
	
	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getFormattedPrice(double unitPrice) {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		return currency.format(unitPrice);
	}

	public Boolean getInStock() {
		return inStock;
	}

	public void setInStock(Boolean inStock) {
		this.inStock = inStock;
	}

	@Override
	public String toString() {
		return  " BarCode: 		" + barCode + "\n" +
					"Category:			" + category + "\n" +
					"Description:		" + description + "\n" +
					"Unit Price: 		" + this.getFormattedPrice(unitPrice) + "\n" +
					"In Stock Flag:    " + inStock + "\n";
	}
}