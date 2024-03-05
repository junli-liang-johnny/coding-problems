import java.util.Arrays;

// https://leetcode.com/problems/merge-sorted-array/

public class merge2Arrays {
	void merge(int[] nums1, int m, int[] nums2, int n) {
		for (int j = 0, i = m; j < n; j++) {
			nums1[i] = nums2[j];
			i++;
		}

		Arrays.sort(nums1);
	}

	void merge2(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1; // for nums1
		int j = n - 1; // for nums2
		int k = m + n - 1; // to keep track of the ...

		while (j >= 0) {
			if (i >= 0 && nums1[i] > nums2[j]) {
				nums1[k--] = nums1[i--];
			} else {
				nums1[k--] = nums2[j--];
			}
		}
	}

	public void test() {

	}
}
