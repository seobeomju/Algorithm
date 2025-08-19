import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] numbers) {
 
        ArrayList<Integer> list = new ArrayList<>();
        for(int i =0; i<numbers.length; i++){
            for(int j =i+1; j<numbers.length; j++){
                int result = numbers[i]+numbers[j];
                list.add(result);
            }
        }
            return list.stream()
                   .distinct()         // 중복 제거
                   .sorted()           // 오름차순 정렬
                   .mapToInt(Integer::intValue)
                   .toArray();
    }
}