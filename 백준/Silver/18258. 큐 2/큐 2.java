import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        Queue<Integer> queueInt = new LinkedList<Integer>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int last = 0;
        while ( N-- > 0){
            st = new StringTokenizer(br.readLine());
            switch(st.nextToken()){
                case "push":
                    last = Integer.parseInt(st.nextToken());
                    queueInt.add(last);
                    
                    break;
                
                case "pop":
                    if(queueInt.size() != 0){
                        //System.out.println(queueInt.remove());
                        sb.append(queueInt.remove()).append("\n");
                    }else{
                        //System.out.println(-1);
                        sb.append(-1).append("\n");
                    }
                    break;
                    
                case "size":
                    //System.out.println(queueInt.size());
                    sb.append(queueInt.size()).append("\n"); 
                    break;
                
                case "empty":
                    if(queueInt.isEmpty() == true){
                        //System.out.println(1);
                        sb.append(1).append("\n");
                    }else{
                        //System.out.println(0);
                        sb.append(0).append("\n");
                    };
                    break;


                case "front":
                    //System.out.println(queueInt.isEmpty()? -1 : queueInt.peek());
                    sb.append(queueInt.isEmpty()? -1 : queueInt.peek()).append("\n");
                    break;

                case "back": 
                    //System.out.println(queueInt.isEmpty()?-1 : last);
                    sb.append(queueInt.isEmpty()?-1 : last).append("\n");
                    break;
            }

           }
              // 한 번에 출력
        System.out.print(sb);   
        
    }
}