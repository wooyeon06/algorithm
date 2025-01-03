package etc.a60059;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int key[][];
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0,0});

        boolean visit[][] = new boolean[lock.length][lock.length];
        int dir[][] = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};

        int[][] r1 = key;
        int[][] r2 = rotate(r1);
        int[][] r3 = rotate(r2);
        int[][] r4 = rotate(r3);
        r1 = sizeup(r1, lock.length);
        r2 = sizeup(r2, lock.length);
        r3 = sizeup(r3, lock.length);
        r4 = sizeup(r4, lock.length);


        for (int i = -lock.length+1; i < lock.length; i++) {
            for (int j = -lock.length+1; j < lock.length; j++) {
                if(check(move(r1, i, j), lock)) return true;
                if(check(move(r2, i, j), lock)) return true;
                if(check(move(r3, i, j), lock)) return true;
                if(check(move(r4, i, j), lock)) return true;
            }
        }


        return answer;
    }

    public int[][] move(int[][] arr, int x, int y) {
        int newArr[][] = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(i+x < 0 || j+y < 0 || i+x >= arr.length || j+y >= arr.length) continue;
                newArr[i+x][j+y] = arr[i][j];
            }
        }
        return newArr;
    }

    public int[][] rotate(int[][] arr) {
        int newArr[][] = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                newArr[i][j] = arr[arr.length-1-j][i];
            }
        }
        return newArr;
    }

    public int[][] sizeup(int[][] arr, int size) {
        int sizeup[][] = new int[size][size];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                sizeup[i][j] = arr[i][j];
            }
        }

        for (int i = arr.length; i < size; i++) {
            for (int j = arr.length; j < size; j++) {
                sizeup[i][j] = 0;
            }
        }
        return sizeup;
    }


    public boolean check(int[][] key, int[][] lock) {
        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock.length; j++) {
                if(lock[i][j] == key[i][j]) return false;
            }
        }
        return true;
    }


}


