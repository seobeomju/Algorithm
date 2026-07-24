import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String name : participant){
            map.put(name, map.getOrDefault(name,0)+1 );
        }
        //System.out.println(map);
        
        for(String name : completion){
            map.put(name,map.get(name) -1);
        }
        
        //System.out.println(map);
        
        for(int i=0; i<participant.length; i++){
            if(map.get(participant[i]) > 0 ){
                answer = participant[i];
            }
        }
        
        
        return answer;
    }
}