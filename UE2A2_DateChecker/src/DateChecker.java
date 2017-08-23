import java.util.Scanner;

/**
 * This class handle the validation of an entered Date compared to the Gregorian calendar
 * 
 * @author Theresa Steinmetz
 *
 */
public class DateChecker {

	/**
	 * This method checks if all the requirements are given for a valid date in sense of the Gregorian calendar
	 * 
	 * @param day
	 * @param month
	 * @param year
	 * @return a boolean
	 */
	public static boolean checkValidDate(int day, int month, int year) {
		boolean dateValidation = false;
		dateValidation = beginningOfGregorianCalendar(day, month, year);
		boolean dayAndMonthValidation = false;
		dayAndMonthValidation = checksDayAndMonth(day, month, year);
		if ((dateValidation == true) && (dayAndMonthValidation == true)) {
			System.out.println("The date value " + day + "/" + month + "/" + year + " is a correct date");
			return true;
		} else {
			System.out.println("The date value " + day + "/" + month + "/" + year + " is not correct");
			return false;
		}
	}

	/**
	 * This method check up if the entered year is a leap year,
	 * following the rules every fourth year, every hundredth not, but every fourth hundred again is a leap year.
	 * 

	 * @param year
	 * @return a boolean
	 */
	public static boolean checksleapYear(int year) {
		if (year % 4 == 0) {
			if (year % 100 == 0 && year % 400 == 0) {
				return true;
			} else {
				if (year % 100 == 0 && year % 400 != 0) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * This method checks the correct number of days in each month
	 * 
	 * @param days
	 * @param chosenMonth
	 * @param year
	 * @return a boolean
	 */
	public static boolean checksDayAndMonth(int day, int month, int year) {
		if ((month >= 1) && (month <= 12)) {
			switch (month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				if ((day < 1) || (day >= 32)) {
					return false;
				} else {
					return true;
				}

			case 4:
			case 6:
			case 9:
			case 11:
				if ((day < 1) || (day >= 31)) {
					return false;
				} else {
					return true;
				}

			case 2:
				boolean leapYear = checksleapYear(year);
				if ((day < 1) && (day >= 30)) {
					return false;
				} else if (((day >= 1) && (day <= 29)) && (leapYear == true)) {
					return true;
				} else if (((day >= 1) && (day <= 28)) && (leapYear == false)) {
					return true;
				} else {
					return false;
				}
			default:{
				;
			}
			}
		}
		return false;
	}

	/**
	 * This method controls if the entered date is in terms of the Gregorian calendar
	 * 
	 * @param day
	 * @param month
	 * @param year
	 * @return
	 */
	public static boolean beginningOfGregorianCalendar(int day, int month, int year) {
		if ((year <= 1582) && (month <= 10)) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * The user is asked to type in a date, and get in response if it is a valid date in sense of the Gregorian calendar
	 * The date consists of a integer value for the day, the month and the year
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner date = new Scanner(System.in);
		System.out.print("Enter day value:     ");
		int enteredDay = date.nextInt();
		System.out.print("Enter month value:   ");
		int enteredMonth = date.nextInt();
		System.out.print("Enter year value:  ");
		int enteredYear = date.nextInt();
		System.out.println("You entered following date: " + enteredDay + "/" + enteredMonth + "/" + enteredYear);
		date.close();
		checkValidDate(enteredDay, enteredMonth, enteredYear);
	}
}