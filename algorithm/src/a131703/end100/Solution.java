package a131703.end100;



// x축으로 돌린 모든 경우의 수에
// y축의 첫번째 값이 다른것만 돌려 최소값을 구한다

import java.util.*;

class Solution {
	
	int sizex;
	int sizey;
	int[][] beginning;
	int[][] target;
	int min = Integer.MAX_VALUE;
	
    public int solution(int[][] beginning, int[][] target) {
        this.beginning = beginning;
        this.target = target;
        sizex = beginning.length;
        sizey = beginning[0].length;
        
        boolean[] visit = new boolean[sizex];
        for(int i=0 ; i<sizex ; i++) {
        	visit[i] = false;
        }
        
        if(equalArr(this.target, this.beginning)) {
        	return 0;
        }
        
       	rotateX(beginning, visit, 1, 0);
       	if(min == Integer.MAX_VALUE) {
       		return -1;
       	}
        return min;
    }
    
    
    public void rotateX(int[][] arr, boolean[] visit, int depth, int cnt) {
    	if(sizex < depth || cnt > min) {
    		return;
    	}
    	
    	for(int idx=0 ; idx<sizex ; idx++) {
    		if(visit[idx] == false) {
        		////////////////////////////// flip
    			visit[idx] = true;
    			for(int i=0 ; i<sizey ; i++) {
        			if(arr[idx][i] == 0) {
        				arr[idx][i] = 1;
        			} else {
        				arr[idx][i] = 0;
        			}
        		}
    			cnt++;
        		//////////////////////////////
	    		
	    		int _cnt = 0;
        		int temp[][] = deepCopy(arr);
				for(int i=0 ; i<sizey ; i++) { 
					if(this.target[0][i] != temp[0][i]) {
						rotateY(i, temp);
						_cnt++; 
					} 
				}
				
        		
        		if(equalArr(this.target, temp)) {
                	if((cnt + _cnt) < min) {
                		System.out.println("equal!!!!! x flip: " + cnt);
                    	System.out.println("equal!!!!! y flip: " + _cnt);
                		min = cnt + _cnt;
                		System.out.println("min : " +  min);
                	}
                }
        		
        		
        		rotateX(arr, visit, depth+1, cnt);
        		
        		////////////////////////////// unfilp
        		visit[idx] = false;
        		for(int i=0 ; i<sizey ; i++) {
        			if(arr[idx][i] == 0) {
        				arr[idx][i] = 1;
        			} else {
        				arr[idx][i] = 0;
        			}
        		}
        		cnt--;
        		//////////////////////////////
        	}
    	}
    }
    
    
    
    public void rotateY(int y, int[][] arr) {
    	for(int i=0 ; i<sizex ; i++) {
    		if(arr[i][y] == 0) {
    			arr[i][y] = 1;
    		} else {
    			arr[i][y] = 0;
    		}
    	}
    }
    
    
    
    private boolean equalArr(int[][] a, int[][] b) {
		boolean result = true;
		for(int i=0 ; i<a.length ; i++) {
			for(int j=0 ; j<a[i].length ; j++) {
				if(a[i][j] != b[i][j]) {
					result = false;
					break;
				}
			}
		}
		
		return result;
	}
	
    	
    public void printAll() {
    	
    	System.out.println("==========beginning=========");
    	
    	for(int i=0 ; i<sizex ; i++) {
    		for(int j=0 ; j<sizey ; j++) {
    			System.out.printf("%3d", beginning[i][j], i, j);
    		}
    		System.out.println();
    	}
    	
    	System.out.println("\n==========target=========");
    	for(int i=0 ; i<sizex ; i++) {
    		for(int j=0 ; j<sizey ; j++) {
    			System.out.printf("%3d", target[i][j], i, j);
    		}
    		System.out.println();
    	}
    	
    }
    
    
    public void printArr(int[][] arr) {
    	
    	System.out.println("==========arr=========");
    	
    	for(int i=0 ; i<arr.length ; i++) {
    		for(int j=0 ; j<arr[i].length ; j++) {
    			System.out.printf("%3d", arr[i][j], i, j);
    		}
    		System.out.println();
    	}
    	
    	
    }
    
    static int[][] deepCopy(int[][] arr){
        int[][] result = new int[arr.length][arr[0].length];
        for (int i=0; i<arr.length; i++) {
          result[i] = arr[i].clone();
        }
        return result;
      }
    
}