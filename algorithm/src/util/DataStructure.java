package util;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class DataStructure {

    public void example() {
        HashMap<Integer, Integer> map =  new HashMap<Integer, Integer>();

        ///////////////////////////////////////////////////////////////////////
        //map foreach
        AtomicInteger max = new AtomicInteger(0);
        map.forEach((key, value) -> {
            if (max.get() < value) {
                max.set(value);
            }
        });


        ///////////////////////////////////////////////////////////////////////
        //list > int[]
        ArrayList<Integer> list = new ArrayList<Integer>();
        int arr1[] = list.stream().mapToInt(Integer::intValue).toArray();


        ///////////////////////////////////////////////////////////////////////
        //map sort
        // Key를 기준으로 정렬된 맵 생성
        Map<String, Integer> hashMap = new HashMap<>();
        Map<String, Integer> sortedMap = new TreeMap<>(hashMap);
        System.out.println("키를 기준으로 정렬된 맵: " + sortedMap);


        
        // Value를 기준으로 정렬된 맵 생성
        // 값으로 정렬된 리스트 생성
        List<Map.Entry<String, Integer>> sortedList = hashMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());




    }

}
