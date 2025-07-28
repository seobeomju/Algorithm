import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

    public static int n,m;
    public static int[][]ice;
    public static boolean[][] check;

    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n= Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());

        ice = new int[n][m];

        
        for(int i=0; i < n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                ice[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        
        solve();
    }

    //시뮬레이션 시작
    public static void solve(){
        int year =0; //년도 초기화
        int islandNum =0; //현재 분리된 빙산 덩어리 개수
        int iceNum = -1; //남아있는 빙산 칸 수
        while(true){
            //빙하가 모두 녹으면 탐색 종료
            if(iceNum ==0){
                System.out.println(0);
                break;
            }
            else{
                //현재 섬 개수 찾기
                islandNum = countOfIsland();

                //2개 이상으로 분리된 경우, 현재 year출력하고 종료
                if(islandNum >=2){
                    System.out.println(year);
                    break;
                }
            }

            //빙하 녹음
            iceNum = melting();

            year++;
            islandNum=0;
        }
    }

    //빙산 덩어리 개수 세기 (bfs 사용)
    public static int countOfIsland(){
        int cnt =0;
        check = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //아직 방문하지 않은 빙산있을 경우
                if(ice[i][j] != 0 && !check[i][j]){
                    bfs(j,i); // 연결된 빙산 구역 탐색
                    cnt ++; //하나의 덩어리로 간주
                }
            }
        }
        return cnt;
    }

    //빙산 구역탐색
    public static int bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();

        check[y][x] = true;
        q.add(new Node(x,y));

        int cnt  =0;
        while(!q.isEmpty()){
            Node pos = q.poll();
            int px = pos.x;
            int py = pos.y;
            
            cnt ++;
            for (int i = 0; i < 4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];
                if(nx<0 || ny<0 || nx>m-1 || ny>n-1 || check[ny][nx]) continue;
				
				if(ice[ny][nx]!=0) {
					check[ny][nx] = true;
					q.add(new Node(nx,ny));
				}
            }
        }
        return cnt;
    }

    //빙산 녹이기
    public static int melting() {
		int cnt=0;
		boolean[][] visit = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
                //빙산이 있는 경우
				if(ice[i][j] !=0) {
					visit[i][j] =true;
					for(int k=0; k<4; k++) {

                        //주변 4방향 탐색 바다 일겨웅 빙산 높이 감소
						int nx = j +dx[k];
						int ny = i +dy[k];
						
						if(nx<0 || ny<0 || nx>m-1 || ny>n-1 | visit[ny][nx]) continue;
						
						if(ice[ny][nx]==0 && ice[i][j]>0) {
							ice[i][j]--;
						}
					}
					
                    //아직 남아 있는 빙산 수 카운트
					if(ice[i][j] > 0)cnt++;
					
				}
			}
		}
		return cnt;
	}
}