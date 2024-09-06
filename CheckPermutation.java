import java.util.HashMap;
import java.util.Arrays;

/**
 * given two strings, write a method to decide if one is a permutation of the
 * other
 */
public class CheckPermutation {
	public static void main(String[] args) {

	}

	/**
	 * Sort and compare
	 * Time complexity analysis:
	 * 1. convert strings to character arrays: converting the strings into character
	 * arrays involves iterating through each character in the string, which takes
	 * O(n) time, where n is th length of the string
	 * 
	 * 2. Sorting the character arrays: sorting the character arrays is the most
	 * expensive operation in this approach. The time complexity of sorting
	 * algorithms like Arras.sort() in Java (which typically uses a variant of the
	 * Timsort algorithm for objects) is O(nlog n), where n is the number of
	 * characters in the string.
	 * 
	 * 3. comparing the sorted arrays: once the strings are sorted, comparing the
	 * two sorted arrays involves checking each character in both arrays. This step
	 * takes O(n) time.
	 */
	public boolean test(String string1, String string2) {
		if (string1.length() != string2.length()) {
			return false;
		}

		char[] ary1 = string1.toCharArray();
		char[] ary2 = string2.toCharArray();

		Arrays.sort(ary1);
		Arrays.sort(ary2);

		return Arrays.equals(ary1, ary2);
	}

	/*
	 * count character frequency and compare using hash table
	 */
	public boolean test2(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}

		HashMap<Character, Integer> map1 = new HashMap<>();

		for (char c : str1.toCharArray()) {
			map1.put(c, map1.getOrDefault(c, 0) + 1);
		}

		for (char c : str2.toCharArray()) {
			if (!map1.containsKey(c) || map1.get(c) == 0) {
				return false;
			}

			map1.put(c, map1.get(c) - 1);
		}

		return true;
	}
}
