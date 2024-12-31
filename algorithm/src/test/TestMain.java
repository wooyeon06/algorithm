package test;

import java.util.Arrays;

public class TestMain {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		int max = Arrays.stream(arr).max().orElseThrow(()->new RuntimeException());
		System.out.println(max);


	}
}
