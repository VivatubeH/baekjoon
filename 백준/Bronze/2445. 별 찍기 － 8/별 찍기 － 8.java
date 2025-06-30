import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        // 2*N - 1개의 행에 대해서 출력이 필요합니다.
        for (int i = 1; i <= 2*N-1; i++) {
            // 행에 따라 별의 개수가 결정됩니다.
            // 좌우 대칭을 이용해서 찍어봅시다.
            StringBuilder left = new StringBuilder();
            if (i <= N) { // i가 N보다 작거나 같으면
                // i개의 별을 찍고
                for (int k = 1; k <= i; k++) {
                    left.append("*");
                }
                // N-i개의 공백을 찍습니다.
                for (int k = 1; k <= N-i; k++) {
                    left.append(" ");
                }
            } else { // i가 N보다 크거나 같으면
                // 2*N-i개의 별을 찍고
                for (int k = 1; k <= 2*N-i; k++) {
                    left.append("*");
                }
                // i-N개의 공백을 찍습니다
                for (int k = 1; k <= i-N; k++) {
                    left.append(" ");
                }
            }
            // 좌우 대칭을 이어붙여서
            StringBuilder right = new StringBuilder(left).reverse();
            System.out.println(left.append(right).toString());
        }
    }
}
