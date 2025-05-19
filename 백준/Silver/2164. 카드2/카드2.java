import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    
    
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        while (q.size() != 1){
            Card(q);
        }
        System.out.println(q.element());
    }

    public static void Card (Queue q ){
        q.remove();
        int head = (int) q.poll();
        q.offer(head); 
    }
}