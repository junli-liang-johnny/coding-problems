
/**
 * Wrtie an algorithm such that if an element in an M x N matrix is 0, its
 * entire row and column are set to 0
 */
import java.util.Arrays;

public class ZeroMatrix {
	public static void main(String[] args) {
		ZeroMatrix zm = new ZeroMatrix();

		// Test cases
		int[][][] testCases = {
				{
						{ 1, 2, 3 },
						{ 4, 0, 6 },
						{ 7, 8, 9 }
				},
				{
						{ 1, 2, 0 },
						{ 4, 5, 6 },
						{ 7, 8, 9 }
				},
				{
						{ 1, 2, 3 },
						{ 4, 5, 6 },
						{ 0, 8, 9 }
				},
				{
						{ 0, 2, 3 },
						{ 4, 5, 6 },
						{ 7, 8, 9 }
				},
				{
						{ 1, 2, 3 },
						{ 4, 5, 6 },
						{ 7, 8, 0 }
				}
		};

		// Expected results
		int[][][] expectedResults = {
				{
						{ 1, 0, 3 },
						{ 0, 0, 0 },
						{ 7, 0, 9 }
				},
				{
						{ 0, 0, 0 },
						{ 4, 5, 0 },
						{ 7, 8, 0 }
				},
				{
						{ 0, 2, 3 },
						{ 0, 5, 6 },
						{ 0, 0, 0 }
				},
				{
						{ 0, 0, 0 },
						{ 0, 5, 6 },
						{ 0, 8, 9 }
				},
				{
						{ 1, 2, 0 },
						{ 4, 5, 0 },
						{ 0, 0, 0 }
				}
		};

		// Run test cases
		for (int i = 0; i < testCases.length; i++) {
			int[][] input = testCases[i];
			int[][] expected = expectedResults[i];
			zm.test(input);

			System.out.println("Test case " + (i + 1) + ":");
			System.out.println("Expected:");
			printMatrix(expected);
			System.out.println("Result:");
			printMatrix(input);
			System.out.println(Arrays.deepEquals(input, expected) ? "PASS" : "FAIL");
			System.out.println();
		}
	}

	private static void printMatrix(int[][] matrix) {
		for (int[] row : matrix) {
			System.out.println(Arrays.toString(row));
		}
	}

	// O(M*N) operation in place
	public void test(int[][] matrix) {
		Boolean[] rows = new Boolean[matrix.length];
		Boolean[] cols = new Boolean[matrix[0].length];

		for (int n = 0; n < matrix.length; n++) {
			for (int c = 0; c < matrix[n].length; c++) {
				if (matrix[n][c] == 0) {
					rows[n] = true;
					cols[c] = true;
				}
			}
		}

		for (int n = 0; n < rows.length; n++) {
			if (rows[n] != null && rows[n])
				setRowToZero(matrix, n);
		}

		for (int c = 0; c < cols.length; c++) {
			if (cols[c] != null && cols[c])
				setColumnToZero(matrix, c);
		}
	}

	public void setRowToZero(int[][] matrix, int rowIndex) {
		for (int c = 0; c < matrix[0].length; c++) {
			matrix[rowIndex][c] = 0;
		}
	}

	public void setColumnToZero(int[][] matrix, int colIndex) {
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][colIndex] = 0;
		}
	}
}
