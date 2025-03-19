import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 문제에 주어진 의사코드 같은 경우는 다음과 같습니다.
        // sum에 0이라는 값이 초기값으로 주어지고
        // 바깥 for문이 i = 1에서 n까지
        // 안쪽 for문이 j = 1에서 n까지
        // 그렇게 순환하면서 sum에 배열 A의 i번째 요소와 j번째 요소를 곱하고
        // 그렇게 해서 구한 sum을 반환하는 알고리즘입니다.

        // 위와 같은 경우 n의 크기에 따라 O(n) = n x n = n^2의 시간 복잡도를 가지고
        // 입력횟수가 n이라면 수행 횟수는 n x n = n^2 번
        // 최고차항의 차수는 2가 됩니다.
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // 최악의 경우 50만 x 50만이 되고 20억이 거뜬히 넘어가므로 long으로 해야합니다.
        System.out.println((long)Math.pow(n, 2));
        System.out.println(2);
    }
}