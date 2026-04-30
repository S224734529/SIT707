package web.service;

public class MathQuestionService {

	/**
	 * Calculate Q1 result.
	 * @param number1
	 * @param number2
	 * @return
	 */

	public static Double q1Addition(String number1, String number2) {
		try {
			if (number1 == null || number2 == null || number1.trim().isEmpty() || number2.trim().isEmpty()) {
				return null;
			}
			return Double.valueOf(number1) + Double.valueOf(number2);
		} catch (NumberFormatException e) {
			return null;
		}
	}
	
	/**
	 * Calculate Q2 result.
	 * @param number1
	 * @param number2
	 * @return
	 */
	public static Double q2Subtraction(String number1, String number2) {
		try {
			if (number1 == null || number2 == null || number1.trim().isEmpty() || number2.trim().isEmpty()) {
				return null;
			}
			return Double.valueOf(number1) - Double.valueOf(number2);
		} catch (NumberFormatException e) {
			return null;
		}
	}
	
	/**
	 * Calculate Q3 result.
	 * @param number1
	 * @param number2
	 * @return
	 */
	
	public static Double q3Multiplication(String number1, String number2) {
		try {
			if (number1 == null || number2 == null || number1.trim().isEmpty() || number2.trim().isEmpty()) {
				return null;
			}
			return Double.valueOf(number1) * Double.valueOf(number2);
		} catch (NumberFormatException e) {
			return null;
		}
	}
}
