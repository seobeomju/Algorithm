import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap<String,Integer> map = new HashMap<>();
        
        for(int i=0;i<want.length; i++){
            map.put(want[i],number[i]);
        }
        
        System.out.println(map);
        HashMap<String,Integer> disMap = new HashMap<>();
        
        for(int start = 0; start <= discount.length - 10; start ++){
            for(int i = start; i<start +10; i++){        
                disMap.put(discount[i], disMap.getOrDefault(discount[i],0) +1);
            }
            
            if(map.equals(disMap)){
                answer++;
            }
            disMap.clear();
        }
        
        return answer;
    }
}