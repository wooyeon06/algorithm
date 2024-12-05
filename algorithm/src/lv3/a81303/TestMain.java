package lv3.a81303;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		Object obj = s.solution(
				//8, 2, new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z"}
				8, 2, new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"}
				//8, 7, new String[]{"C","C","C","C","C","C","C", "U 2", "D 2", "Z", "D 1"}
				);

		System.out.println(obj);
	}

}
