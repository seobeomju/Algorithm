import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stackInt = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        while ( N-- > 0){
            st = new StringTokenizer(br.readLine());
            switch(st.nextToken()){
                case "push":
                    stackInt.push(Integer.parseInt(st.nextToken()));
                    break;
                
                case "pop":
                    if(stackInt.size() != 0){
                        System.out.println(stackInt.pop());
                    }else{
                        System.out.println(-1);
                    }
                    break;
                    
                case "size":
                    System.out.println(stackInt.size()); 
                    break;
                
                case "empty":
                    if(stackInt.empty() == true){
                        System.out.println(1);
                    }else{
                        System.out.println(0);
                    };
                    break;

                case "top":
                    System.out.println(stackInt.empty()? -1 : stackInt.peek());
                    break;
            }

        }
    }
}