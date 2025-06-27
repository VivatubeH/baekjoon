import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long a = scanner.nextLong(); // 입력받은 정수 A입니다.
        long b = scanner.nextLong(); // 입력받은 정수 B입니다.

        long min = 0; // 두 수 중 더 작은 정수를 저장할 변수 min입니다.
        long max = 0; // 두 수 중 더 큰 정수를 저장할 변수 max입니다.
        // 두 수가 같다면 사이에 있는 수의 개수인 0만 출력하고 끝내면 된다.
        if (a == b) {
            System.out.print(0);
        } else { // 두 수가 같지 않을 때만 처리합니다.

            if (a < b) { // a가 b보다 작으면 더 작은 수가 a입니다.
                min = a;
                max = b;
            } else { // a가 b보다 크다면 ( 어차피 같은 경우는 바깥 if로 배제했습니다. )
                max = a;
                min = b;
            }

            // 두 수 사이의 수의 개수 = 큰 수 - 작은 수 -1을 출력한다.
            System.out.println(max - min - 1);
            // 이후 min + 1부터 max보다 작은 동안 숫자에 공백을 더해가며 출력한다.
            for (long i = min + 1; i < max; i++) {
                System.out.print(i + " ");
            }
        }
    }
}
