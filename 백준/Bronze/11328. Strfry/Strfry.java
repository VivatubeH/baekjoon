import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 첫 줄에 테스트 케이스 수 입력
        // N개의 줄에 걸쳐서 두 문자열을 입력받는다.
        for (int i = 0; i < N; i++) {
            // 공백을 기준으로 2개의 문자열을 입력받는다.
            StringTokenizer token = new StringTokenizer(br.readLine());
            String word1 = token.nextToken();
            String word2 = token.nextToken();

            // 두 문자열의 등장 빈도를 체크할 배열을 만든다.
            int[] frequency1 = new int[26];
            int[] frequency2 = new int[26];

            // 두 문자열을 각각 빈도를 체크한다.
            checkFrequency(word1, frequency1);
            checkFrequency(word2, frequency2);
            // 빈도 체크한 두 배열이 일치하면 가능하므로 Possible 출력
            // 일치하지 않으면 불가능하므로 Impossible을 출력한다.
            boolean isSame = true; // 두 배열이 같은지 체크하기 위한 변수입니다.
            for (int j = 0; j < 26; j++) {
                // 하나라도 다르게 되면
                if (frequency1[j] != frequency2[j]) {
                    isSame = false; // 일치하지 않으니 false로 바꾸고
                    break; // 더 이상의 확인은 불필요합니다.
                }
            }
            // 같으면 Possible 출력, 다르면 Impossible을 출력합니다.
            if (isSame) System.out.println("Possible");
            else System.out.println("Impossible");
        }
    }

    public static void checkFrequency(String str, int[] array) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            array[ch - 'a']++;
        }
    }
}
