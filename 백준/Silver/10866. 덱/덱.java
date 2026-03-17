import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        // StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i<N; i++){
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            String commend = st.nextToken();
            
            if(commend.equals("push_back")){
                Integer number = Integer.parseInt(st.nextToken());
                deque.addLast(number);
            }

            if(commend.equals("push_front") ){
                Integer number = Integer.parseInt(st.nextToken());
                deque.addFirst(number);
            }

            if(commend.equals("pop_front") ){
                if(deque.isEmpty()){
                    System.out.println(-1);
                    // sb.append(-1);
                }else{
                    System.out.println(deque.getFirst());
                    // sb.append(deque.getFirst());
                    deque.removeFirst();
                }
            }

            if(commend.equals("pop_back") ){
                if(deque.isEmpty()){
                    System.out.println(-1);
                    // sb.append(-1);
                }else{
                    System.out.println(deque.getLast());
                    // sb.append(deque.getLast());
                    deque.removeLast();
                }
            }

            if(commend.equals("front")){
                try {
                    System.out.println(deque.getFirst());
                    // sb.append(deque.getFirst());
                } catch (Exception e) {
                    System.out.println(-1);
                    // sb.append(-1);
                }
            }
            
            if(commend.equals("back")){
                try {
                    System.out.println(deque.getLast());
                    // sb.append(deque.getLast());
                } catch (Exception e) {
                    System.out.println(-1);
                    // sb.append(-1);
                }
            }

            if(commend.equals("empty")){
                if(deque.size() != 0){
                    System.out.println(0);
                    // sb.append(0);
                }else{
                    System.out.println(1);
                    // sb.append(1);
                }
            }

            if(commend.equals("size")){
                System.out.println(deque.size());
                // sb.append(deque.size());
            }
        }


    }
}