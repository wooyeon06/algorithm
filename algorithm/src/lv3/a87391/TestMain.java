package lv3.a87391;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		Object obj = s.solution(
				//2,	2,	0,	0,	new int[][]{{2,1},{0,1},{1,1},{0,1},{2,1}}
				1000000000,	5,	0,	1,	new int[][]{{3,1},{2,2},{1,1},{2,3},{0,1},{2,1}}
				//n = 1000,m = 1000 x=1,y=1 query = [[0,100001],[2,100001]]
				);

		System.out.println(obj);
	}

}
