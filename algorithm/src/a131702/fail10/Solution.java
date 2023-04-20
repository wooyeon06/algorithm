package a131702.fail10;



import java.util.*;


//0 12시
//1 3시
//2 6시
//3 9시

class Solution {
	
	int min = Integer.MAX_VALUE;
	int maxdepth = 0;
	int visit[][];
	int _visit[][];
	int copy[][];
	
    public int solution(int[][] clockHands) {
		int answer = 0;

		maxdepth = clockHands.length * clockHands[0].length;
		copy = new int[2][clockHands.length];

		
		visit = new int[clockHands.length][clockHands[0].length];

		// copy[0] = clockHands[0].clone();
		copy[0] = clockHands[0].clone();
		// copy[1] = clockHands[1].clone();
		copy[1] = clockHands[1].clone();
		
		//첫열의 최적의 해를 구한다.
		recursion(copy, 1);
		answer = min + answer;
		min = Integer.MAX_VALUE;

		for (int i = 0; i < clockHands[0].length; i++) {
			for (int k = 0; k < _visit[0][i]; k++) {
				rotate(clockHands, 0, i);
			}
			for (int k = 0; k < _visit[1][i]; k++) {
				rotate(clockHands, 1, i);
			}
		}
		
		
		//3열보다 크다면
		if(clockHands.length > 2) {
			//윗줄을 참고로 아래줄을 맞춘다
			for (int i = 1; i < clockHands.length-1; i++) {
				for (int j = 0; j < clockHands[0].length; j++) {
					if(clockHands[i][j] != 0) {
						int mk = 4-clockHands[i][j];
						for (int k = 0; k < mk; k++) {
							rotate(clockHands, i+1, j);
							answer++;
						}
						
					}
				}
			}
		}
		
        return answer;
    }
    
    
    public void recursion(int[][] clockHands, int rotateCnt) {
    	if(rotateCnt == 1 && valid1(clockHands)) {
    		min = 0;
    		return;
    	}
    	
    	if(min < rotateCnt) {
    		return;
    	}
    	
    	
    	for(int i=0 ; i<clockHands.length ; i++) {
    		for(int j=0 ; j<clockHands[0].length ; j++) {
				if(visit[i][j] < 4) {
					/////////////////rotate
	    			visit[i][j]++;
	    			rotate(clockHands, i, j);
	    			
	    			if(valid1(clockHands)) {
	    				if(rotateCnt < min) {
	    					min = rotateCnt;
	    					_visit = deepCopy(visit);
	    				}
	    			}
	    			
	   				recursion(clockHands, rotateCnt+1);
	    			
	    			/////////////////reverse rotate
	   				visit[i][j]--;
	    			_rotate(clockHands, i, j);
				}
    			
    		}
    	}
    }
    
    
    public void rotate(int[][] arr, int x, int y) {
    	
    	if(arr[x][y] == 3) {
    		arr[x][y] = 0;
		} else {
			arr[x][y]++;
		}
    	
    	if(x-1 >= 0 ) {
    		if(arr[x-1][y] == 3) {
    			arr[x-1][y] = 0;
    		} else {
    			arr[x-1][y]++;
    		}
    	}
    	if(y-1 >= 0 ) {
    		if(arr[x][y-1] == 3) {
    			arr[x][y-1] = 0;
    		} else {
    			arr[x][y-1]++;
    		}
    	}
    	
    	if(x+1 < arr.length) {
    		if(arr[x+1][y] == 3) {
    			arr[x+1][y] = 0;
    		} else {
    			arr[x+1][y]++;
    		}
    	}
    	
    	if(y+1 < arr[0].length ) {
    		if(arr[x][y+1] == 3) {
    			arr[x][y+1] = 0;
    		} else {
    			arr[x][y+1]++;
    		}
    	}
    }
    
    
    public void _rotate(int[][] arr, int x, int y) {
    	
    	if(arr[x][y] == 0) {
    		arr[x][y] = 3;
		} else {
			arr[x][y]--;
		}
    	
    	if(x-1 >= 0 ) {
    		if(arr[x-1][y] == 0) {
    			arr[x-1][y] = 3;
    		} else {
    			arr[x-1][y]--;
    		}
    	}
    	if(y-1 >= 0 ) {
    		if(arr[x][y-1] == 0) {
    			arr[x][y-1] = 3;
    		} else {
    			arr[x][y-1]--;
    		}
    	}
    	
    	if(x+1 < arr.length) {
    		if(arr[x+1][y] == 0) {
    			arr[x+1][y] = 3;
    		} else {
    			arr[x+1][y]--;
    		}
    	}
    	
    	if(y+1 < arr[0].length ) {
    		if(arr[x][y+1] == 0) {
    			arr[x][y+1] = 3;
    		} else {
    			arr[x][y+1]--;
    		}
    	}
    }
    
    public boolean valid(int[][] arr) {
    	for(int i=0 ; i<arr.length ; i++) {
    		for(int j=0 ; j<arr[0].length ; j++) {
    			if(arr[i][j] != 0) {
    				return false;
    			}
    		}
    	}
    	return true;
    }
    
    public boolean valid1(int[][] arr) {
    	for(int i=0 ; i<arr[0].length ; i++) {
			if(arr[0][i] != 0) {
				return false;
			}
    	}
    	return true;
    }
    
    public void printArr(int[][] arr) {
    	System.out.println("----------------------------------------------");
    	for(int i=0 ; i<arr.length ; i++) {
    		for(int j=0 ; j<arr[0].length ; j++) {
    			System.out.printf("%3d (%d, %d)" , arr[i][j], i, j);
    		}
    		System.out.println();
    	}
    	
    }
    
    
	public int[][] deepCopy(int[][] arr) {
		int[][] result = new int[arr.length][arr[0].length];
		for (int i = 0; i < arr.length; i++) {
			result[i] = arr[i].clone();
		}
		return result;
	}
    
}



