import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int min = 100; // 최솟값은 최초 초기화를 위해 최댓값보다 1크게 설정한다.
        int sum = 0; // 홀수들의 합을 저장할 변수를 선언한다.

        for (int i = 0; i < 7; i++) { // 7개의 줄에 걸쳐서
            int num = scanner.nextInt(); // 1 ~ 99 범위의 자연수를 입력받는다.

            // 이 자연수가 홀수일 때만 합에 누적한다.
            if (num % 2 != 0) { // 2로 나누어떨어지지 않으면 홀수
                sum += num;
                // 최솟값보다 작으면 갱신한다.
                if (num < min) min = num;
            }
        }

        // 모든 반복이 끝났을 때 합이 0이면 홀수가 없다는 뜻이니 -1을 출력하고
        if (sum == 0) System.out.print(-1);
        else { // 합이 0이 아니면 홀수가 존재한다는 뜻이니
            System.out.println(sum); // 첫째 줄에 합을 출력하고
            System.out.println(min); // 둘째 줄에 홀수들 중 최솟값을 출력한다.
        }
    }
}
