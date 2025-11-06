import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.nextLine(); // 단어 S를 입력받는다.
        // 0번에 a ~ 25번에 z의 등장 빈도를 저장하기 위해 배열
        int[] counting = new int[26];
        // 메서드를 통해 counting 합니다.
        checkCount(S, counting);
        // 반복문을 돌면서 결과를 출력해주면 됩니다.
        // 이 때, 한번에 출력하기 위해 StringBuilder를 통해 저장하겠습니다.
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            // 백준에서 마지막에 " "을 추가해도 정답으로 인정되니
            // 별도의 조건 검사 없이 모든 단어에 공백을 추가합니다.
            answer.append(counting[i]).append(" ");
        }
        System.out.print(answer); // 정답을 출력합니다/
    }

    // 해당 단어의 알파벳 빈도를 체크하기 위한 메서드
    public static void checkCount(String word, int[] array) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i); // 해당 단어의 i번째 문자에 대해서
            array[ch - 'a']++; // ch가 'a'라면 0, ch가 'z'라면 25로 매핑해서 체크합니다.
        }
    }
}
