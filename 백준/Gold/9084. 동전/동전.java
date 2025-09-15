import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static int T, N, M;
    public static int[] coin;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            // 동전 개수
            N = Integer.parseInt(br.readLine());
            coin = new int[N];

            // 동전 종류 입력
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                coin[i] = Integer.parseInt(st.nextToken());
            }

            M = Integer.parseInt(br.readLine());

            System.out.println(solveCase(N, coin, M));
        }
    }

    //  한 테스트 케이스 처리 함수
    public static int solveCase(int n, int[] coin, int m) {
        dp = new int[m + 1];
        dp[0] = 1; // 0원을 만드는 방법 = 1가지

        for (int i = 0; i < n; i++) {       // 각 동전에 대해
            for (int j = coin[i]; j <= m; j++) { // 목표 금액까지 dp 갱신
                dp[j] += dp[j - coin[i]];
            }
        }

        return dp[m];
    }
}
