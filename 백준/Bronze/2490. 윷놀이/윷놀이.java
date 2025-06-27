import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 입력은 3줄로 제한된다.
        for (int i = 1; i <= 3; i++) {
            // 줄 마다 윷짝들의 합을 구하기 위한 변수 sum
            int sum = 0;
            // 각 줄마다 네 개의 정수가 주어진다.
            for (int j = 1; j <= 4; j++) {
                // 줄마다 1, 2, 3, 4번째 숫자를 입력받는다.
                int num = scanner.nextInt();
                // 그 숫자의 합을 누적시킨다.
                sum += num;
            }
            // 각 줄에 대한 숫자를 구하면 그 합에 따라 출력한다.
            printResult(sum);
        }
    }

    // 결과를 출력하기 위한 메서드
    public static void printResult(int sum) {
        // 도개걸윷모 값이 0,1,2,3,4에 맞게 인덱스에 알파벳을 저장해둔다.
        char[] results = {'D', 'C', 'B', 'A', 'E'};
        // 인덱스에 맞는 알파벳을 출력하고 줄을 바꾼다.
        System.out.println(results[sum]);
    }
}
