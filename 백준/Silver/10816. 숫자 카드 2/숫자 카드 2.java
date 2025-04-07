import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//Hash Map: 빠르게 키(key)를 기반으로 데이터를 조회, 추가, 수정, 삭제
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
    
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> cardMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            //숫자 map에 넣기
            //없으면 1
            //있으면 개수 +1
            cardMap.put(num,cardMap.getOrDefault(num, 0)+1);
        }
        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int check = Integer.parseInt(st.nextToken()); 

            //해당 숫자가 있으면 cardMap값, 없으면 0
            sb.append(cardMap.getOrDefault(check, 0)).append(" ");
        }
        System.out.println(sb);
    }
}