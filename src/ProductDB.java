import java.sql.Connection;
import java.sql.DriverManager;

public class ProductDB
{
    // a static variable
    private static Connection connection;    

    // the static initialization block
    static
    {
        try
        {
            String url = 
                "jdbc:mysql://localhost:3306/MurachDB";
            String user = "root";
            String password = "sesame";
            connection = DriverManager.getConnection(
                url, user, password);
         }
        catch (Exception e)
        {
           System.err.println(
               "Error connecting to database.");
        }
   }

   // static methods that use the Connection object
   public static Product get(String code){
	    Product aProduct = new Product(); 
		return aProduct;
	}
   public static boolean add(Product product){
	return false;}
   public static boolean update(Product product){
	return false;}
   public static boolean delete(String code){
	return false;}
   public static Product getProduct(String productCode) {
       // create the Product object
       Product p = new Product();

       // fill the Product object with data
       p.setCode(productCode);
       if (productCode.equalsIgnoreCase("java"))
       {
           p.setDescription("Murach's Beginning Java");
           p.setPrice(49.50);
       }
       else if (productCode.equalsIgnoreCase("jsps"))
       {
           p.setDescription(
               "Murach's Java Servlets and JSP");
           p.setPrice(49.50);
       }
       else if (productCode.equalsIgnoreCase("mcb2"))
       {
           p.setDescription("Murach's Mainframe COBOL");
           p.setPrice(59.50);
       }
       else
       {
           p.setDescription("Unknown");
       }
       return p;
   }

}
