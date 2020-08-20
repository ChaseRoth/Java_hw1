// This program will compute the hypotenuse of a right triangle
// using the Pythagorean theorem: 
//           (a*a) + (b*b) = (c*c)
// where a, b are the two shorter sides of the triangle and c is 
// the longest side.
//
// When you run the program, pass the lengths of the two shorter 
// sides of the triangle in as parameters on the command line. 
// For example:
// java Hypot 7 12
// 
// This code does contain a few errors that will be 
// detected by the compiler. 

/*
    Purpose:    Calculates the hypotenuse of a right triangle and prints results to console.

    Caveats:    If non-numeric characters are given for arguments one or two the program will exit 
                with error code 2 (EXIT_INVALID_ARG_TYPE).

    Date:       8/20/2020
    Author:     Chase Roth
    Version:    1.0
*/
public class Hypot {
    // Numeric code for invalid number of arguments
    private static final int EXIT_INVALID_NUM_ARGS = 1;
    // Numeric code for invlaid argument type given (not numeric)
    private static final int EXIT_INVALID_ARG_TYPE = 2;

    public static void main(String [] args) { 
        // Variable Initialization
        double hypotenuse;
        double d1 = 0;
        double d2 = 0;

        // Verify that two arguments were entered on the command line.
        if (args.length != 2) {
            System.out.println("You need to enter two arguments.");
            System.exit(EXIT_INVALID_NUM_ARGS);
        }

        // TryParse the provided arguments
        try {
            d1 = Double.parseDouble(args[0]);
            d2 = Double.parseDouble((args[1]));            
        }
        catch (NumberFormatException ex) {
            System.out.println("Arguments need to be numbers.");
            System.exit(EXIT_INVALID_ARG_TYPE);
        }
            
        hypotenuse = Math.sqrt(((d1 * d1) + (d2 * d2)));
        System.out.print("The hypotenuse of a right triangle with sides of " + d1  + " and " + d2 + " is " + hypotenuse);
    }
}