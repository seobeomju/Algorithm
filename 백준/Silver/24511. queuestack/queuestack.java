import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

    public static int N ,M;
    public static int[] A;
    public static int[] B;
    public static int[] C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        A= new int[N];
        B = new int[N];


        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i =0; i<N; i++){
            B[i] = Integer.parseInt(st.nextToken());
            
        }

        ArrayList<Integer> qeueus = new ArrayList<>();
        for (int i = 0; i <N ; i++) {
            if(A[i] == 0){
                qeueus.add(B[i]);
            }
            
        }

        int K = qeueus.size();


        M = Integer.parseInt(br.readLine());
        C= new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i =0; i<M; i++){
            C[i] = Integer.parseInt(st.nextToken());
    
        }

        StringBuilder sb = new StringBuilder();
        for(int k = 1; k<=M ; k++){
            if(k<=K){
                sb.append(qeueus.get(K-k));
            }
            else{
                sb.append(C[k-K-1]);
            }
            if(k<M){
                sb.append(' ');
            }
        }

        System.out.println(sb.toString());


    }


}