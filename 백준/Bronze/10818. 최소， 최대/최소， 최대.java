import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
           // BufferedReader를 사용하여 빠른 입력 처리
           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
           // 첫 번째 줄: 정수 개수 입력
           int N = Integer.parseInt(br.readLine());
   
           // 두 번째 줄: N개의 정수를 공백 기준으로 입력받아 배열로 변환
           StringTokenizer st = new StringTokenizer(br.readLine());
           int min = Integer.MAX_VALUE;
           int max = Integer.MIN_VALUE;
   
           // N개의 숫자를 반복문으로 확인하면서 최솟값과 최댓값을 갱신
           for (int i = 0; i < N; i++) {
               int num = Integer.parseInt(st.nextToken());
               min = Math.min(min, num);
               max = Math.max(max, num);
           }

           System.out.println(min + " " + max);
       }
    }