import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        //결과 저장 용도
        StringBuilder sb = new StringBuilder();
        
        // n 입력 받음 
        int n = Integer.parseInt(br.readLine());

        //입력 받을 배열 생성
        int[] arr = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //오름차순 정렬
        Arrays.sort(arr);

        //m 입력 받음
        int m = Integer.parseInt(br.readLine());

        //입력받은 숫자가 존재하면 1 존재 하지 않으면 0을 반환
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());

            int in = Arrays.binarySearch(arr, num);
            
            //존재하면 0 존재하지 않으면 1
            if(in < 0){
                sb.append(0+"\n");
            }else{
                sb.append(1+"\n");
            }
        }
        
        //결과 출력
        System.out.println(sb);

    }
}