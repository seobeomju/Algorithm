import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    public static List<Integer>[] tree;
    public static boolean[] visited;
    public static int[] inout;
    public static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int  n = Integer.parseInt(br.readLine());
        String inoutValue = br.readLine();

        tree = new ArrayList[n+1];
        visited = new boolean[n+1];
        inout = new int[n+1];



        //각 인덱스에 리스트 할당
        for (int i = 0; i <=n; i++) {
            tree[i] = new ArrayList<>();
        }

        //실내야외 입력
        for (int i = 1; i <= n; i++) {
            inout[i] = inoutValue.charAt(i-1) - '0';
        }

        //트리 입력
        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer((br.readLine()));
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            tree[u].add(v);
            tree[v].add(u);

            if(inout[u] ==1 && inout[v] == 1){
                count += 2;
            }
        }

        for (int i = 1; i <=n ; i++) {
            int in = 0;
            if (inout[i]==0){
                if(!visited[i]){
                    visited[i] = true;
                    in = dfs(i);
                    count += in*(in-1);
                }
            }
        }
        System.out.println(count);

    }
    public static int dfs(int start){
        int in =0;
        for(int v : tree[start]){
            if(inout[v] == 1){
                in++;
            }else if(!visited[v]){
                visited[v] = true;
                in += dfs(v); //실외면 탐색 계속
            }
        }
        return in;
    }
}