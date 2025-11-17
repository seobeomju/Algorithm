import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int  N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<Integer>();
    //     Stack<Integer> CheckStack = new Stack<Integer>();
    //     Stack<Integer> DeleteStack = new Stack<Integer>();

        long result =0;
    //     for (int i = 0; i < N; i++) {
    //         int high = Integer.parseInt(br.readLine());
    //         InputStack.push(high);
    //     }

    //     CheckStack.push(InputStack.pop());

    //     while(!InputStack.isEmpty()){
    //         int val = InputStack.pop();

    //         while(!CheckStack.isEmpty()){
    //             if(val < CheckStack.peek()){
    //                 CheckStack.push(val);
    //             }else{
    //                 DeleteStack.push(CheckStack.pop());
    //                 result ++;
    //             }
    //         }

    //         while (!DeleteStack.isEmpty()) {
    //             CheckStack.push(DeleteStack.pop());
    //         }
    //     }

    for (int i = 0; i < N; i++) {
        int h = Integer.parseInt(br.readLine());

        while(!stack.isEmpty() && stack.peek() <= h){
            stack.pop();
        }

        result += stack.size();

        stack.push(h);
    }
    
    
    System.out.println(result);
    }
}