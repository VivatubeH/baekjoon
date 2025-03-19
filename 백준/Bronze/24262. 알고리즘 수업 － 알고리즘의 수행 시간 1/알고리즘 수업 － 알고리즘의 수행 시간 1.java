import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // MenOfPassion 알고리즘은 입력 크기가 n일 때
        // A[n]이라는 배열의 알고리즘 수행 시간을 구하는 문제입니다.
        // 문제에서 i = [n / 2]는 배열의 중간 인덱스를 구하는 부분인데
        // 배열의 중간 인덱스는 n의 값에 관계없이 단 1번만 구하게 됩니다.
        // n에 따른 return A[i]의 시간 복잡도는 O(n) = 1이므로
        // 최고 차항의 차수는 항상 0, 수행 횟수는 1로 고정됩니다.
        Scanner in = new Scanner(System.in);
        in.nextInt(); // 입력값에 상관없이
        System.out.println(1); // 수행 횟수는 1회
        System.out.println(0); // 최고 차항은 0입니다.
    }
}
