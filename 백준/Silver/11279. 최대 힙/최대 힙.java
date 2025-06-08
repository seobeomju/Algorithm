import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //자바에서는 우선순위 큐를 통해 힙을 제공한다
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1,o2) -> o2-o1);
       

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N ; i++) {
            int x = Integer.parseInt(br.readLine());

            if(x == 0){
                if(heap.isEmpty()){
                    sb.append(0).append("\n");
                }else{
                sb.append(heap.poll()).append("\n");
                }

            }else{
                //0이 아닐시 heap에 x값을 넣는다
                heap.offer(x);
            }
        }

        System.out.println(sb);
    }
}