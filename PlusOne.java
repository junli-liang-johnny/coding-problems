import java.util.Arrays;

// https://leetcode.com/problems/plus-one/description/

public class PlusOne {
	int[] solution(int[] digits) {
		int increment = 1;
		int[] res = new int[digits.length];

		for (int i = 0; i < digits.length; i++) {
			if (i == digits.length - 1) {
				if (digits[i] + 1 == 10) {
					res[i] = 0;
					res[i - 1] = digits[i - 1] + 1;
				} else {
					res[i] = digits[i] + 1;
				}

			} else {
				res[i] = digits[i];
			}
		}

		return res;
	}

	int[] solution1(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i]++;
				return digits;
			}

			digits[i] = 0;
		}

		digits = new int[digits.length + 1];
		digits[0] = 1;
		return digits;
	}

	public void test() {
		System.out.println(Arrays.toString(solution1(new int[] { 1, 2, 3 })));
		System.out.println(Arrays.toString(solution1(new int[] { 4, 3, 2, 1 })));
		System.out.println(Arrays.toString(solution1(new int[] { 9 })));
	}
}
