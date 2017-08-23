import java.util.Scanner;

/**
 * Checks the validation of a entered password
 * 
 * @author Theresa Steinmetz
 *
 */
public class PasswordChecker {

	/**
	 * Validation of the password:
	 * Section 1, determines the single signs of the password
	 * Section 2, tests the input on the conditions of a valid password which are:
	 * at least one capital letter, one small letter, two numbers, one special char and
	 * in between the first and the last letter should be a number or special char
	 * also the password length should be minimum 8 letters
	 * 
	 * @param the entered password
	 */
	public static void passwordValidation(String password) {

		int letter = 0;
		int counterCapital = 0;
		int counterMinuscule = 0;
		int counterSpecialCharacter = 0;
		int counterNumber = 0;
		int counterInBetweenNumber = 0;
		int counterInBetweenSpecialChar = 0;
		
		//Section 1
		for (int i = 0; i < password.length(); i++) {
			letter = password.charAt(i); 				

			if (letter >= 65 && letter <= 90) {
				counterCapital++;						
			}
			if (letter >= 97 && letter <= 122) {
				counterMinuscule++;						
			}
			if ((letter >= 33 && letter <= 47) || (letter >= 58 && letter <= 64)) {
				counterSpecialCharacter++;
			}
			if (letter >= 48 && letter <= 57) {
				counterNumber++;
			}
			if (((i > 0) && (i < (password.length() - 2))) && (letter >= 48 && letter <= 57)) {
				counterInBetweenNumber++;
			}
			if (((i > 0) && (i < (password.length() - 2)))
					&& ((letter >= 33 && letter <= 47) || (letter >= 58 && letter <= 64))) {
				counterInBetweenSpecialChar++;
			}
		}
		
		//Section 2
		if (counterCapital < 1) {
			System.out.println("The password does not contain at least 1 capital letters.");
		}
		if (counterMinuscule < 1) {
			System.out.println("The password does not contain at least 1 minuscule letters.");
		}
		if (counterSpecialCharacter < 1) {
			System.out.println("The password does not contain at least 1 special character.");
		}
		if (counterNumber < 2) {
			System.out.println("The password does not contain at least 2 numbers.");
		}
		if ((counterCapital < 1) && (counterMinuscule < 1)) {
			System.out.println("The password does not contain at least 2 letters.");
		}
		if ((counterInBetweenNumber < 1) && (counterInBetweenSpecialChar < 1)) {
			System.out.println(
					"The password does not contain at least one special letter or one number in the middle of the password.");
		}
		if (password.length() < 8) {
			System.out.println("The password must be at least 8 characters long.");
		}
		if ((counterCapital >=1)
			&&(counterMinuscule >= 1)
				&&(counterSpecialCharacter >= 1)
					&&(counterNumber >= 2)
						&&((counterCapital >= 1) && (counterMinuscule >= 1))
							&&((counterInBetweenNumber >= 1) && (counterInBetweenSpecialChar >= 1))&&(password.length() >= 8)) {
			System.out.println("The password compiles with the rules.");
		}
	}

	/**
	 * The User is asked to enter a password which get checked by the method passwordValidation on it's correctness.
	 * in case of a violation of the terms of a correct password, the user gets informed which rule he or she didn't considered.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String input = scan.next();
		System.out.println("You entered the following password: " + input);
		scan.close();

		passwordValidation(input);
	}
}