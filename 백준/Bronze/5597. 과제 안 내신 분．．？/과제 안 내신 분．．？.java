import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[28];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=Integer.parseInt(br.readLine());
        }
        int[] result = new int[31];
        //30만큼 돌면서 arr에 값이 있으면 해당하는 result를 카운트 업
        for (int i = 0; i < arr.length; i++) {
            result[arr[i]]++;
        }
        for (int i = 1; i < result.length; i++) {
            if(result[i]==0){
                System.out.println(i); 
            }
        }
    }
}