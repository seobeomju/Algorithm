import java.util.*;
class Solution {
    private static int[] parent;
    private static int find(int x){
        if(parent[x] == x){
            return x;
        }
        
        parent[x] = find(parent[x]);
        return parent[x];
    }
    
    private static void union(int x, int y){
        int rootx = find(x);
        int rooty = find(y);
        parent[rooty] = rootx;
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        Arrays.sort(costs,(a,b) -> a[2] - b[2]);
        parent = new int[n];
        
        for(int i=0; i<n;i++){
            parent[i]=i;
        }
        
        for(int[] cost : costs){
            if(find(cost[0]) != find(cost[1])){
                union(cost[0],cost[1]);
                answer += cost[2];
            }else{
                continue;
            } 
        }
        
        
        return answer;
    }
}