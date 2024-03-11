package a258711;


import util.P;

public class TestMain {


	public static void main(String[] args) {

		int[][] i1 = new int[][]{{2, 3}, {4, 3}, {1, 1}, {2, 1}};
		int[][] i2 = new int[][]{{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}};

		Solution solution = new Solution();
		Object obj = solution.solution(
					i2
				);


		P.arr(obj);

	}

}
