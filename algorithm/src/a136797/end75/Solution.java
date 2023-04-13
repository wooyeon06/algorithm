package a136797.end75;



import java.util.*;


//숫자 타자 대회
class Solution {
	
	int min = 500000;
	char[][] keypad = new char[4][3];
	int lx=1, ly=0;
	int rx=1, ry=2;
	
	class KeyInfo {
		int x=0;
		int y=0;
		
		public KeyInfo(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	Map<String, KeyInfo> map = new HashMap<String, KeyInfo>();
	
	public int solution(String numbers) {
        
        keypad[0][0] = '1';
        map.put("1", new KeyInfo(0, 0));
        keypad[0][1] = '2';
        map.put("2", new KeyInfo(0, 1));
        keypad[0][2] = '3';
        map.put("3", new KeyInfo(0, 2));
        
        keypad[1][0] = '4';
        map.put("4", new KeyInfo(1, 0));
        keypad[1][1] = '5';
        map.put("5", new KeyInfo(1, 1));
        keypad[1][2] = '6';
        map.put("6", new KeyInfo(1, 2));
        
        keypad[2][0] = '7';
        map.put("7", new KeyInfo(2, 0));
        keypad[2][1] = '8';
        map.put("8", new KeyInfo(2, 1));
        keypad[2][2] = '9';
        map.put("9", new KeyInfo(2, 2));
        
        keypad[3][0] = '*';
        map.put("*", new KeyInfo(3, 0));
        keypad[3][1] = '0';
        map.put("0", new KeyInfo(3, 1));
        keypad[3][2] = '#';
        map.put("#", new KeyInfo(3, 2));
        
        
        
        //printAll();
    	
    	//왼쪽부터 시작
        left(0, numbers, lx, ly, rx, ry, 0);
    	
        //오른쪽부터 시작
    	right(0, numbers, lx, ly, rx, ry, 0);
    	
        //System.out.println("min : " + min);
        
        return min;
    }
	
	public int left(int acc, String target, int lx, int ly, int rx, int ry, int sindex) {
		if(acc >= min) {
			return acc;
		}
		
		KeyInfo keyInfo = map.get(target.substring(sindex, sindex+1));
		
		if(keyInfo.x == rx && keyInfo.y == ry) {
			return acc;
		}
		
		int _x = keyInfo.x - lx;
		int _y = keyInfo.y - ly;

		if(_x == 0 && _y == 0) {
			acc = acc + 1;
		}
		
		while(true) {
			if(_x == 0 && _y == 0) {
				break;
			}
			
			if(_x > 0 && _y > 0) {
				acc = acc + 3;
				lx = lx + 1;
				ly = ly + 1;
			} else if(_x > 0 && _y < 0) {
				acc = acc + 3;
				lx = lx + 1;
				ly = ly - 1;
			} else if(_x < 0 && _y > 0) {
				acc = acc + 3;
				lx = lx - 1;
				ly = ly + 1;
			} else if(_x < 0 && _y < 0) {
				acc = acc + 3;
				lx = lx - 1;
				ly = ly - 1;
			} else if(_y == 0) {
				acc = acc + 2;
				if(_x > 0) {
					lx = lx + 1;
				} else {
					lx = lx - 1;
				}
			} else if(_x == 0) {
				acc = acc + 2;
				if(_y > 0) {
					ly = ly + 1;
				} else {
					ly = ly - 1;
				}
			}
			
			_x = keyInfo.x - lx;
			_y = keyInfo.y - ly;
		}
		
		if(target.length() > (sindex+1)) {
			left(acc, target, lx, ly, rx, ry, sindex+1);
			right(acc, target, lx, ly, rx, ry, sindex+1);
		} else {
			if(acc < min) {
				min = acc;
			}
		}
		
		return acc;
	}
	
	public int right(int acc,  String target, int lx, int ly, int rx, int ry, int sindex) {
		if(acc >= min) {
			return acc;
		}
		
		KeyInfo keyInfo = map.get(target.substring(sindex, sindex+1));
		if(keyInfo.x == lx && keyInfo.y == ly) {
			return acc;
		}
		
		int _x = keyInfo.x - rx;
		int _y = keyInfo.y - ry;

		if(_x == 0 && _y == 0) {
			acc = acc + 1;
		}
		
		while(true) {
			if(_x == 0 && _y == 0) {
				break;
			}
			
			if(_x > 0 && _y > 0) {
				acc = acc + 3;
				rx = rx + 1;
				ry = ry + 1;
			} else if(_x > 0 && _y < 0) {
				acc = acc + 3;
				rx = rx + 1;
				ry = ry - 1;
			} else if(_x < 0 && _y > 0) {
				acc = acc + 3;
				rx = rx - 1;
				ry = ry + 1;
			} else if(_x < 0 && _y < 0) {
				acc = acc + 3;
				rx = rx - 1;
				ry = ry - 1;
			} else if(_y == 0) {
				acc = acc + 2;
				if(_x > 0) {
					rx = rx + 1;
				} else {
					rx = rx - 1;
				}
			} else if(_x == 0) {
				acc = acc + 2;
				if(_y > 0) {
					ry = ry + 1;
				} else {
					ry = ry - 1;
				}
			}
			
			_x = keyInfo.x - rx;
			_y = keyInfo.y - ry;
		}
		
		
		if(target.length() > (sindex+1)) {
			left(acc, target, lx, ly, rx, ry, sindex+1);
			right(acc, target, lx, ly, rx, ry, sindex+1);
		} else {
			if(acc < min) {
				min = acc;
			}
		}
		
		return acc;
	}
	
	
	public void printAll() {
		for(int i=0 ; i<4 ; i++) {
			for(int j=0 ; j<3 ; j++) {
				if(i==lx && j==ly) {
					System.out.printf("%3sl (" +i + "," +j +  ")", keypad[i][j]);
				} else if(i==rx && j==ry) {
					System.out.printf("%3sr (" +i + "," +j +  ")", keypad[i][j]);
				} else {
					System.out.printf("%4s (" +i + "," +j +  ")", keypad[i][j]);
				}
			}
			System.out.println();
		}
		System.out.println();
		
		
	}
	
    
}