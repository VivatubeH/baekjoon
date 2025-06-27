import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        // 규칙 찾기
        // i번째 줄의 별의 개수 -> 2*N - (2*i + 1)개
        // i번째 줄의 공백의 개수 -> i개
        for (int i = 0; i < N; i++) { // N개의 줄에 대해서
            for (int j = 0; j < i; j++) { // i개의 공백 찍기
                System.out.print(" ");
            }
            for (int k = 0; k < 2*(N-i) - 1; k++) { // 2*N - (2*i + 1)개의 별 찍기
                System.out.print("*");
            }
            System.out.println(); // 공백과 별을 찍은 후엔 줄바꿈
        }
    }
}
