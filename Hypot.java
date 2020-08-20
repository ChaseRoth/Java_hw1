import java.util.Scanner;

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
                If on the first side a valid number is given and then is followed by a space and text, the text will
                be used when asking for side 2.          
                If on the last side when giving input, if a number is given and is then followed by a space. All
                text after that space will be ignored ex. (353 I will be ignored!)

    Date:       8/20/2020
    Author:     Chase Roth
    Version:    1.0
*/
public class Hypot {
    // Arguments were given in a invalid format
    static final int EXIT_INVALID_ARG_FORMAT = 1;
    // Numeric code for invlaid argument type given (not numeric)
    static final int EXIT_INVALID_ARG_TYPE = 2;    
    // Number of arguments our program will take in the console
    static final byte ARGUMENT_COUNT = 2;

    public static void main(String [] args) {       
        double hypotenuse;
        // Contains both our 'a' side and 'b' side of the right triangle
        double[] sides = new double[ARGUMENT_COUNT];        
        // Scanner for getting user input
        Scanner scanner = new Scanner(System.in);
        
        // Collecting all arguments
        for (byte i = 0; i < ARGUMENT_COUNT; i++) {
            System.out.print("Side " + (i + 1) + " length: ");
            // Need to get the line because other wise people can hide parameters behind spaces
            // This become even more of a pain since Scanner doesn't have a peek function
            String nextStr = scanner.nextLine();           

            // Parse given argument
            try {
                sides[i] = Double.parseDouble(nextStr);
            }
            catch (NumberFormatException nfe) {
                System.out.println("Invalid argument type given. The argument " + nextStr + " is not a number.");
                System.exit(EXIT_INVALID_ARG_TYPE);
            }
        }

        // At this point we are done getting input so close the scanner
        scanner.close();                                
            
        hypotenuse = Math.sqrt(((sides[0] * sides[0]) + (sides[1] * sides[1])));
        System.out.print("The hypotenuse of a right triangle with sides of " + sides[0]  + " and " + sides[1] + " is " + hypotenuse);
    }
}