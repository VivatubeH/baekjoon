import java.util.Scanner;

public class Main {
    public static int[] memorization = new int[46];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.print(fibo(num));
    }

    // num번째 피보나치 수를 구한다.
    // num - 1, num - 2번째 피보나치수를 이용한다.
    // 또 각각은 num-2, num-3 / num-3, num-4 번째 피보나치수를 이용한다.
    public static int fibo(int num) {
        if (num == 0) {
            memorization[0] = 0;
            return 0;
        }
        if (num == 1) {
            memorization[1] = 1;
            return 1;
        }

        // num번째 피보나치수가 이미 구해져 있으면
        // 그 전 수를 이용할 필요가 없다.
        if (memorization[num] > 0) {
            return memorization[num];
        }

        // num번째 피보나치수를 모를 때만
        // 메모리에 기억해둔다.
        int result = fibo(num - 1) + fibo(num - 2);
        memorization[num] = result;

        return result;
    }
}
