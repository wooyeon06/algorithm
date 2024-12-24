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
				new int[][] {{0, 0, 0, 1, 1},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}}
		);

		System.out.println(obj);


	}
}


/////////// A >
