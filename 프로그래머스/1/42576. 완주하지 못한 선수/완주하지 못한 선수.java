import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer> map = new HashMap<>();
        for(String name : participant){
            // getOrDefault 해당하는 키가 있으면 값을 가져오고 없으면 내가 지정하는 값을 저장
            // 동명이인이 있을경우 저장된 값을 들고와서 +1 진행
            map.put(name,map.getOrDefault(name,0)+1);
        }
        
        for(String name : completion){
            map.put(name, map.get(name) - 1);
        }
        
        for(String name : map.keySet()){
            if(map.get(name) > 0 ){
                answer = name;
            }
        }
        
        return answer;
    }
}