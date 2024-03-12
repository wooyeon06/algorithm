package a258709;


import util.P;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();

		//Object obj = solution.solution(new int[][]{{1, 2, 3, 4, 5, 6}, {3, 3, 3, 3, 4, 4}, {1, 3, 3, 4, 4, 4}, {1, 1, 4, 4, 5, 5}});
		//Object obj2 = solution.solution(new int[][]{{1, 2, 3, 4, 5, 6}, {2, 2, 4, 4, 6, 6}});
		//Object obj3 = solution.solution(new int[][]{{40, 41, 42, 43, 44, 45}, {43, 43, 42, 42, 41, 41}, {1, 1, 80, 80, 80, 80}, {70, 70, 1, 1, 70, 70}});


		Object obj4 = solution.solution(new int[][]{
				{90,91,92,93,94,95}, {90,91,92,93,94,95},
				{90,91,92,93,94,95}, {90,91,92,93,94,95},
				{90,91,92,93,94,95}, {90,91,92,93,94,95},
				{90,91,92,93,94,95}, {90,91,92,93,94,95},
				{90,91,92,93,94,95}, {90,91,92,93,94,95}
				});

		//P.arr(obj);
		//P.arr(obj2);
		//P.arr(obj3);
		P.arr(obj4);

		
	}

}
