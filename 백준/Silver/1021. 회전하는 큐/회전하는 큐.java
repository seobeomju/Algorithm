import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       Deque<Integer> deque = new ArrayDeque<>();
       StringTokenizer st = new StringTokenizer(br.readLine()); 
       int N = Integer.parseInt(st.nextToken());
       int M = Integer.parseInt(st.nextToken());

       int count = 0;
       if(M>N){
        throw new IllegalArgumentException("M은 N보다 클 수 없습니다.");
       }


       
       for(int i =1; i<=N; i++){
        deque.addLast(i);
       }
       
       st = new StringTokenizer(br.readLine());

       for(int i =0; i<M; i++){
        int x = Integer.parseInt(st.nextToken());
        int target_idx = 0;
        int half_idx =0;

        for(int val : deque){
            if(val == x){
                break;
            }
            target_idx ++;
        }

        if(deque.size()%2 ==0){
            half_idx = deque.size()/2-1;
        }else{
            half_idx = deque.size()/2;
        }
        
        if(target_idx <= half_idx){
            for (int j = 1; j <= target_idx; j++) {
                int temp = deque.removeFirst();
                deque.addLast(temp);
                count ++;
            }

        }else{

            for (int j = 1; j <= deque.size() - target_idx; j++) {
                int temp = deque.removeLast();
                deque.addFirst(temp);
                count ++;
            }
        }

        deque.removeFirst();
       }

       System.out.println(count);
    }
}