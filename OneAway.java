
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

		} else if (str1.length() == str2.length() - 1) { // remove

		} else {

		}
	}
}
