import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void swap(int[] arr,int i, int j){
      int temp = arr[i];
      arr[i]= arr[j];
      arr[j]= temp;
    }
    public static void main(String[] args) throws IOException {
        // 코드 작성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       

       int N = Integer.parseInt(st.nextToken());
       int M= Integer.parseInt(st.nextToken());
       int [] arr = new int[N];
       for (int i = 0; i < arr.length; i++) {
            arr[i] =i+1;
       }
       for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            swap(arr,i-1,j-1);
       }
       StringBuilder sb = new StringBuilder();
       for(int result : arr){
        sb.append(result).append(" ");
       }
       System.out.println(sb);

    }
}