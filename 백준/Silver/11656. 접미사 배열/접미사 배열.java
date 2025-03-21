import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        // 입력받은 문자열 S를 뒤에서부터 잘라서 배열에 담겠습니다.
        ArrayList<String> words = new ArrayList<>();

        for (int i = S.length()-1; i >= 0; i--) {
            String word = S.substring(i);
            words.add(word);
        }

        // 이후 Collections.sort()로 오름차순 정렬합니다.
        Collections.sort(words);

        // 이후 하나씩 줄을 바꿔가면서 출력합니다.
        for (int i = 0; i < words.size(); i++) {
            System.out.println(words.get(i));
        }
    }
}
