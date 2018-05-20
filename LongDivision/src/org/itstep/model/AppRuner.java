package org.itstep.model;

public class AppRuner {

	public static void main(String[] args) {
		int divider = 7;
		int div = 12345;

		String resultText = getResultText(div, divider);
		System.out.println(resultText);

	}

	private static String getResultText(int div, int divider) {
		String resultText = "";
		resultText += div + "|" + divider + "\n";

		int result = (int) (div / divider);

		resultText += getRows(result, div, divider);

		return resultText;
	}

	private static String getRows(int result, int div, int divider) {

		String resultDiv = "";
		char[] numbs = String.valueOf(div).toCharArray();

		String tempDiv = "";

		int step = 1;
		
		for (int i = 0; i < numbs.length; i++) {

			tempDiv += String.valueOf(numbs[i]);
			int numb = Integer.valueOf(tempDiv);
			
			if (numb < divider) {
				continue;
			}
			
			
			
			int tempRes = numb / divider;
			int tableRes = tempRes * divider;

			
			int necessarySpases = tempDiv.length() - String.valueOf(tableRes).length();

			if (i == 1) {
				resultDiv += getSpases(necessarySpases) + tableRes
						+ getSpases(String.valueOf(div).length() - necessarySpases - String.valueOf(tableRes).length())
						+ "+" + getMinuses(String.valueOf(result).length()) + "\n";

				resultDiv += getSpases(necessarySpases) + getMinuses(String.valueOf(tableRes).length())
						+ getSpases(String.valueOf(div).length() - necessarySpases - String.valueOf(tableRes).length())
						+ "|" + result + "\n";
				tempDiv = String.valueOf(Integer.valueOf(tempDiv) - tableRes);
				continue;
				
			} 
			
			resultDiv += getSpases(step)
					+ getSpases(necessarySpases)
					+ tempDiv + "\n"
					+ getSpases(step)
					+ getSpases(necessarySpases)
					+ tableRes + "\n"
					+ getSpases(step)
					+ getSpases(necessarySpases)
					+ getMinuses(String.valueOf(tableRes).length()) + "\n";
			
			

			tempDiv = String.valueOf(Integer.valueOf(tempDiv) - tableRes);
			step++;
			
			
		}

		return resultDiv;

	}

	private static String getSpases(int length) {
		String spases = "";
		for (int i = 1; i <= length; i++) {
			spases += " ";
		}
		return spases;
	}

	private static String getMinuses(int length) {
		String minuses = "";
		for (int i = 1; i <= length; i++) {
			minuses += "-";
		}
		return minuses;
	}

}
