/**
 * Implement a method to perform basic string compression using the counts of
 * repeated characters. For example, ths string aabccccaaa would become
 * a2b1c5a3.
 * If the "compressed" string would not become smaller than the original string,
 * your method should return the original string. You can assume the string has
 * only uppercase and lowercase letters.
 */
public class StringCompression {
	public static void main(String[] args) {
		StringCompression sc = new StringCompression();

		// Test cases
		String[][] testCases = {
				{ "aabccccaaa", "a2b1c4a3" }, // normal case
				{ "abc", "abc" }, // all unique characters
				{ "aa", "a2" }, // two same characters
				{ "a", "a" }, // single character
				{ "", "" } // empty string
		};

		// Run test cases
		for (String[] testCase : testCases) {
			String input = testCase[0];
			String expected = testCase[1];
			String result = sc.test2(input);

			System.out.println("Test case: " + input);
			System.out.println("Expected: " + expected + ", Result: " + result);
			System.out.println(result.equals(expected) ? "PASS" : "FAIL");
			System.out.println();
		}
	}

	/**
	 * O(n*2) solution
	 */
	public String test(String str) {
		String result = "";
		int count = 0;

		for (int i = 0; i < str.length(); i++) {
			count++;

			if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				result += "" + str.charAt(i) + count;
				count = 0;
			}
		}

		return result.length() > str.length() ? str : result;
	}

	/**
	 * solution using StringBuilder
	 */
	public String test2(String str) {
		StringBuilder compressed = new StringBuilder();
		int count = 0;

		for (int i = 0; i < str.length(); i++) {
			count++;

			if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressed.append(str.charAt(i));
				compressed.append(count);
				count = 0;
			}
		}

		return compressed.length() <= str.length() ? compressed.toString() : str;
	}
}
