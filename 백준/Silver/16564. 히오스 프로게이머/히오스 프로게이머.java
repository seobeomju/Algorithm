
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Parametric Search 
//시간 초과
class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] character = new int[N];
        
        for (int i = 0; i < character.length; i++) {
            character[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(character);

        int left = character[0];
        int right = character[N-1] + k;
        int result = 0;

        while (left<=right) {
            int mid = (right + left) /2;

            if(goalLevel(character,mid,k)){
                result = mid;
                left = mid +1;
            }else{
                right = mid-1;
            }
            
        }//end while

        System.out.println(result);

    }


    static boolean goalLevel(int[] character, int mid, int k){
        //int need = 0; 오버플로우 방지
        long need =0;
        for(int characters : character){
            if(characters < mid){
                need+=(mid - characters);
            }

            if(need > k ) return false;
        }

        return need<=k;
    }
}