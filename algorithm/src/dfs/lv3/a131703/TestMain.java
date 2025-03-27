package dfs.lv3.a131703;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		Object obj = s.solution(

				new int[][]{{0, 1, 0, 0, 0}, {1, 0, 1, 0, 1}, {0, 1, 1, 1, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}}
				//new int[][]{{ 1, 0, 0, 0}, { 0, 1, 0, 1}, { 1, 1, 1, 0}, { 0, 1, 1, 0}, { 1, 0, 1, 0}}
				,
				new int[][]{{0, 0, 0, 1, 1}, {0, 0, 0, 0, 1}, {0, 0, 1, 0, 1}, {0, 0, 0, 1, 0}, {0, 0, 0, 0, 1}}
				//new int[][]{{ 0, 0, 1, 1}, { 0, 0, 0, 1}, { 0, 1, 0, 1}, { 0, 0, 1, 0}, { 0, 0, 0, 1}}

		);

		System.out.println(obj);


	}
}

