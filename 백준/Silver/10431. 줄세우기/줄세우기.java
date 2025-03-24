import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 사용자로부터 입력받을 테스트 케이스의 수를 저장할 변수 N입니다.
        int N = Integer.parseInt(br.readLine());
        int[] rows = new int[20]; // 학생들의 줄을 저장할 배열 rows입니다.
        for (int i = 0; i < N; i++) { // N개의 테스트 케이스를 입력받습니다.
            String[] token = br.readLine().split(" "); // 공백을 기준으로 토큰을 나눕니다.
            int testCaseNo = Integer.parseInt(token[0]); // 0번째 토큰이 테스트 케이스 번호입니다.
            for (int j = 1; j <= 20; j++) {
                rows[j-1] = Integer.parseInt(token[j]); // 각 요소들을 rows 배열에 저장합니다.
            }
            System.out.println(testCaseNo + " " + countSteps(rows));
        }

    }

    public static int countSteps(int[] array) {
        int count = 0;
        for (int i = 0; i < 20; i++) {
            int number = array[i];
            // 뒤의 요소들에 대해 검사를 실시합니다.
            for (int j = i+1; j < 20; j++) {
                // 뒤의 요소보다 크면 그 수를 counting 합니다.
                if (number > array[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}

