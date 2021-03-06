import java.util.Scanner;

public class LineItemApp
{
    public static void main(String args[])
    {
        // display a welcome message
        System.out.println(
            "Welcome to the Line Item Calculator");
        System.out.println();

        Scanner sc = new Scanner(System.in);
        String choice = "y";
        while (choice.equalsIgnoreCase("y"))
        {
            // get the input from the user
            String productCode =
                Validator.getString(sc,
                "Enter product code: ");
            int quantity =
                Validator.getInt(sc,
                "Enter quantity:     ", 0, 1000);
            // get the Product object
            Product product = 
                ProductDB.getProduct(productCode);

            // create the LineItem object and set its fields
            LineItem lineItem = new LineItem();
            lineItem.setTheProduct(product);
            lineItem.setQuantity(quantity);

            // display the output
            System.out.println();
            System.out.println("LINE ITEM");
            System.out.println(
                "Code:        " + product.getBarCode());
            System.out.println(
                "Description: " + product.getDescription());
            System.out.println(
                "Price:       " + 
                product.getFormattedPrice(product.getUnitPrice()));
            System.out.println(
                "Quantity:    " + lineItem.getQuantity());
            System.out.println(
                    "Total:       " + 
                    lineItem.getFormattedTotal() + "\n");

                // see if the user wants to continue
                choice = Validator.getString(
                    sc, "Continue? (y/n): ");
                System.out.println();
            }
        }
    }

