import java.io.*;
import java.util.*;

public class Main {
    // 몇 번 사용했는지를 체크합니다.
    public static int[] checkTimes = new int[10];

    public static void main(String[] args) throws IOException {
        // 사용자로부터 입력을 받기 위한 BufferedReader 클래스를 생성합니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 다솜이의 방 번호 N이 주어집니다. -> 편한 처리를 위해 String으로 받고 자릿수로 처리하겠습니다.
        String N = br.readLine();

        // 방 번호의 첫 자리부터 끝자리에 대해서 탐색을 수행합니다.
        for (int i = 0; i < N.length(); i++) {
            // 검사는 메서드를 통해서 수행합니다.
            // 매개변수로 i번째 문자를 넘겨서 체크를 수행합니다.
            usePlasticNumber(N.charAt(i));
        }

        // 정답을 구하기 위한 변수 max입니다.
        int max = 0;
        // 빈도를 구하기 위한 변수 frequency입니다.
        int frequency = 0;

        // 6을 사용하는 것과 9를 사용하는 것은 같기 때문에 6에 대해서는 2로 나누고 1을 더하고( 세트당 2번 사용 가능 )
        // 그 외에 대해서는 그대로 사용하면서 최대 개수를 구합니다.
        for (int i = 0; i < checkTimes.length; i++) {
            // 9일 때는 어차피 0이니깐 무시하고
            // 6일 때만 홀수일 때는 2로 나눈뒤 1을 더하고, 짝수일 때는 2로 나눈 걸 그대로 씁니다.
            if (i == 6) {
                if (checkTimes[i] % 2 == 0) {
                    frequency = checkTimes[i] / 2;
                } else {
                    frequency = checkTimes[i] / 2 + 1;
                }
            } else { // 그 외는 사용하는 대로가 빈도가 됩니다.
                frequency = checkTimes[i]; // 빈도를 체크합니다.
            }

            // 각 숫자의 빈도를 탐색하면서 가장 큰 값을 구하면 됩니다.
            if (frequency > max) max = frequency;
        }

        // 정답인 max를 출력합니다.
        System.out.println(max);
    }

    // 매개변수로 전달된 문자에 대해 체크를 수행합니다.
    public static void usePlasticNumber(char ch) {
        int num = ch - '0'; // 해당 문자를 숫자로 변환합니다.

        // 6, 9를 모두 6을 사용했다고 치겠습니다.
        if (num == 6 || num == 9) {
            checkTimes[6]++; // 6의 사용 빈도를 늘리고
            return; // 종료합니다.
        }

        checkTimes[num]++; // 그 외의 경우는 사용된 개수만큼 체크해주면 됩니다.
    }
}
