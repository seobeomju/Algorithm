import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : arr){
            if(num % divisor == 0){
                list.add(num);
            }
        }
        Collections.sort(list);
        if(list.isEmpty()){
            list.add(-1);
        }
        answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}