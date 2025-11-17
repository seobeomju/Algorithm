import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<Integer>();
        int N = Integer.parseInt(br.readLine());
        int num = 1;
        StringBuilder sb = new StringBuilder();
        boolean isPossible = true;
        
        for (int i = 0; i < N; i++) {
            int target = Integer.parseInt(br.readLine());
            
            while (num <= target){
                stack.push(num++);
                sb.append("+\n");
            }

            if(!stack.isEmpty() && stack.peek() == target){
                stack.pop();
                sb.append("-\n");
            }else{
                // System.out.println("NO");

                isPossible = false;
                 break;
            }

        }
        if(isPossible){
            System.out.println(sb);
        }else{
            System.out.println("NO");
        }
    }
}