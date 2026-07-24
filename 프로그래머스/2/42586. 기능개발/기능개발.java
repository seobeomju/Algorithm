import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i =0; i<progresses.length;i++){
            int day = progresses[i];
            int days = 0;
            while(day<100){
                days++;
                day += speeds[i];
            }
            q.add(days);
            System.out.println(q);
        }
        
        
        while(!q.isEmpty()){
            int count =0;
            int day = q.pop();
            count ++;
            while(!q.isEmpty() && q.peek() <= day){
                q.pop();
                count++;
            }
            
            answer.add(count);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}