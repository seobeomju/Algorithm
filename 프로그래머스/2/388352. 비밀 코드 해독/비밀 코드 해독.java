import java.util.*;
class Solution {
    int[] selected = new int [5];
    int[][] q;
    int[] ans;
    int answer;
    public int solution(int n, int[][] q, int[] ans) {
        this.answer = 0;
        this.q = q;
        this.ans = ans;
        

        dfs(1,0,n);   

        return answer;
    }
    
    public void dfs(int start, int depth, int n){
        if(depth ==5){
            for(int i = 0; i<q.length;i++){
                int count = 0;
                for(int j =0; j<5; j++){
                    for(int k =0; k<5;k++){
                    if(selected[j] == q[i][k]){
                        count ++ ;
                    }
                    }
                }

                
                if(count != ans[i]){
                return;
                }
            }
            answer ++;
            return;
        }
        
        for(int  i = start; i<=n; i++){
            selected[depth] = i;
            
            dfs(i+1,depth + 1, n);
        }
    }
}

