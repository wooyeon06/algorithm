package a258712;


public class TestMain {

	public static void main(String[] args) {
		Solution solution = new Solution();

		Object obj = solution.solution(
				new String[]{"muzi", "ryan", "frodo", "neo"},
				new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"}
				);

		Object obj2 = solution.solution(
				new String[]{"joy", "brad", "alessandro", "conan", "david"},
				new String[]{"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"}
		);


		System.out.println(obj);
		System.out.println(obj2);

	}

}
