import java.util.*;
class Solution {
    //인접 리스트 
    static HashMap<Integer,ArrayList<Integer>> wiresMap;
    static boolean[] visited;
    //static ArrayList<Integer> wiresList;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        int nodeCount =0;
        wiresMap = new HashMap<>();
        for(int i=1; i<=n; i++){
            wiresMap.put(i,new ArrayList<>());
        }
        for(int[] info : wires){
            wiresMap.get(info[0]).add(info[1]);
            wiresMap.get(info[1]).add(info[0]);
        }
        System.out.println(wiresMap);
        
        
        
        for(int i=1; i<=n;i++){
            
            for(int j =0; j<wiresMap.get(i).size(); j++){
                int next = wiresMap.get(i).get(j); 
                System.out.println(next);
                visited = new boolean[n+1];
                int result = bfs(i,n,next);   
                answer = Math.min( answer, Math.abs((n-result) - result));
            }
            
        }
        return answer;
    }
    
    private int bfs(int start, int n , int end){
        int result = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] =true;
        result++;
        
        while(!q.isEmpty()){
            int now = q.poll();
            for(int i=0; i<wiresMap.get(now).size();i++){
                int next = wiresMap.get(now).get(i);
                if((now==start && next == end) || (now == end && next == start)){
                    continue;
                }
                
                if(!visited[next]){
                    result++;
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
        
     
        
        return result;
    }
}
