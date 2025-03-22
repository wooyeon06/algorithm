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
				//new int[][]{{0,3,3,0},{3,2,2,3},{0,3,2,0},{0,3,3,3}}
				new int[][]{{0, 1, 3, 0},{1, 2, 0, 0},{3, 0, 2, 2},{0, 2, 0, 0}}

				//new int[][]{{0,0,3,0},{0,3,3,3}}
				//new int[][]{{0,3,3,0},{3,2,2,3}}
				//new int[][]{{3,2,3},{2,2,2},{3,2,3}}
				//new int[][]{{0,2},{2,3},{2,2},{2,3},{2,2},{2,3},{2,2},{2,3}}
				//new int[][]{{3,3,3},{3,3,3},{3,3,3}}
		);

		System.out.println(obj);


	}
}


/////////// A >
