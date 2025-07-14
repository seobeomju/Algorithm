
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static boolean[] visited;

    public static List<Integer>[] tree;

    public static int[] grouped;

    public static boolean ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            tree = new ArrayList[V+1];
            visited = new boolean[V+1];
            grouped = new int[V+1];
            ans = true;

            for (int j = 1; j <= V; j++) {
                tree[j] = new ArrayList<>();
            }

               //간선 정보 입력
        for (int j = 0; j < E; j++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt((st.nextToken()));
            int b = Integer.parseInt(st.nextToken());

            //양방향
            tree[a].add(b);
            tree[b].add(a);
        }

        for(int j = 1 ; j <=V ; j++){
            
            //ans가 false면 굳이 더 검사 x
            if(!visited[j] && ans){
                bfs(j);
            }
        }

        System.out.println(ans ? "YES" : "NO");

        }
    }

    
    //BFS
    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        //큐가 빌 때까지 반복
        while(!queue.isEmpty()){
            int current = queue.poll();
            // i에는 tree[current] 리스트의 각 원소가 순서대로 들어온다
            
            
            for(int i : tree[current]){
                if(visited[i]){
                    //이미 방문한 이웃인데, 같은 그룹 -> 이분 그래프 x
                    if(grouped[i] == grouped[current]){
                        ans = false;
                        return;
                    }
                }else{
                    visited[i] = true;
                    //노드 그룹을 반대로 줌 ex)현재가 1 이면 0부여
                    grouped[i] = 1 - grouped[current];
                    queue.add(i);
                }
            }
        }
    }
}