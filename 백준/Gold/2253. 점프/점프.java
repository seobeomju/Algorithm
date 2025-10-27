import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Main {
    static int N, M;
    static int[] stoneBrdg;
    static ArrayDeque<int[]> current = new ArrayDeque<>();
    static ArrayDeque<int[]> next = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        InputValue(br);
        System.out.println(solve());
    }

    private static void InputValue(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        stoneBrdg = new int[N + 1];
        for (int i = 0; i < M; i++) {
            int smallStone = Integer.parseInt(br.readLine());
            stoneBrdg[smallStone] = 1;
        }

    }

    private static int solve() {
        if (N == 2) {
            return 1;
        }
        if (stoneBrdg[2] == 1) {
            return -1;
        }
        int V_MAX = (int) Math.sqrt(2 * N) + 2;
        int[][] visited = new int[N + 1][V_MAX + 1];
        int X = 1;
        current.add(new int[] { 2, 1 });
        visited[2][1] = 1;
        while (!current.isEmpty()) {
            while (!current.isEmpty()) {
                int[] s = current.poll();
                int pos = s[0], v = s[1];

                for (int i = -1; i <= 1; i++) {
                    int nv = v + i;
                    int npos = pos + nv;
                    if (!isValidMove(nv, npos, V_MAX, visited)) {
                        continue;
                    }
                    if (npos == N) {
                        return X + 1;
                    }
                    visited[npos][nv] = X + 1;
                    next.add(new int[] { npos, nv });
                }
            }
            swap();
            next.clear();
            X++;
        }

        return -1;
    }

    private static boolean isValidMove(int nv, int npos, int V_MAX, int[][] visited) {
        return (nv >= 1 && nv <= V_MAX)
                && (npos <= N)
                && (stoneBrdg[npos] == 0)
                && (visited[npos][nv] == 0);
    }

    private static void swap() {
        ArrayDeque<int[]> tmp = current;
        current = next;
        next = tmp;
    }

}