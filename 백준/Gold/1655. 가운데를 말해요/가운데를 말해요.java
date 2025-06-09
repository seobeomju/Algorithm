import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        //작은 절반(max-heap)
        PriorityQueue<Integer> lowerHeap = new PriorityQueue<>((o1,o2)->o2-o1);

        //큰 절반(min-heap)
        PriorityQueue<Integer> upperHeap = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            offerHeap(x,lowerHeap,upperHeap);
            balanceHeap(lowerHeap, upperHeap);

            sb.append((lowerHeap.peek())).append("\n");
        
        }

        System.out.println(sb);

    }

    public static void offerHeap (
        int x,
        PriorityQueue<Integer> lowerHeap,
        PriorityQueue<Integer> upperHeap){
        
            if(lowerHeap.isEmpty() || x <= lowerHeap.peek()){
                lowerHeap.offer(x);
            }else{
                upperHeap.offer(x);
            }

    
    }

    public static void balanceHeap(
        PriorityQueue<Integer> lowerHeap,
        PriorityQueue<Integer> upperHeap){
            if(lowerHeap.size() - upperHeap.size() >= 2){
                upperHeap.offer(lowerHeap.poll());
            }

            else if(upperHeap.size() > lowerHeap.size() ){
                lowerHeap.offer((upperHeap.poll()));
            }
        }
}