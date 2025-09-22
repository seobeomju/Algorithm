import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static int N,K;
    public static int W,V;
    public static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] dp = new int[K+1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer((br.readLine()));
            W = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());

            //현재 물건을 넣을지 말지를 선택해서 갱신하는 과정
            //거꾸로 도는 이유는 물건을 한번만 쓰기 위해서
            for (int j = K; j >= W; j--) {
                dp[j] = Math.max(dp[j], dp[j - W] + V);
            }
        }

        System.out.println(dp[K]);
    }
}