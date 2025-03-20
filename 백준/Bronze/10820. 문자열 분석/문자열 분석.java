import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = br.readLine()) != null) {
            StringAnalayzer analayzer = new StringAnalayzer();
            analayzer.countString(str);
            analayzer.printResult();
        }
    }
}

// 문자열 분석기 클래스
class StringAnalayzer {
    // 각각 문자열의 소문자, 대문자, 숫자, 공백의 개수를 세는 변수입니다.
    // 각각 다른 값을 가져야 하므로 객체 생성이 필수입니다.
    private int lowerCase = 0;
    private int upperCase = 0;
    private int number = 0;
    private int blank = 0;

    // 문자열과 관련된 소문자, 대문자, 숫자, 공백을 세는 메서드입니다.
    public void countString(String str) {
        // 문자열 길이만큼 ( 단어 철자수만큼 탐색을 진행합니다. )
        for (int i = 0; i < str.length(); i++) {
            // i번째 글자를 char 변수에 담습니다.
            char indexCharacter = str.charAt(i);

            // 소문자 검사를 하는 부분입니다.
            if (indexCharacter >= 'a' && indexCharacter <= 'z') {
                lowerCase++; // 소문자면 소문자 개수를 카운팅합니다.
            }
            // 대문자 검사를 하는 부분입니다.
            if (indexCharacter >= 'A' && indexCharacter <= 'Z') {
                upperCase++;
            }
            // 숫자 검사를 하는 부분입니다.
            // char끼리의 비교니 아스키코드값끼리 비교가 됩니다.
            if (indexCharacter >= '0' && indexCharacter <= '9') {
                number++;
            }
            // 공백 검사를 하는 부분입니다.
            if (indexCharacter == ' ') {
                blank++;
            }
        }
    }

    public void printResult() {
        System.out.println(lowerCase + " " + upperCase + " " + number + " " + blank);
    }
}