import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

class Main {
        static class Point { int x, y; 
            Point(int x, int y){
                this.x=x;
                this.y=y;
            }
         }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N+1][N+1];

        // 사과 위치
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }

        // 방향 전환 명령 저장
        int L = Integer.parseInt(br.readLine());
        Map<Integer, Character> turns = new HashMap<>();
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            turns.put(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
        }

        // 덱과 방향 변수 초기화
        Deque<Point> snake = new LinkedList<>();
        snake.offer(new Point(1, 1));
        board[1][1] = 2;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int dir = 0, time = 0;

        // 시뮬레이션
        while (true) {
            time++;
            Point head = snake.peekFirst();
            int nx = head.x + dx[dir];
            int ny = head.y + dy[dir];

            // 벽 또는 자기 몸과 부딪히면 종료
            if (nx < 1 || nx > N || ny < 1 || ny > N || board[nx][ny] == 2) {
                System.out.println(time);
                break;
            }

            // 사과 있으면 머리만 추가
            if (board[nx][ny] == 1) {
                board[nx][ny] = 2;
                snake.offerFirst(new Point(nx, ny));
            } else {
                // 빈 칸: 머리 추가 + 꼬리 제거
                board[nx][ny] = 2;
                snake.offerFirst(new Point(nx, ny));
                Point tail = snake.pollLast();
                board[tail.x][tail.y] = 0;
            }

            // 방향 전환 처리
            if (turns.containsKey(time)) {
                char c = turns.get(time);
                if (c == 'L')      dir = (dir + 3) % 4;
                else /* 'D' */     dir = (dir + 1) % 4;
            }
        }
    }
}
