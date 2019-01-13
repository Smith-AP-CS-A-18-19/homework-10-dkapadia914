import java.util.ArrayList;

public class Homework10 {
private int[][] array;
private int row;
private int col;
	/* Finish the constructor and create any necessary instance
	 * variables. The constructor should create and save a
	 * 2D array of int values with the designated rows and
	 * columns
	 */
	public Homework10(int rows, int cols) {
		array = new int[rows][cols];
		row = rows;
		col = cols;
	}

	/* Fill the stored array with increasing values. The
	 * value at [0, 0] should be n, the value at [0, 1]
	 * should be n + 1, and so on, filling the array in
	 * row major order. Return the filled array
	 */
	public int[][] problem1(int n) {
		int number = n;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				array[i][j] = number;
				number++;
			}
		}
		return array;
	}

	/* Return row r of the stored array
	 */
	public int[] problem2(int r) {
		int[] array1 = new int[col];
		for (int i = 0; i < col; i++) {
			array1[i] = array[r][i];
		}
		return array1;
	}

	/* Find and return the sum of the indicated cell and its
	 * four cardinal neighbors (up, down, left, right). Ensure
	 * you account for the possiblity of the cell not having one
	 * or more neighbors
	 */
	public int problem3(int r, int c) {
		int upper;
		int lower;
		int right;
		int left;
		if ((c - 1) < 0) {
			left = 0;
		} else {
			left = array[r][c - 1];
		}
		if ((r - 1) < 0) {
			upper = 0;
		} else {
			upper = array[r - 1][c];
		}
		if ((r + 1) >= array.length) {
			lower = 0;
		} else {
			lower = array[r + 1][c];
		}
		if ((c + 1) >= array[0].length) {
			right = 0;
		} else {
			right = array[r][c + 1];
		}
		int cell = array[r][c];
		int sum = upper + lower + right + left + cell;
		return sum;
	}

	/* Create and return an ArrayList that contains the
	 * elements from the indicated column
	 */
	public ArrayList<Integer> problem4(int c) {
		ArrayList<Integer> four = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			int num = array[i][c];
			four.add(num);
		}
		return four;
	}

	/* Calculate and return the sum of the integers in
	 * the supplied ArrayList
	 */
	public int problem5(ArrayList<Integer> aList) {
		int sum = 0;
		for (int i : aList) {
			sum += i;
		}
		return sum;
	}

	public static void main(String[] args) {
		boolean passed = true;
		Homework10 hw10 = new Homework10(5, 7);

		int[][] arr2D = hw10.problem1(4);
		if (arr2D[3][3] == 28) {
			System.out.println("Pass 1");
		} else {
			System.out.println("Fail 1");
			passed = false;
		}

		int[] arr1D = {32, 33, 34, 35, 36, 37, 38};
		int[] prob2 = hw10.problem2(4);
		boolean p2p = true;
		if (prob2.length != arr1D.length) {
			p2p = false;
		} else {
			for (int i = 0; i < prob2.length; i++) {
				if (prob2[i] != arr1D[i]) {
					p2p = false;
				}
			}
		}
		if (p2p) {
			System.out.println("Pass 2");
		} else {
			System.out.println("Fail 2");
			passed = false;
		}

		if (hw10.problem3(2, 2) != 100) {
			System.out.println("Fail 3.1");
			passed = false;
		} else if (hw10.problem3(4, 0) != 90) {
			System.out.println("Fail 3.2");
			passed = false;
		} else {
			System.out.println("Pass 3");
		}

		ArrayList<Integer> al = hw10.problem4(4);
		if (al.get(2) == 22) {
			System.out.println("Pass 4");
		} else {
			System.out.println("Fail 4");
			passed = false;
		}

		int p5 = hw10.problem5(al);
		if (p5 == 110) {
			System.out.println("Pass 5");
		} else {
			System.out.println("Fail 5");
			passed = false;
		}

		if (passed) {
			System.out.println("All Pass");
		} else {
			System.out.println("Fail");
		}

	}
}
