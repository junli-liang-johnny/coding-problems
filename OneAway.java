
/**
 * There are three types of edits that can be performed on strings: insert a
 * character, remove a character, or replace a character.
 * Given atwo strings, write a function to check if they are one edit or zero
 * edits away
 */
public class OneAway {
	public static void main(String[] args) {

	}

	/**
	 * insert length + 1
	 * remove length -1
	 * replace same length
	 */
	public boolean test(String str1, String str2) {
		if (str1.length() == str2.length() + 1) { // insert ?
			return isInsertion(str1, str2);
		} else if (str1.length() == str2.length() - 1) { // remove
			return isRemoval(str1, str2);
		} else { // replace ?
			return isReplacement(str1, str2);
		}
	}

	boolean isInsertion(String str1, String str2) {
		int i = 0, j = 0;

		while (i < str1.length() && j < str2.length()) {
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

	boolean isRemoval(String str1, String str2) {

	}

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
