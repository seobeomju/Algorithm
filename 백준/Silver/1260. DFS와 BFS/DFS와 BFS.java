import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    
    // 방문 여부 체크를 위한 배열
    static boolean[] check;
    // 인접 행렬 형태로 그래프를 표현하기 위한 배열
    static int[][] arr;

    static int node, line, start;

    // BFS 탐색을 위한 큐
    static Queue<Integer> q = new LinkedList<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

   
        arr = new int[node + 1][node + 1];
        check = new boolean[node + 1];

        // 양방향
        for (int i = 0; i < line; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }

        //DFS
        dfs(start);
        sb.append("\n"); // DFS 끝난 후 줄바꿈 추가

        // BFS 실행 전 방문 배열 초기화
        check = new boolean[node + 1];

        // BFS
        bfs(start);

        System.out.println(sb);
    }

    // DFS
    public static void dfs(int start) {

        // 현재 노드를 방문했음을 표시
        check[start] = true;

        // 방문한 노드를 결과에 추가
        sb.append(start).append(" ");

        // 재귀 호출
        for (int i = 1; i <= node; i++) {
            if (arr[start][i] == 1 && !check[i]) {
                dfs(i);
            }
        }
    }

    // BFS
    public static void bfs(int start) {

        // 시작 노드를 큐에 추가하고 방문 표시
        q.add(start);
        check[start] = true;

        // 큐가 빌 때까지 반복
        while (!q.isEmpty()) {

            // 큐에서 노드를 하나 꺼내어 방문
            start = q.poll();

            // 방문한 노드를 결과에 추가
            sb.append(start).append(" ");

            // 꺼낸 노드와 연결된 모든 인접 노드 검사
            for (int i = 1; i <= node; i++) {
                // 인접 노드이면서 아직 방문하지 않은 경우
                if (arr[start][i] == 1 && !check[i]) {
                    q.add(i); 
                    check[i] = true; 
                }
            }
        }
    }
}
