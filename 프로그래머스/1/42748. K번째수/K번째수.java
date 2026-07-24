import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        
       
        // commands만큼 반복 진행
        for(int[] cm : commands){
            ArrayList<Integer> result = new ArrayList<>();
            int i = cm[0];
            int j = cm[1];
            
            for(int k =i-1; k<j; k++){
                result.add(array[k]);
            }
            Collections.sort(result);
            System.out.println(result);
            
            int n = result.get(cm[2]-1);
            System.out.println(n);
            
            answer.add(n);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}