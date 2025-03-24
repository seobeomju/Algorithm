import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        //이거는 정렬을 해주진 않지만 중복제거의 효율
        Set<String> words = new HashSet<>(); // 중복 제거를 위한 Set 개신기

        for(int i=0; i<N;i++){
            words.add(br.readLine()); // 중복된 단어는 자동 제거됨 
        }
        List<String> wordList = new ArrayList<>(words);
        
        //길이가 같으면 사전순, 다르면 길이 순으로 정렬
        Collections.sort(wordList, ( a, b) ->{
            if(a.length() == b.length()){
                return a.compareTo(b);
            }
            return a.length() - b.length();
        });

        for(String word : wordList){
            sb.append(word).append("\n");
        }
        System.out.println(sb);
    }
}