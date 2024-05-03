package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // HashMap 생성
        Map<String, Integer> hashMap = new HashMap<>();

        // 데이터 추가
        hashMap.put("Apple", 10);
        hashMap.put("Orange", 30);
        hashMap.put("Banana", 20);

        // 값으로 정렬된 리스트 생성
        List<Map.Entry<String, Integer>> sortedList = hashMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());

        // 정렬된 리스트 출력
        System.out.println("값을 기준으로 정렬된 리스트: " + sortedList);

    }
}