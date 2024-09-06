import java.util.HashMap;

/**
 * implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures
 */
public class DetermineUniqueString {
	public static void main(String[] args) {

	}

	public boolean test(String string) {
		HashMap<Character, Character> map = new HashMap<>();

		for (int i = 0; i < string.length(); i++) {
			Character c = string.charAt(i);
			if (map.containsKey(c)) {
				return false;
			}
			map.put(c, c);
		}

		return true;
	}

	// 
	public boolean test2(String string) {
		for (int i = 0; i < string.length(); i++) {
			for (int j = i + 1; j < string.length(); j++) {
				if (string.charAt(i) == string.charAt(j)) {
					return false;
				}
			}
		}

		return true;
	}
}
