/**
 * Given an image represented by an N x N matrix, whewre each pixel in the image
 * is represented by an integer, write a method to rotate the image by 90
 * degrees. Can you do this in place
 */

public class RotateMatrix {
	public static void main(String[] args) {
		RotateMatrix rotateMatrix = new RotateMatrix();

		int[][] matrix = {
				{ 1, 2, 3 },
				{ 4, 5, 6 },
				{ 7, 8, 9 }
		};

		rotateMatrix.test(matrix);

		// Print the rotated matrix
		for (int[] row : matrix) {
			for (int val : row) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}

	/**
	 * solution from gpt
	 * time complexity O(n*2)
	 * space complexity O(1)
	 */
	public boolean test(int[][] image) {
		int n = image.length;

		if (image.length <= 0 || image[0].length != n) {
			return false;
		}

		// step 1 transpose the matrix
		for (int row = 0; row < n; row++) {
			for (int col = row; col < n; col++) {
				int temp = image[row][col];
				image[row][col] = image[col][row];
				image[col][row] = temp;
			}
		}

		// step 2 reverse each row
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n / 2; col++) {
				int temp = image[row][col];
				image[row][col] = image[row][n - col - 1];
				image[row][n - col - 1] = temp;
			}
		}

		return true;
	}
}
