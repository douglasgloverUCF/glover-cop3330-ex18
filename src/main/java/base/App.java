/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Douglas Glover
 */
package base;
import java.util.Scanner;
/*
You’ll often need to determine which part of a program is run based on user input or other events.

Create a program that converts temperatures from Fahrenheit to Celsius or from Celsius to Fahrenheit. Prompt for the starting temperature. The program should prompt for the type of conversion and then perform the conversion.

The formulas are

C = (F − 32) × 5 / 9
and

F = (C × 9 / 5) + 32

Example Output

Press C to convert from Fahrenheit to Celsius.
Press F to convert from Celsius to Fahrenheit.
Your choice: C
Please enter the temperature in Fahrenheit: 32
The temperature in Celsius is 0.

Constraints

Ensure that you allow upper or lowercase values for C and F.
Use as few output statements as possible and avoid repeating output strings.

Challenges

Revise the program to ensure that inputs are entered as numeric values. Don’t allow the user to proceed if the value entered is not numeric.
Break the program into functions that perform the computations.
Implement this program as a GUI program that automatically updates the values when any value changes.
Modify the program so it also supports the Kelvin scale.
 */
public class App {
    Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        App myApp = new App();
        String tempSystem = myApp.getTempSystem();
        double tempValue = myApp.getTempValue(tempSystem);
        myApp.convert(tempSystem, tempValue);
    }
    String getTempSystem()
    {
        System.out.print("""
        Press C to convert from Fahrenheit to Celsius.
        Press F to convert from Celsius to Fahrenheit.
        Your choice:\s""");
        String input = in.nextLine();
        String tempSystem = null;
        char c = input.charAt(0);
        if (c == 'C' || c == 'c')
            tempSystem = "Fahrenheit";
        else if (c == 'F' || c == 'f')
            tempSystem = "Celsius";
        else
            System.exit(-1);
        return tempSystem;
    }
    double getTempValue(String tempSystem)
    {
        System.out.print("Please enter the temperature in " + tempSystem + ": ");
        return in.nextDouble();
    }
    void convert(String tempSystem, double tempValue)
    {
        double temperature;
        String newTempSystem;
        if (tempSystem.equals("Fahrenheit"))
        {
            temperature = (tempValue - 32) * 5 / 9;
            newTempSystem = "Celsius";
        }
        else
        {
            temperature = (tempValue * 9 / 5) + 32;
            newTempSystem = "Fahrenheit";
        }

        System.out.printf("The temperature in %s is %.0f.", newTempSystem, temperature);
    }
}
