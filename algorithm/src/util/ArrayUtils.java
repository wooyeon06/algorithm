package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ArrayUtils {
    public boolean compareLists(List<int[]> list1, List<int[]> list2) {
        if (list1.size() != list2.size()) return false;
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int[] arr : list1) set1.add(Arrays.hashCode(arr));  // 배열을 해싱하여 추가
        for (int[] arr : list2) set2.add(Arrays.hashCode(arr));  // 배열을 해싱하여 추가
        return set1.equals(set2);  // HashSet 비교 (순서 무시)
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
}
