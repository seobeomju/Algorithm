import java.util.*;
// 레버 ->  출구 최대한 빠르게 미로를 빠져나가는 시간
class Solution {
    
    static int[][] dist;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[] l;
    public int solution(String[] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length();
        
        dist = new int[n][m];
        int resultL =0;
        for(int i=0; i<n; i++){
            for(int j =0; j<m ; j++){
                //System.out.println(maps[i].charAt(j));
                if(maps[i].charAt(j) =='S'){
                     resultL = Lbfs(i,j,maps);
                }
                if(maps[i].charAt(j) =='L'){
                    l = new int[]{i,j}; 
                }
            }
        }
        
        dist = new int[n][m];
        int resultS = Sbfs(l[0], l[1],maps);
        if(resultL == -1 || resultS == -1){
            return -1;
        }
        answer = resultL + resultS;
        return answer;
    }
    
            
    public int Lbfs(int x, int y, String[] maps){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x,y});
        dist[x][y] = 1;
        while(!q.isEmpty()){
            int[] now = q.poll();
            int cx = now[0];
            int cy = now[1];
            
            for(int i=0;i<4;i++){
                int nx = cx + dx[i];
                int ny = cy +dy[i];
                
                if(nx>=0 && nx < maps.length&& ny >= 0 && ny< maps[0].length()){
                    if(dist[nx][ny] == 0 &&(maps[nx].charAt(ny) == 'O' || maps[nx].charAt(ny) == 'E'|| maps[nx].charAt(ny) == 'S')){
                        q.offer(new int[]{nx,ny});
                        dist[nx][ny] = dist[cx][cy] + 1;
                    }
                    
                    if(dist[nx][ny] == 0 &&maps[nx].charAt(ny) == 'L'){
                        return dist[cx][cy];
                    }
                }
            }
        }
        return -1;
    } 
    public int Sbfs(int x, int y, String[] maps){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x,y});
        dist[x][y] = 1;
        while(!q.isEmpty()){
            int[] now = q.poll();
            int cx = now[0];
            int cy = now[1];
            
            for(int i=0;i<4;i++){
                int nx = cx + dx[i];
                int ny = cy +dy[i];
                
                if(nx>=0 && nx < maps.length&& ny >= 0 && ny< maps[0].length()){
                    if(dist[nx][ny] == 0 && (maps[nx].charAt(ny) == 'O' || maps[nx].charAt(ny) == 'S') ){
                        q.offer(new int[]{nx,ny});
                        dist[nx][ny] = dist[cx][cy] + 1;

                    }
                    
                    if(dist[nx][ny] == 0 &&maps[nx].charAt(ny) == 'E'){

                        return dist[cx][cy];
                    }
                }
            }
        }
        
        return -1;
    }
}