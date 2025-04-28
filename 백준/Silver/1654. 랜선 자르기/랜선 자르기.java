import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int k, n;
    static int[] arr ;
    
    public static boolean solve(long x){
        long count = 0;
        for (int i = 0; i < k; i++) {
            count += arr[i] /x;
        }
        return count >= n;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         k = Integer.parseInt(st.nextToken());
         n = Integer.parseInt(st.nextToken());

        arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long start = 1;
        long end = Integer.MAX_VALUE; // 2^31 - 1

        while(start<end){
            long mid = (start+end+1)/2;

            if(solve(mid)){ 
                start=mid;
            }else {
                end= mid -1;
            }
        }

        System.out.println(start);

    }
}