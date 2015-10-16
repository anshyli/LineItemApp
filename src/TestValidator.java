import java.util.Scanner;

public class TestValidator {
  public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choice = "y";
        while (choice.equalsIgnoreCase("y"))
        {
            // get the input from the user
            String assignment = Validator.getString(
                sc, "Enter assignment: ");
            int grade = Validator.getInt(
                sc, "Enter grade 0-100:     ", 0, 1000);
            
            // see if the user wants to continue
            choice = Validator.getString(
                sc, "Another assignment? (y/n): ");
            System.out.println();
        }
  }
}