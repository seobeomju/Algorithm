import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {

    public static int leftCount =0;
    public static int rightCount =0;
    public static void main(String[] args) throws IOException {
        Stack<String> stackStr = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        for (int i = 0; i < N; i++) {
         
            String input = br.readLine();
            stackStr.push(input);
        }

 // 스택에서 하나씩 꺼내서 괄호 유효성 검사
 for (int i = 0; i < N; i++) {
    String line = stackStr.get(i);

    int leftCount = 0;
    int rightCount = 0;
    boolean isValid = true;

    // 한 줄의 문자열을 문자 하나씩 순회
    for (int j = 0; j < line.length(); j++) {
        char ch = line.charAt(j);

        if (ch == '(') {
            leftCount++;
        } else if (ch == ')') {
            rightCount++;
        }

        // 여는 괄호보다 닫는 괄호가 많아지면 잘못된 괄호열
        if (rightCount > leftCount) {
            isValid = false;
            break;
        }
    }

    // 전체 괄호 수가 맞아야 유효함
    if (isValid && leftCount == rightCount) {
        System.out.println("YES");
    } else {
        System.out.println("NO");
    }
}
}
}