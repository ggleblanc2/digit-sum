package com.ggl.testing;

import java.util.ArrayList;
import java.util.List;

public class DigitSum {

	public static void main(String[] args) {
		DigitSum ds = new DigitSum();
		ds.processRange(100, 1000000, 19);
	}
	
	public void processRange(int minimum, int maximum, int matchSum) {
		List<Integer> values = calculateValues(minimum, maximum, matchSum);
		displayResults(values, minimum, maximum, matchSum);
	}
	
	private List<Integer> calculateValues(int minimum, int maximum, int matchSum) {
		List<Integer> values = new ArrayList<>();
		
		for (int index = minimum; index <= maximum; index++) {
			int sum = sumDigits(index);
			if (sum == matchSum) {
				values.add(Integer.valueOf(index));
			}
		}
		
		return values;
	}
	
	private int sumDigits(int value) {
		int sum = 0;
		
		while (value > 0) {
			int remainder = value % 10;
			sum += remainder;
			value = value / 10;
		}
		
		return sum;
	}
	
	/**
	 * This method prints out a small group of the first {@code groupCount} values,
	 * then an ellipses, then the last {@code groupCount} values. The
	 * {@code groupCount} is defined in the method.
	 * <p>
	 * If there are fewer values than two groups of {@code groupCount} values, then
	 * all the values are printed as one group.
	 * 
	 * @param values   - {@code List<Integer>} values whose digits sum to the
	 *                 desired sum
	 * @param minimum  - Smallest integer to test
	 * @param maximum  - Largest integer to test
	 * @param matchSum - Desired sum of digits
	 */
	private void displayResults(List<Integer> values, int minimum, int maximum, 
			int matchSum) {
		int groupCount = 10;
		int size = values.size();
		int limit = Math.min(size, groupCount);
		System.out.println("  Integer  Sum");
		displayValueGroup(values, 0, limit, matchSum);
		
		if (size < groupCount) {
			// Skip printing last group
		} else if (size < groupCount + groupCount) {
			displayValueGroup(values, groupCount, size, matchSum);
		} else {
			System.out.println("      ...");
			int start = size - groupCount;
			displayValueGroup(values, start, size, matchSum);
		}
		
		System.out.println(displayTotal(minimum, maximum, matchSum, size));
	}

	private void displayValueGroup(List<Integer> values, int start, int limit, int matchSum) {
		for (int index = start; index < limit; index++) {
			System.out.println(displayNumber(values.get(index), matchSum));
		}
	}
	
	private String displayNumber(int index, int sum) {
		String indexString = String.format("%,9d", index);
		String sumString = String.format("%3d", sum);
		return indexString + "  " + sumString;
	}
	
	private String displayTotal(int minimum, int maximum, int matchSum, int count) {
		String countString = String.format("%,d", count);
		String minimumString = String.format("%,d", minimum);
		String maximumString = String.format("%,d", maximum);
		return "There were " + countString + " integers whose digits " +
				"sum to " + matchSum + " between the integers " + minimumString + 
				" and " + maximumString + ".";
	}

}
