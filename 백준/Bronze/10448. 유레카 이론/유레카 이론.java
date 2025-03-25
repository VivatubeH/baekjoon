import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1000까지의 자연수만 삼각수인지 검증하면 되기 때문에
        // 1000까지의 삼각수를 구합니다.
        int[] triangleNum = new int[1001]; // 삼각수는 어차피 1000개 이하니 넉넉하게 잡습니다.
        int maxIndex = 0; // 최대 인덱스를 저장하기 위한 변수입니다.
        int sum = 0; // 삼각수의 합을 통해 최대 인덱스를 구하기 위한 변수입니다.
        int index = 1; // 삼각수를 구할 때의 시작 인덱스를 저장할 변수입니다.

        // 모든 삼각수들을 기록하고, 최대 삼각수 인덱스를 저장합니다.
        while (true) {
            sum = index * (index+1) / 2; // 인덱스별 삼각수를 구합니다.
            if (sum > 1000) { // sum이 1000보다 커지면, 그 이전 인덱스가 최대 인덱스이므로
                maxIndex = index - 1;
                break;
            }
            // sum이 1000미만인 경우는 해당 삼각수를 저장하고
            // 인덱스를 늘려줍니다.
            triangleNum[index] = sum;
            index++;
        }

        // 삼중 for문을 돌면서 3수의 합이 1000이하인 경우
        // 해당 인덱스의 boolean 값을 true로 바꿉니다.
        boolean[] isEurekaNums = new boolean[1001];
        for (int i = 1; i <= maxIndex; i++) {
            for (int j = 1; j <= maxIndex; j++) {
                for (int k = 1; k <= maxIndex; k++) {
                    int answerIndex = triangleNum[i] + triangleNum[j] + triangleNum[k];
                    // 1000 이하인 정답 index들을 찾아냅니다.
                    if (answerIndex <= 1000) {
                        isEurekaNums[answerIndex] = true;
                    }
                }
            }
        }

        // 사용자로부터 테스트 케이스의 수 T를 입력받습니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        // T개의 자연수를 입력받으면서 삼각수인 경우에만 1 출력, 아니라면 0출력을 합니다.
        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            if (isEurekaNums[num]) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
