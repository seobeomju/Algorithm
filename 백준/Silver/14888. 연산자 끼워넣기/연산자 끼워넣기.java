import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    //최댓값을 최소로 초기화 해놓으면 처음엔 무조건 갱신되므로 최소로 초기화
    public static int MAX = Integer.MIN_VALUE;
    public static int MIN = Integer.MAX_VALUE;
    public static int[] operator = new int[4]; //연산자 갯수
    public static int[] number;  //숫자
    public static int N; //숫자의 개수 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        number = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            
            number[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(number[0],1);

        System.out.println(MAX);
        System.out.println(MIN);
    }
    public static void dfs(int num, int index){
        
        //마지막 숫자까지 계산
        if(index == N){
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN,num);
            return;
        }

        for(int i =0 ; i<4;i++){
            if(operator[i] > 0){
                operator[i] --;

                switch(i){
                    case 0: dfs(num+number[index],index+1); 
                    break;
                    case 1: dfs(num - number[index],index +1); 
                    break;
                    case 2: dfs(num*number[index],index +1);
                    break;
                    case 3: dfs(num/number[index], index+1);
                    break;
                }

                operator[i]++;
            }
        }
    }
}