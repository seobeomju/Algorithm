import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    //1. 0.0부터 탐색 
    //2. 처음 생성된 그림의 넓이를 max로 지정, 개수 1증가
    //3. 다음 생성된 그림의 넓이가 max보다 클 경우 max값 갱신, 개수 증가.
    //4. 반복 후 결과 출력
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] board;
    static boolean[][] visited;
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        //board 생성
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[N][M];

        //개수 및 최대 넓이
        int count = 0;
        int maxArea = 0;

        //전체 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                //방문하지 않은 그림을 만나면 BFS시작
                if(board[i][j] == 1 && !visited[i][j]){
                    int area = bfs(i,j); //현재 그림 넓이
                    count++; //그림 개수 증가
                    maxArea = Math.max(maxArea,area); //최대 넓이 갱신
                }
            }
        }

        System.out.println(count);
        System.out.println(maxArea);
    }

    // 하나의 그림의 넓이를 구하는 함수
    public static int bfs(int X, int Y){
        Queue<int[]> q = new LinkedList<>(); //int 배열로 x,y좌표 저장

        //시작점 삽입 및 방문 처리
        q.offer(new int[]{X,Y});
        visited[X][Y] = true;

        int area = 1; //시작점 포함

        while(!q.isEmpty()){
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];

            //4방향 탐색
            for(int i = 0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                // 범위 체크 + 방문 여부 + 그림인지 확인
                if(nx<0 || nx>=N|| ny<0 || ny >= M) continue;
                if(visited[nx][ny] || board[nx][ny] != 1) continue;

                // 방문 처리 후 큐의 추가
                visited[nx][ny] = true;
                q.offer(new int[]{nx,ny});
                area++;
            }
        }
        return area;
    }
}