import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 사용자로부터 N을 입력받습니다.

        // N의 자릿수를 체크합니다.
        int length = String.valueOf(N).length();

        // 그러면 자릿수 - 1까지는 별도 계산없이 누적합니다.
        // 누적은 i가 1일때 9, i가 2일때 90, i가 3일때 900 이런식이니깐
        // sum += 9 * Math.pow(10, i - 1);
        int sum = 0;
        for (int i = 1; i <= length - 1; i++) {
            sum += 9 * i * (int)Math.pow(10, i - 1);
        }

        // 마지막으로 자기 자리수에 도달하면 해당 수까지의 같은 자리수를 세서 누적합니다.
        // 예를 들어 120까지의 세자릿수는 120 - 100 + 1입니다.
        // 한 자릿수일 때도 성립합니다.
        int count = N - (int)(Math.pow(10, length - 1)) + 1; // 같은 자리의 수는
        sum += (count * length); // length 자리수 x count만큼을 추가로 누적해주면 됩니다.

        System.out.print(sum);
    }
}
