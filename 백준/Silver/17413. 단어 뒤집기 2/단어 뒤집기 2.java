import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 사용자에게 문자열 s를 입력받습니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();

        // 출력을 할 때는 똑바로 출력하는 부분은 < 부터 >까지만 입니다.
        // 그 외는 전부 뒤집어서 출력해야 합니다.
        // 태그 안인지 태그 밖인지를 구분하기 위한 변수 isInTag를 만듭니다.
        boolean isInTag = false;

        // 현재 단어를 쌓기 위한 StringBuilder를 생성합니다.
        StringBuilder currentWord = new StringBuilder();
        // 정답을 담기 위한 StringBuilder를 생성합니다.
        StringBuilder answer = new StringBuilder();
        /*
            <를 만났다 -> 현재까지 쌓은 단어를 뒤집고 출력한다. 이후 태그 안으로 상태 전환.
            >를 만났다 -> 태그 종료, 그대로 출력
            태그 안 -> 무조건 그대로 출력
            태그 밖인데 공백을 만남 -> 지금까지 단어 뒤집고 출력 + 공백
            태그 밖이고 문자임 -> 단어를 쌓는다.
            문자열 끝 -> 단어에 남은 게 있다면 뒤집어서 출력

            -> 태그 안일 때는 그대로 다 출력해버리고
            -> 태그 바깥일 때만 단어버퍼에 쌓는다. ( 공백 때 뒤집기 )
            -> 태그 바깥이고 문자열의 끝을 만나면
         */
        // 문자열 s를 첫 번째 인덱스부터 끝까지 순회합니다.
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i); // i번째 문자를 검사합니다.

            if (ch == '<') { // 태그를 만나면
                answer.append(currentWord.reverse()); // 현재까지 쌓은 단어를 뒤집어서 출력한다.
                currentWord.setLength(0);
                isInTag = true; // 태그 안으로 상태를 전환한다.
            } else if (ch == '>') { // 태그가 끝나는 신호를 만나면
                answer.append('>'); // 태그를 닫아줍니다.
                isInTag = false; // 태그 종료
            }

            if (isInTag) {
                answer.append(ch); // 태그 내라면 무조건 그대로 출력합니다.
            } else if (!isInTag) { // 태그 밖인데
                if (ch == ' ') { // 공백을 만나면
                    answer.append(currentWord.reverse()); // 현재까지 단어를 뒤집고 출력합니다.
                    answer.append(' '); // 공백을 뒤에 붙입니다.
                    currentWord.setLength(0);
                } else { // 태그 바깥인데 문자라면 단어를 쌓아야 합니다.
                    if (ch != '>') {
                        currentWord.append(ch);
                    }
                }
            }

            if (i == s.length() - 1) { // 문자에 마지막에 도달하면
                answer.append(currentWord.reverse()); // 남아있는 단어를 뒤집어서 출력합니다.
            }
        }

        System.out.println(answer);
    }
}
