import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        } 
        int max = 0;
        int index = 0;
        for (int i = 0; i <= arr.length-1; i++) { 
          if(arr[i]>max){
            max = arr[i];
            index = i+1;
          }
        }
        System.out.println(max + "\n" + index);
    }
}