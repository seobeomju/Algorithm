import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int N, M, K, X;
    static int start, end;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
         K = Integer.parseInt(st.nextToken());
         X = Integer.parseInt(st.nextToken());


        visited = new boolean[N+1];
        dist = new int[N+1];
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            //단방향
            list.get(start).add(end);
        }

        bfs(X);

        StringBuilder sb = new StringBuilder();
        boolean found = false;
        for (int i = 1; i <= N; i++) {
            if(dist[i] == K){
                sb.append(i).append("\n");
                found = true;
            }
        }

        if(!found) System.out.println(-1);
        else System.out.println(sb.toString());
    }

    //시작 됫에서 모든 도시까지의 최단거리
    public static void bfs(int X){
        Arrays.fill(dist, -1);

        Queue<Integer> q =new ArrayDeque<>();
        q.offer(X);
        visited[X] = true;
        dist[X] = 0;

        while(!q.isEmpty()){
            int now = q.poll();

            //현재 정점 거리가 이미 더 멀면 확장 x
            if(dist[now] == K) continue;

            for(int next : list.get(now)){
                if(!visited[next] ){
                    visited[next] = true;
                    dist[next] = dist[now] +1;
                    q.offer(next);
                }
            }
        }
        
    }
}