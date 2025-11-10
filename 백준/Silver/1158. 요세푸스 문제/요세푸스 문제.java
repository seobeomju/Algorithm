import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        LinkedList<Integer> josephus = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            josephus.add(i);
        }
        ListIterator<Integer> cursor = josephus.listIterator();
        sb.append('<');
        while(!josephus.isEmpty()){
            int value = 0;
            for (int i = 0; i < K; i++) {
                if(!cursor.hasNext()){
                    cursor = josephus.listIterator();
                } 
                value = cursor.next();
           }
           
            cursor.remove();
            
            sb.append(value);
           
            if(!josephus.isEmpty()){
            sb.append(", ");
          }
        }
        
        sb.append(">");
        System.out.println(sb.toString());
    }
}