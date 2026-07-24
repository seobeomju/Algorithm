import java.util.*;
class Solution {
    private static int[] dx = new int[]{1,-1,0,0};
    private static int[] dy = new int[]{0,0,-1,1};
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;

        int[] start = new int[]{0,0};
        answer = bfs(start,maps,n,m);
            
        return answer;
    }
    
    private static int bfs(int[] start, int[][] maps,int n,int m){
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        //거리 겸 방문 여부 저장 배열
        int[][] dist = new int[n][m];
        
        queue.add(start);
        dist[0][0] = 1;
        
        while(!queue.isEmpty()){
            
            int[] now = queue.poll();
            
            for(int i=0; i<4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                
                if( 0<=nx && nx<n &&  0<=ny && ny<m){
                   if(maps[nx][ny] == 1 && dist[nx][ny] == 0){
                        dist[nx][ny] = dist[now[0]][now[1]] + 1;
                        queue.add(new int[]{nx,ny});
                   }
                }
            }     
            
        }
        return dist[n-1][m-1] == 0 ? -1 : dist[n-1][m-1];
    }
}