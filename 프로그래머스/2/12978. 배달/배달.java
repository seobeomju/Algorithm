import java.util.*;

class Solution {
    // PriorityQueue에서 거리 순으로 정렬하기 위해 Comparable 구현
    static class Node implements Comparable<Node> {
        int dest, cost;
        
        public Node(int dest, int cost){
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        // 1번부터 N번 마을까지 사용하기 위해 N+1 크기로 생성
        ArrayList<Node>[] adjList = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            adjList[i] = new ArrayList<>();
        }
        
        // 도로 정보 등록 (양방향)
        for(int[] r : road) {
            int u = r[0];
            int v = r[1];
            int w = r[2];
            adjList[u].add(new Node(v, w));
            adjList[v].add(new Node(u, w));
        }
        
        int start = 1;
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        // 최단 거리 탐색을 위해 PriorityQueue 사용
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        
        while(!pq.isEmpty()){
            // ① 문법 수정: Node now = pq.poll();
            Node now = pq.poll();
            
            if(dist[now.dest] < now.cost) continue;
            
            for(Node next : adjList[now.dest]){
                if(dist[next.dest] > now.cost + next.cost){
                    dist[next.dest] = now.cost + next.cost;
                    pq.add(new Node(next.dest, dist[next.dest]));
                }
            }
        }
        
        // K 이하의 시간으로 배달 가능한 마을 개수 카운트
        for(int i = 1; i <= N; i++){
            if(dist[i] <= K) {
                answer++;
            }
        }
        
        return answer;
    }
}