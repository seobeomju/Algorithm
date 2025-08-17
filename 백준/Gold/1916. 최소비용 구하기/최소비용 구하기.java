import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//다익스트라 문제 풀이
//BFS는 간선의 가중치가 없는 경우 
//가중치가 있을 경우 다익스트라

class Main {
    // 그래프 간선 저장 및 우선순위 큐 원소로 사용
    static class Node{
        int v;
        int cost;
        public Node(int v, int cost){
            this.v=v;
            this.cost=cost;
        }
    }

    //인접 리스트
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static boolean visited[];
    //최선의 비용
    static int dist[];
    //미도착
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        for (int i =0; i<= N; i++ ){
            graph.add(new ArrayList<>());
        }

        dist = new int[N+1];
        visited = new boolean[N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // a->b에 c라는 가중치
            graph.get(a).add(new Node(b,c));

            //양방향이면 추가
            //garph.get(b).add(new Node(a,c));
        }

        st = new StringTokenizer(br.readLine());

        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        solution(u);
        System.out.println(dist[v]);
    }

    public static void solution(int start){
        //모든 정점까지의 거리를 무한대로 초기화
        //Arrays.fill은 다 초기화 시킴
        Arrays.fill(dist,INF);
        //우선순위 큐: 비용이 작은 순 정렬(내림차순)
        PriorityQueue<Node> queue = new PriorityQueue<>(((o1,o2)-> o1.cost - o2.cost));
        
        //시작 넣음
        queue.add(new Node(start, 0));
        dist[start] = 0;

        //큐가 빌때까지 반복
        while(!queue.isEmpty()){
            //현재까지 가장 비용이 낮은 노드 꺼냄
            Node now = queue.poll();

            //최단거리로 확정 x
            if(!visited[now.v]){
                visited[now.v] = true;

                //모든 정점 탐색
                for(Node next : graph.get(now.v)){

                    //비용이 더 낮으면 갱신
                    if(dist[next.v]> dist[now.v] + next.cost){
                        dist[next.v] = dist[now.v] + next.cost;
                        queue.add(new Node(next.v,dist[next.v]));
                    }
                }
            }
        }
    }
}