import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 추상 인터페이스 deque을 구현한 ArrayDeque을 stack처럼 사용하기.
        Deque<Integer> deque = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) { // K번 정수를 입력받습니다.
            int num = Integer.parseInt(br.readLine());
            if (num == 0) { // 0이면 마지막 원소제거 ( 스택처럼 위(뒤)에서 부터 제거 )
                deque.removeLast(); // 마지막 원소를 제거합니다.
            } else {
                deque.addLast(num); // 마지막에 값을 추가합니다. ( 스택처럼 뒤에 값 추가 )
            }
        }
        // 최종적으로 적어낸 수의 합을 구합니다.
        int sum = 0;
        for (Integer integer : deque) {
            sum += integer;
        }
        System.out.println(sum);
    }
}
