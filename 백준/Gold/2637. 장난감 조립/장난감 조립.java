import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {
    static int N,M;
    static int[] indegree; //진입 차수
    static ArrayList<ArrayList<int[]>> graph; //graph[y] = {x,k}리스트
    static int[][]need;  //need[x][b] = x 1개에 필요한 기본 부품 b의 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        indegree = new int[N+1];

        graph = new ArrayList<>(N+1);
        for (int i =0; i<= N; i++){
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            graph.get(Y).add(new int[]{X,K});
            indegree[X] ++; //X의 진입차수 증가
        }

        need = new int[N+1][N+1];

        KahnSort();

        StringBuilder sb = new StringBuilder();
        for (int b = 0; b <=N; b++) {
            if(need[N][b] > 0){
                sb.append(b).append(' ').append(need[N][b]).append('\n');  //N은 완제품 need[N][b] => N이라는 완제품을 만드릭 위해 필요한 b의 갯수
            }
        }

        System.out.println(sb);
    }

    static void KahnSort(){
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <=N; i++) {
            if(indegree[i] ==0){
                q.addLast((i));
                need[i][i] =1;  //기본 부품은 자기 자신이 필요
            }
        }

        while (!q.isEmpty()){
            int cur = q.removeFirst(); //이미 기본 부품 레시피는 완성 => 진입 차수가 0이 되어야 큐에 들어가니깐

            for(int[] e: graph.get(cur)){

                //graph에 next와 k의 값이 들어가 있음
                int next = e[0];
                int k = e[1];

                for(int b =1;b<=N; b++){
                    if(need[cur][b] > 0){

                        //cur에 필요한 기본 부품을 next에도 구현
                        need[next][b] += need[cur][b] *k;
                    }
                }

                if( --indegree[next] ==0){ //집입차수 감소
                    q.addLast(next); //
                }
            }
        }
    }
}