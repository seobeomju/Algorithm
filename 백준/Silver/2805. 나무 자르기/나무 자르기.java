import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Parametric Search -> 최적화문제를 결정 문제로 바꿔서 이진 탐색으로 푸는 방법법
class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] trees = new int[n];
        int max =0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max,trees[i]);
        }

        int left = 0;
        int right = max;
        int result =0;


        while(left <= right){
            int mid = (left+right) / 2;
            //조건이 만족(true)면 result에 저장 더 높은 높이도 가능한지 확인
            if (isEnough(trees,mid,m)){
                result = mid;
                left = mid + 1;
            }else{
                right = mid -1; //조건이 만족 못합(false) 높이를 더 낮춤춤
            }
        }//end while

        System.out.println(result);
    }

    // 결정 함수: mid 높이로 자를 때 M미터 이상 가능한가?
    static boolean isEnough(int[] trees, int height, int target){
        long sum = 0;
        for(int tree : trees){
            if(tree>height){
                sum+=(tree - height); //높이보다 큰 나무만 자름
            }
        }//end for
        return sum >= target; // 필요한 나무 길이 이상이면 true, 아니면 false
    }
}