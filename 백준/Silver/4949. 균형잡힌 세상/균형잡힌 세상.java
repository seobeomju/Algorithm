import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();

            if(input.equals(".")){
                break;
            }
            Stack<Character> stack = new Stack<>();
            boolean isBalanced =true;

            for( char c : input.toCharArray()){
                if(c=='(' || c == '['){
                    stack.push(c);
                }else if( c==')'){
                    if(stack.isEmpty()||stack.peek() != '('){
                        isBalanced =false;
                        break;
                    }
                    stack.pop();
                }
                else if( c==']'){
                    if(stack.isEmpty()||stack.peek() != '['){
                        isBalanced =false;
                        break;
                    }
                    stack.pop();
                }
            }

            if(!stack.isEmpty()) isBalanced = false;

            sb.append(isBalanced?"yes":"no").append("\n");
        }

        System.out.println(sb);
    }

}