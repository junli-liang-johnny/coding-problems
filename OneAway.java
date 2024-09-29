
/**
 * There are three types of edits that can be performed on strings: insert a
 * character, remove a character, or replace a character.
 * Given atwo strings, write a function to check if they are one edit or zero
 * edits away
 */
public class OneAway {
	public static void main(String[] args) {
		OneAway oneAway = new OneAway();

		// Test cases
		String[][] testCases = {
				{ "pale", "ple", "true" }, // remove
				{ "pales", "pale", "true" }, // insert
				{ "pale", "bale", "true" }, // replace
				{ "pale", "bake", "false" }, // more than one edit
				{ "pale", "pale", "false" } // no change
		};

		// Run test cases
		for (String[] testCase : testCases) {
			String str1 = testCase[0];
			String str2 = testCase[1];
			boolean expected = Boolean.parseBoolean(testCase[2]);
			boolean result = oneAway.test(str1, str2);

			System.out.println("Test case: " + str1 + ", " + str2);
			System.out.println("Expected: " + expected + ", Result: " + result);
			System.out.println(result == expected ? "PASS" : "FAIL");
			System.out.println();
		}
	}

	/**
	 * insert length + 1
	 * remove length -1
	 * replace same length
	 */
	public boolean test(String str1, String str2) {
		if (str1.length() < str2.length()) { // edit ?
			return isEditInsert(str1, str2);
		} else if (str1.length() > str2.length()) {
			return isEditInsert(str2, str1);
		} else { // replace ?
			return isReplacement(str1, str2);
		}
	}

	boolean isEditInsert(String str1, String str2) {
		int i = 0, j = 0;

		while (j < str2.length() && i < str1.length()) {
			if (str1.charAt(i) != str2.charAt(j)) {
				if (i != j) {
					return false;
				} else {
					j++;
				}
			} else {
				i++;
				j++;
			}
		}

		return true;
	}

	/**
	 * assume str1.lengths() == str2.length()
	 */
	boolean isReplacement(String str1, String str2) {
		int edits = 0;
		int i = 0;

		while (i < str1.length() && i < str2.length()) {
			if (str1.toCharArray()[i] != str2.toCharArray()[i]) {
				edits++;
			}

			i++;
		}

		return edits == 1;
	}
}
