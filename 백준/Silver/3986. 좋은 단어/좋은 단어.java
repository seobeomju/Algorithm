import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < N; i++) {
            String Input = br.readLine();
            Stack<Character> stack = new Stack<>();
            for (char c : Input.toCharArray()) {
                if(!stack.isEmpty() && stack.peek() == c){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }

            if(stack.isEmpty()){
                count++;
            }
        }

        System.out.println(count);
    }
}