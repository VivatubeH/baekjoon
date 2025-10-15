import java.io.*;
import java.util.*;

public class Main {
    public static int count = 0;
    public static String[] instruction;

    public static void main(String[] args) throws IOException {
        input();
        service();
        System.out.print(count);
    }

    public static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            instruction = new String[N];
            for (int i = 0; i < N; i++) {
                instruction[i] = br.readLine();
            }
        }
    }

    public static void service() {
        // 서로 다른 세 자리 숫자가 후보가 되야 한다.
        for (int i = 123; i <= 987; i++) {
            String candidateNum = String.valueOf(i);
            char firstCh = candidateNum.charAt(0);
            char secondCh = candidateNum.charAt(1);
            char thirdCh = candidateNum.charAt(2);
            // 서로 다른 세자리수가 아니면 검사할 필요가 없다.
            if (firstCh == secondCh || secondCh == thirdCh || thirdCh == firstCh) {
                continue;
            }
            // 0이 포함된 숫자도 검사할 필요가 없다.
            if (secondCh == '0' || thirdCh == '0') {
                continue;
            }
            // instruction과 해당 숫자의 조건이 일치하는지 체크한다.
            boolean isValid = true;
            for (int j = 0; j < instruction.length; j++) {
                StringTokenizer st = new StringTokenizer(instruction[j]);
                String testNum = st.nextToken();

                char testFirstCh = testNum.charAt(0);
                char testSecondCh = testNum.charAt(1);
                char testThirdCh = testNum.charAt(2);

                int strike = Integer.parseInt(st.nextToken());
                int ball = Integer.parseInt(st.nextToken());

                int strikeCount = 0;
                int ballCount = 0;

                if (firstCh == testFirstCh || firstCh == testSecondCh || firstCh == testThirdCh) {
                    if (firstCh == testFirstCh) {
                        strikeCount++;
                    } else {
                        ballCount++;
                    }
                }
                if (secondCh == testFirstCh || secondCh == testSecondCh || secondCh == testThirdCh) {
                    if (secondCh == testSecondCh) {
                        strikeCount++;
                    } else {
                        ballCount++;
                    }
                }
                if (thirdCh == testFirstCh || thirdCh == testSecondCh || thirdCh == testThirdCh) {
                    if (thirdCh == testThirdCh) {
                        strikeCount++;
                    } else {
                        ballCount++;
                    }
                }

                if (strike != strikeCount || ball != ballCount) {
                    isValid = false;
                }
            }
            if (isValid) count++;
        }
    }
}
