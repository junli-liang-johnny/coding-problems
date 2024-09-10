import java.util.HashMap;

/**
 * Given a string, write a funciton to check if it is a permutation of a
 * palindrome. A palindrome is a word or phrase that is the same forwards and
 * backwards. A permutation is a rearrangement of letters. The palindrome does
 * not need to be limited to just dictionary words. You can ignore casing and
 * non-letter characters.
 */
public class PalindromePermutation {
	public static void main(String[] args) {

	}

	/**
	 * Normalisation: O(N) where n is the length of the string
	 * Character counting: O(n)
	 * Odd Frequency check: O(1) as it depends on the size of the alphabet
	 */
	public boolean isPalindromePermutation(String str) {
		str = str.toLowerCase().replaceAll("[^a-z]", "");

		HashMap<Character, Integer> map = new HashMap<>();

		for (char c : str.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		int oddCount = 0;
		for (int count : map.values()) {
			if (count % 2 != 0) {
				oddCount++;
			}

			if (oddCount > 1) {
				return false;
			}
		}

		return true;
	}

	public boolean test(String str) {
		if (str.length() % 2 == 0) { // if length of string is even
			HashMap<Character, Integer> map = new HashMap<>();

			for (char c : str.toCharArray()) {
				map.put(c, map.getOrDefault(c, 0) + 1);
			}

			for (char c : map.keySet()) {
				if (map.get(c) % 2 != 0) {
					return false;
				}
			}

			return true;

		} else {
			boolean odd = false;
			HashMap<Character, Integer> map = new HashMap<>();

			for (char c : str.toCharArray()) {
				map.put(c, map.getOrDefault(c, 0) + 1);
			}

			for (char c : map.keySet()) {
				if (odd)
					return false;

				if (map.get(c) % 2 != 0) {
					odd = true;
				}
			}
			return true;
		}
	}
}
