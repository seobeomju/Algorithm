import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] house = new int[n];

        for (int i = 0; i < house.length; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);
        
        int left = 1;
        int right = house[n-1] - house[0];
        int result = 0;

        while(left<=right){
            int mid = (left + right)/2;

            if(canPlace(house,c,mid)){
                result = mid;
                left = mid+1;
            }else {
                right = mid -1;
            }

        }//end while

        System.out.println(result);
    }
    static boolean canPlace(int[] house, int c, int mid){
        int count =1;
        int lastLocation = house[0];

        for (int i = 0; i < house.length; i++) {
           if(house[i]-lastLocation >= mid){
            count ++;
            lastLocation = house[i];
           }

        }

        return count>=c;
    }
}