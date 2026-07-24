import java.util.*;
class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        answer = 0;
       
        // 이것도 두가지 + - [1]를 넣은다음 결과 -> 다시 + - 2,4,8,16
        dfs(numbers,target,0,0);
        
        return answer;
    }
    
    private void dfs (int[] numbers, int target, int depth, int sum){
        //1. 탈출 조건:  모든 숫자를 전부 다 사용했을 때 (끝까지 도달)
        if(depth == numbers.length){
            if(sum == target){
                answer ++;
            }
            return ;
        }
        
        dfs(numbers,target, depth + 1, sum+numbers[depth]); // +선택
        dfs(numbers,target,depth+1,sum-numbers[depth]); // -선택
    }

}