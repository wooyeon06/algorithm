package lv3.a84021;

import util.P;

import java.util.*;

class Solution {
    int len = 0;
    public int solution(int[][] game_board, int[][] table) {

        len = table.length;

        //shape 1~6
        ArrayList<ArrayList<int[]>>[] shapeTList  = new ArrayList[10];
        ArrayList<ArrayList<int[]>>[] shapeGBList = new ArrayList[10];
        for (int i = 0; i < shapeTList.length ; i++) {
            shapeTList[i] = new ArrayList<ArrayList<int[]>>();
            shapeGBList[i] = new ArrayList<ArrayList<int[]>>();
        }

        int[][] dir = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};
        boolean v[][] = new boolean[len][len];
        Queue<int[]> q = new LinkedList();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len ; j++) {
                if(table[i][j] == 0 || v[i][j] == true) continue;

                q.add(new int[]{i, j});
                ArrayList<int[]> shape = new ArrayList();
                while(!q.isEmpty()) {
                    int[] cur = q.poll();
                    if(!v[cur[0]][cur[1]]) shape.add(new int[]{cur[0], cur[1]});
                    v[cur[0]][cur[1]] = true;

                    for (int[] d : dir) {
                        int r = cur[0] + d[0];
                        int c = cur[1] + d[1];
                        if(r < 0 || c < 0 || r >= len || c >= len) continue;
                        if(!v[r][c] && table[r][c] == 1) {
                            q.add(new int[]{r, c});
                        }
                    }
                }
                normalization(shape);
                shapeTList[shape.size()].add(shape);
            } //end of for (int j = 0; j < len ; j++) {
        }

        v = new boolean[len][len];
        q = new LinkedList();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len ; j++) {
                if(game_board[i][j] == 1 || v[i][j] == true) continue;

                q.add(new int[]{i, j});
                ArrayList<int[]> shape = new ArrayList();

                while(!q.isEmpty()) {
                    int[] cur = q.poll();
                    if(!v[cur[0]][cur[1]]) shape.add(new int[]{cur[0], cur[1]});
                    v[cur[0]][cur[1]] = true;

                    for (int[] d : dir) {
                        int r = cur[0] + d[0];
                        int c = cur[1] + d[1];
                        if(r < 0 || c < 0 || r >= len || c >= len) continue;
                        if(!v[r][c] && game_board[r][c] == 0) {
                            q.add(new int[]{r, c});
                        }
                    }
                }
                normalization(shape);
                shapeGBList[shape.size()].add(shape);
            } //end of for (int j = 0; j < len ; j++) {
        }

        /////////////////////////////////////////////////////////////////////////////////////////
        int answer = 0;
        for (int i = 1; i < shapeTList.length; i++) {
            for (ArrayList<int[]> shapeT : shapeTList[i]) {
                if(shapeT.size() > 0) {
                    for (ArrayList<int[]> shapeG : shapeGBList[i]) {
                        if(shapeG.size() > 0 && shapeG.size() == shapeT.size()) {
                            boolean b = false;
                            List<int[]> rotated = shapeG;
                            for(int m = 0; m < 4; m++) { // 회전
                                if(compareLists(rotated, shapeT)) {
                                    b = true;
                                    break;
                                }
                                if(m < 3) {
                                    rotated = rotate(rotated);
                                }
                            }

                            if(b) {
                                answer += i;
                                shapeT.clear();
                                shapeG.clear();
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }

    public void normalization(ArrayList<int[]> target) {
        // int[0]의 최소값 구하기
        int min0 = target.stream()
                .mapToInt(arr -> arr[0]) // 각 배열의 첫 번째 값(int[0]) 추출
                .min()                   // 최소값 계산
                .orElseThrow();          // 값이 없을 때 예외 발생

        // int[1]의 최소값 구하기
        int min1 = target.stream()
                .mapToInt(arr -> arr[1]) // 각 배열의 두 번째 값(int[1]) 추출
                .min()                   // 최소값 계산
                .orElseThrow();          // 값이 없을 때 예외 발생

        for (int[] arr : target) {
            arr[0] -= min0; // 각 배열의 첫 번째 값을 최소값만큼 감소
            arr[1] -= min1; // 각 배열의 첫 번째 값을 최소값만큼 감소
        }
    }

    public ArrayList<int[]> rotate(List<int[]> target) {
        ArrayList<int[]> source = new ArrayList<int[]>();
        int max1 = target.stream()
                .mapToInt(arr -> arr[1])
                .max()
                .orElseThrow();
        for (int[] arr : target) {
            source.add(new int[]{max1 - arr[1], arr[0]});
        }
        return source;
    }

    public boolean compareLists(List<int[]> list1, List<int[]> list2) {
        if (list1.size() != list2.size()) return false;
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int[] arr : list1) set1.add(Arrays.hashCode(arr));  // 배열을 해싱하여 추가
        for (int[] arr : list2) set2.add(Arrays.hashCode(arr));  // 배열을 해싱하여 추가
        return set1.equals(set2);  // HashSet 비교 (순서 무시)
    }
}