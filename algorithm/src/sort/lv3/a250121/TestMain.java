package sort.lv3.a250121;

public class TestMain {

	public static void main(String[] args) {
		Solution s = new Solution();
		Object obj = s.solution(
				new int[][]{{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}
						,{1, 20300104, 100, 80}
						,{1, 20300104, 100, 60}
						,{1, 20300104, 100, 70}
						,{1, 20300104, 100, 100}
						,{1, 20300104, 100, 20}
				}, "date",	20300501,	"remain"
		);

		int[][] arr = (int[][]) obj;
	}

}
