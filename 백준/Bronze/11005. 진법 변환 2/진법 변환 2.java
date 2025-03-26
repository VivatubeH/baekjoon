import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 10진법 수 N이 주어질 때, 얘를 B 진법으로 바꿔서 출력해야 합니다.
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

        // N과 B를 입력받습니다.
        int N = Integer.parseInt(tokenizer.nextToken());
        int B = Integer.parseInt(tokenizer.nextToken());

        // 해당 수 N과 B를 입력받아서 진법으로 변환해서 문자열로 반환합니다.
        String answer = makeFormation(N, B);

        System.out.println(answer);
    }

    // 변환하기 위한 규칙을 세워야 하는데
    // B진법으로 변환하기 위해서는 B으로 나누는 것이 첫 단계입니다.
    public static String makeFormation(int n, int b) {
        int currentValue = n; // 현재 값을 저장하기 위한 변수
        char[] alphabets = new char[36]; // 0 ~ 35까지 인덱스를 활용하겠습니다.
        // 한 자리수는 그대로 '0' ~ '9'를 사용해야 합니다.
        for (int i = 0; i < 10; i++) {
            alphabets[i] = (char)('0' + i);
        }
        // 그 이후는 알파벳으로 들어가야 합니다.
        for (int i = 10; i <= 35; i++) {
            alphabets[i] = (char)('A' + (i - 10));
        }

        // 정답이 될 String을 저장할 변수 answer를 선언합니다.
        StringBuilder answer = new StringBuilder();
        // b로 나눠가면서 b 진법으로 변환하는 과정을 반복하겠습니다.
        while (true) {
            if (currentValue < b) { // 해당하는 수가 진법보다 작으면 해당 수를 이어붙이고 종료합니다.
                answer.append(alphabets[currentValue]);
                break;
            }
            // 그게 아닌 경우라면 나누는 연산을 수행할 수 있습니다.
            int remain = currentValue % b; // 나머지를 저장합니다.
            answer.append(alphabets[remain]); // 나머지에 해당하는 문자를 String 변수에 이어붙입니다.
            currentValue = currentValue / b; // 현재 수를 줄여나갑니다.
        }

        // 이 때 완성된 문자열을 뒤집어야지 정답인 문자열이 됩니다.
        return answer.reverse().toString();
    }


}
