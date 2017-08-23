import java.util.Scanner;
import static java.lang.Math.abs;

/**
 * This Class calculates the square root and cubic root of an entered number.
 * it is following the rules of the newton raphson by approximate to the value
 * it is on 6 digits exact after the decimal point
 * It uses the libraries Scanner and Math.abs
 * 
 * @author Theresa Steinmetz
 *
 */
public class NewtonCalculater {

	/**
	 * This method calculates the square root of the entered value
	 * by using the library-function Math.abs
	 * 
	 * @param number
	 * @return
	 */
	public static double getSquareRoot(double number) {
		double q = ((number) / 2);
		while (Math.abs(number - (q * q)) >= 0.000001) {
			q = ((q + number / q) / 2);
		}
		return q;
	}

	/**
	 * This method calculates the cubic root of the entered value
	 * by using the library-function Math.abs
	 * 
	 * @param number
	 * @return
	 */
	public static double getCubicRoot(double number) {
		double q = ((number) / 3.0);
		while (Math.abs(number - (q * q * q)) >= 0.000001) {
			q = ((((2.0 * q) + (number /q /q)) / 3.0));
		}		
		return q;
	}

	/**
	 * The user is instructed to give an input, it should be a whole-number
	 * 2 Methods get invoked for the square root and the cubic root
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a Number: ");
		double enteredNumber = scan.nextDouble();
		System.out.println(enteredNumber);
		scan.close();

		System.out.println("The square root of " + enteredNumber + " is " + getSquareRoot(enteredNumber));

		System.out.println("The cubic root of " + enteredNumber + " is " + getCubicRoot(enteredNumber));

	}
}
