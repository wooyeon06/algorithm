package lv3.a72415;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		//Solution s = new Solution();
		Object obj = s.solution(
				//new int[][]{{1,0,0,3},{2,0,0,0},{0,0,0,2},{3,0,1,0}},	1,	0
				//new int[][]{{3,0,0,2},{0,0,1,0},{0,1,0,0},{2,0,0,3}},	0,	1
				//new int[][]{{0, 0, 0, 1}, {0, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 0, 0}}, 0, 3
				//new int[][]{{1, 5, 0, 2}, {6, 4, 3, 0}, {0, 2, 1, 5}, {3, 0, 6, 4}}, 0, 0
				// new int[][]{{1,0,0,0},{0,0,0,0},{0,0,0,1},{0,0,0,0}},	1,	0
				new int[][]{{0, 0, 0, 0}, {0, 0, 2, 0}, {0, 0, 0, 0}, {0, 0, 2, 0}}, 1, 2
				);

		System.out.println(obj);
	}

}
