
public class TestMain {

	public static void main(String[] args) {
		Solution s = new Solution();
		Object obj = s.solution(
				//new int[][]{{1, 4}, {0, 0}, {2, 3}} // 3
				//new int[][]{{1, 0, 2}, {0, 0, 0}, {5, 0 ,5}, {4, 0, 3}} //7
				//new int[][]{{1, 5}, {2, 5}, {4, 5}, {3, 5}}	//0
				//new int[][]{{4, 1, 2, 3}}		//0
				new int[][]{{4, 3, 0, 0}, {5, 5, 5, 0}, {1, 0, 0, 0}, {2, 0, 0, 0}} //9
		);

	}

}
