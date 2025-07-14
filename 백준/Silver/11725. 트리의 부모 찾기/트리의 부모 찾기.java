import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static int[] parents;
    public static List<Integer>[] tree;
    public boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n+1];
        parents = new int[n+1];

        //각 인덱스에 리스트 할당
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        //간선 정보 입력
        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt((st.nextToken()));
            int b = Integer.parseInt(st.nextToken());

            //양방향
            tree[a].add(b);
            tree[b].add(a);
        }

        bfs(1);

        //2번부터 부모 출력
        StringBuilder sb = new StringBuilder();
        for(int i = 2; i<=n; i++){
            sb.append(parents[i]).append(("\n"));
        }
        System.out.println(sb);
    }


    //BFS
    public static void bfs(int root){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);

        //큐가 빌 때까지 반복
        while(!queue.isEmpty()){
            int current = queue.poll();
            // i에는 tree[current] 리스트의 각 원소가 순서대로 들어온다
            for(int i : tree[current]){
                if ( parents[i] == 0){
                    parents[i] = current;
                    queue.add(i);
                }
            }
        }
    }
}