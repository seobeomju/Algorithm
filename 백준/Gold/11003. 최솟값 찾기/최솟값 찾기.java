import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
// 1.  현재 숫자 입력
// 2. 덱 내에 있는 수 중 뒤에서 부터 자기보다 작은 값을 만나기 전까지 빼기
// 3. 덱에 현재 숫자와 그 숫자의 위치를 넣는다
// 4. 덱의 가장 앞에 잇는 수가 범위에 걸리면 뺀다.
// 5. 현재 덱의 가장 앞에 있는 수가 지금까지의 최솟값 dlek.


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Deque<int[]> deque = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());

            while(!deque.isEmpty()){
                int[] n = deque.getLast();
                if(n[0] >= input){
                    deque.pollLast();
                }else break;
            }

            deque.addLast(new int[] {input,i});
            if(deque.getFirst()[1]==i-L){
                deque.pollFirst();
            }

            int[] front = deque.getFirst();
            sb.append(front[0] + " ");
        }

        System.out.println(sb);
    }
}