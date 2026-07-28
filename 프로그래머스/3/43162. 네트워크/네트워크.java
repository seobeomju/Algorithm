import java.util.*;
class Solution {
    static int count = 0;
    static boolean[] visited; 
    static HashMap<Integer,ArrayList<Integer>> map;
    public int solution(int n, int[][] computers) {
        
        map = new HashMap<>();
        
        for(int i=0; i<n;i++){
            map.put(i,new ArrayList<>()); 
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(computers[i][j] == 1 && i != j){
                    map.get(i).add(j);
                }
            }
        }
        
        visited = new boolean[n];
        for(int i =0 ;i <n ; i++){
            if(!visited[i]){
                bfs(i,n);
            }
        }
        
        
        
        return count;
    }
    
    public void bfs(int start,int n){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        System.out.println(start);
        q.add(start);
        visited[start] = true;
        
        while(!q.isEmpty()){
            int now = q.poll();
            System.out.println(q);
            
            for(int next : map.get(now)){
                if(!visited[next]){
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
        
        count++ ;
    }
}