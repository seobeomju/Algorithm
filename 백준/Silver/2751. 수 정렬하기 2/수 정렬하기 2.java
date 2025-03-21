import java.io.*;
import java.util.*;
// 퀵소트는 시간이 초과
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);  // 내부적으로 Dual-Pivot QuickSort 사용

        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append("\n");
        }

        System.out.print(sb);
    }
}