import java.util.Scanner;

public class Validator
{
    public static String getString(
    Scanner sc, String prompt) {
        System.out.print(prompt);
        String s = sc.next();  // read the user entry
        sc.nextLine();         // discard any other data
        return s;
    }

    public static int getInt(Scanner sc, String prompt)
    {
        int i = 0;
        boolean isValid = false;
        while (isValid == false)
        {
            System.out.print(prompt);
            if (sc.hasNextInt())
            {
                i = sc.nextInt();
                isValid = true;
            }
            else
            {
                System.out.println(
                    "Error! Invalid integer value. " +
                    "Try again.");
            }
            sc.nextLine();  // discard any other 
        }
        return i;
    }
    public static double getDouble(
    Scanner sc, String prompt) {
        double d = 0;
        boolean isValid = false;
        while (isValid == false) {
            System.out.print(prompt);
            if (sc.hasNextDouble())
            {
                d = sc.nextDouble();
                isValid = true;
            }
            else
            {
                System.out.println(
                    "Error! Invalid decimal value. " +
                    "Try again.");
            }
            sc.nextLine();  // discard any other data 
        }
        return d;
    }
    public static double getDouble(
    Scanner sc, String prompt, double min, double max) {
        double d = 0;
        boolean isValid = false;
        while (isValid == false) {
            d = getDouble(sc, prompt);
            if (d <= min)
                System.out.println(
                    "Error! Number must be greater than " + 
                    min + ".");
            else if (d >= max)
                System.out.println(
                    "Error! Number must be less than " +
                    max + ".");
            else
                isValid = true;
        }
        return d;
    }

	public static int getInt(Scanner sc, String string, int i, int j) {
		
		return 0;
	}
}

