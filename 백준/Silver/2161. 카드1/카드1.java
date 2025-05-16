import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) { // 1부터 N까지의 숫자를 뒤로 채워넣어야 합니다.
            deque.offerLast(i);
        }
        if (N == 1) { // 만약에 N이 1이면
            System.out.print(1); // 버리는 카드 없이 남게 된 1만 출력하면 됩니다.
            return;
        }
        ArrayList<Integer> list = new ArrayList<>();
        // 이제 위에 있는( 앞에 있는 ) 카드는 버리고, ArrayList에 순차적으로 추가합니다.
        int remain = 0; // 남는 숫자를 저장하기 위한 변수입니다.
        while (true) {
            // 제일 앞에 있는 카드는 버리고 ArrayList에 추가합니다.
            list.add(deque.pollFirst());
            // 그 다음에 있는 카드는 제일 뒤로 보냅니다.
            deque.offerLast(deque.pollFirst());
            if (deque.size() == 1) { // 만약에 남은 카드가 1개이면
                remain = deque.pollFirst();
                break; // 종료합니다.
            }
        }

        // 버리는 카드들을 순서대로 출력하고 마지막에 남게 되는 카드의 번호르 출력합니다.
        StringBuilder answer = new StringBuilder();
        for (Integer integer : list) {
            answer.append(integer + " ");
        }
        answer.append(remain);

        System.out.print(answer);
    }
}
