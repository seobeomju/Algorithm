import java.util.*;
class Solution {
    private static int[] dx = new int[]{1,-1,0,0};
    private static int[] dy = new int[]{0,0,-1,1};
    
    private static int[][] dist;
    
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m =maps[0].length;
        dist = new int[n][m];
        int[] start = new int[]{0,0};
        
        answer = bfs(maps, start,n,m);
        
        return answer;
    }
    
    private static int bfs(int[][] maps, int[] start,int n, int m){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        
        q.add(start);
        dist[start[0]][start[1]] = 1;
        
        while(!q.isEmpty()){
            int[] now =q.poll();
            
            
            for(int i=0; i<4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                
                if( 0<=nx && nx <n && 0<=ny && ny<m ){
                    if(maps[nx][ny] == 1 && dist[nx][ny] == 0){
                        q.add(new int[]{nx,ny});
                        dist[nx][ny] = dist[now[0]][now[1]]+ 1;
                    }    
                }
            }
        }
        
        return dist[n-1][m-1] == 0 ? -1 : dist[n-1][m-1];
    }
}