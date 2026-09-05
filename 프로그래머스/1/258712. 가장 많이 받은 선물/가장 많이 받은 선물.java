//선물 지수: 친구에게 준 선물 - 받은 선물 수
//선물 지수가 더 큰 사람이 더 작은 사람에게 선물을 하나 받음(같거나 없을 경우)
//서로 주고받은 게 많은 사람이 적은 사람에게 받는다
import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int[] result = new int[friends.length];
        HashMap<String,HashMap<String,Integer>> giftMap = new HashMap<>();
        HashMap<String,Integer> scoreMap = new HashMap<>();
        
        
        //System.out.println(giftMap);
        for(String friend : friends){
            scoreMap.put(friend,0);
            giftMap.put(friend,new HashMap<>());
        }
        
        
        for(String gift : gifts){
            //0 = 준사람 1 = 받은 사람
            String[] arr = gift.split(" ");
            
            giftMap.get(arr[0]).put(arr[1],giftMap.get(arr[0]).getOrDefault(arr[1],0)+1);
            scoreMap.put(arr[0],scoreMap.get(arr[0]) +1);
            scoreMap.put(arr[1],scoreMap.get(arr[1]) -1);
            
        }
        
        for(int i=0; i<friends.length; i++){
            for(int j=i+1; j<friends.length;j++){
                String a = friends[i];
                String b = friends[j];
                
                int aToB = giftMap.get(a).getOrDefault(b,0);
                int bToA = giftMap.get(b).getOrDefault(a,0);
                
                if(aToB>bToA){
                    result[i]++;
                }else if(aToB < bToA){
                    result[j]++;
                }else{
                    int aScore = scoreMap.get(a);
                    int bScore = scoreMap.get(b);
                    
                    if(aScore > bScore){
                        result[i]++;
                    }else if(aScore<bScore){
                        result[j]++;
                    }
                }
            }
        }
        
        for(int i:result){
            if(i>answer){
                answer = i;
            }
        }
        return answer;
    }
}