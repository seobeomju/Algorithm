import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        // System.out.println(times);
        long min = 1;
        long max = (long)times[times.length-1] * n;
        
       
        long result = max;
        while(max >= min){
            long people = 0;
            long mid = (max + min) /2;
            for(long time : times){
                people += mid/time;
            }
            if(people < n ){
                min = mid+1;
               
            }else if(people >= n ){
                result = Math.min(result, mid);
                max = mid-1;
            }
        }
        answer = result;
        
        return answer;
    }
}