import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // A의 앞이나 뒤에 아무 알파벳이나 추가할 수 있다.
        // 핵심은 A의 사이에 단어를 추가할 수 없으니
        // A라는 단어는 앞이나 뒤에 추가하든 그대로 간다는 것이다.
        // 그렇다면 A라는 단어 자체는 앞으로 가거나 뒤로 가거나 인덱스만 계속 이동하게 된다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        String word1 = tokenizer.nextToken();
        String word2 = tokenizer.nextToken();
        int min = 50;
        int diff = 0;

        for(int j = 0; j <= word2.length() - word1.length(); j++) { // B의 인덱스 j
            diff = 0;
            for (int i = 0; i < word1.length(); i++) { // A의 인덱스 i는 불변인데
                if (word1.charAt(i) != word2.charAt(i+j)) { // B의 인덱스는 변해야 함.
                    diff++;
                }
            }
            if (diff <= min) {
                min = diff;
            }
        }
        System.out.println(min);
    }
}