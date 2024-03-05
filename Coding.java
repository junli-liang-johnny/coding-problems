import java.util.Arrays;

public class Coding {
	public static void main(String args[]) {

		Question1();

		Question5();

		int[] res = new TwoSum().solution3(new int[] { 3, 2, 4 }, 6);
		System.out.println("twoSum: " + Arrays.toString(res));

		new AddTwoNumbers().test();

		new RemoveDuplicatesFromSortedArray().test();

		new SearchInsertPosition().test();

		new PlusOne().test();

		new RemoveDuplicatesFromSortedList().test();
	}

	public static void Question1() {
		int[] nums = { 2, 7, 11, 15 };
		// int target = 9;
		int cal = nums[0] + nums[1];

		System.out.println("num[0] + num[1] = " + cal);
	}

	public static void Question3() {
		int[][] input = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };

		System.out.println(new MergeIntervals().merge(input));
	}

	public static void Question5() {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

		int res = new MaximumSubarray().findMax(nums);

		System.out.println("Question5 - res: " + res);
	}
}