package temp;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		Object obj = s.solution(
				//6, 4, new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}}
				6, 4, new int[][]{{1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}}
		);

		System.out.println(obj);


	}
}


/////////// A >
