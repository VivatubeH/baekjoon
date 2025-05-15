import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 사용자로부터 N을 입력받습니다.

        // 사용자가 입력한 N을 토대로 자릿수를 구하는 메서드를 생성합니다.
        int answer = getLengthByNumber(N);

        System.out.print(answer); // 어차피 하나 출력할 거면 print로 출력하겠습니다.
    }

    // 연산은 단순하게 구현하겠습니다.
    public static int getLengthByNumber(int num) {
        int length = String.valueOf(num).length(); // 해당 수의 자릿수를 구합니다.

        // length 자릿수라면 1 x 9 + 2 x 90 + 3 x 900 + 4 x 9000 + 5 x 90000 + 6 x 900000 + 8 x 9000000까지 다 들어가야함
        // 1자릿수 -> 9까지 : 1 x 9 + 2 x 6 = 15일 때
        // 2자릿수 -> 99까지 : 1 x 9 + 2 x 90 + 3 x 21 =
        // 3자릿수 -> 999까지 : 1 x 9 + 2 x 90 + 3 x 900
        if (length == 1) { // 한 자릿수면
            return num; // 그대로
        } else if (length == 2) { // 두 자릿수면
            return 9 + (num - 9) * 2;
        } else if (length == 3) { // 세 자릿수면
            return 9 + 2 * 90 + (num - 99) * 3;
        } else if (length == 4) { // 네 자릿수면
            return 9 + 2 * 90 + 3 * 900 + (num - 999) * 4;
        } else if (length == 5) {
            return 9 + 2 * 90 + 3 * 900 + 4 * 9000 + (num - 9999) * 5;
        } else if (length == 6) {
            return 9 + 2 * 90 + 3 * 900 + 4 * 9000 + 5 * 90000 + (num - 99999) * 6;
        } else if (length == 7) {
            return 9 + 2 * 90 + 3 * 900 + 4 * 9000 + 5 * 90000 + 6 * 900000 + (num - 999999) * 7;
        } else if (length == 8) {
            return 9 + 2 * 90 + 3 * 900 + 4 * 9000 + 5 * 90000 + 6 * 900000 + 7 * 9000000 + (num - 9999999) * 8;
        }

        return 9 + 2 * 90 + 3 * 900 + 4 * 9000 + 5 * 90000 + 6 * 900000 + 7 * 9000000 + 8 * 90000000 + 9;
    }
}
