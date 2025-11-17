import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력을 저장할 스택 (수열을 통째로 역순으로 만들기 위한 용도)
        Stack<Integer> inputStack = new Stack<>();
        for (int i = 0; i < N; i++) {
            inputStack.push(Integer.parseInt(st.nextToken()));
        }

        // 오른쪽에서 나보다 큰 후보들을 저장하는 스택
        Stack<Integer> candStack = new Stack<>();

        // 각 원소의 오큰수를 오른쪽 → 왼쪽 순서로 저장
        Stack<Integer> resultStack = new Stack<>();

        // 오른쪽 끝부터 왼쪽으로 이동하는 효과
        while (!inputStack.isEmpty()) {
            int cur = inputStack.pop();

            // 나보다 작거나 같은 값은 더 이상 후보가 될 수 없음 → 제거
            while (!candStack.isEmpty() && candStack.peek() <= cur) {
                candStack.pop();
            }

            // 이제 candStack의 top이 오큰수 (없으면 -1)
            if (candStack.isEmpty()) {
                resultStack.push(-1);
            } else {
                resultStack.push(candStack.peek());
            }

            // 나는 다음 원소 기준으로 오른쪽에 있는 값이 되므로 후보 스택에 push
            candStack.push(cur);
        }

        // resultStack에는 오른쪽 → 왼쪽 순서로 쌓여 있으므로
        // 다시 pop 하면서 왼쪽 → 오른쪽 순서로 출력
        StringBuilder sb = new StringBuilder();
        while (!resultStack.isEmpty()) {
            sb.append(resultStack.pop()).append(' ');
        }

        System.out.println(sb.toString());
    }
}