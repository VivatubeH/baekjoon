import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 의사코드를 토대로 보면, sum = 0이라는 입력값이 주어질 때,
        // for문을 돌 때 i = 1부터 i = n까지 순회를 돌면서
        // sum에 sum + 배열 A의 i번째 값을 더하고
        // return sum을 통해 그 값을 돌려주는 알고리즘입니다.

        // 이 때 입력 크기가 n이라면, 덧셈은 총 n번 실행되기 때문에
        // 실행횟수는 입력값 그대로이고, 시간 복잡도는 O(n) = n이기 때문에
        // 최고차항의 차수는 1이 됩니다.
        System.out.println(in.nextInt());
        System.out.println(1);
    }
}
