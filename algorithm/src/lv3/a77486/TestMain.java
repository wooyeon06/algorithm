package lv3.a77486;

import util.P;

import java.util.Arrays;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		Object obj = s.solution(
				new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
				new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
				new String[]{"young", "john", "tod", "emily", "mary"},
				new int[]{12, 4, 2, 5, 10}
				);

		if(obj.getClass().isArray()) {
			P.arr(obj);
		} else {
			System.out.println(obj);
		}
	}

}
