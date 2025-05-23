import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//메모리 초과
// Parametric Search로 풀어야 함함
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int k =Integer.parseInt(br.readLine());


        long left = 1;
        long right = k;
        long result = 0;

        
        while(left<=right){
            long mid = (left+right)/2;
            long count = 0;

            //mid이하의 갯 수 체크
            for (int i = 1; i <= N; i++) {
                count += Math.min(mid/i, N);
            }

            if(count < k){
                left = mid +1;
            }
            else{
                result = mid;
                right = mid-1;
            }
        }

        System.out.println(result);
    }
}