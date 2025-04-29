import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque<Integer> people = new ArrayDeque<>(); // Deque의 구현체인 ArrayDeque를 통해 구현하겠습니다.

        // 번호순으로 사람들을 줄을 세웁니다. -> 큐를 사용합니다.
        for (int i = 1; i <= N; i++) {
            people.offerLast(i); // 이렇게 하면 1부터 N까지 순서대로 줄이 세워집니다.
        }

        StringBuilder sb = new StringBuilder("<"); // 시작은 <로 시작합니다.

        // 이제 얘네를 돌면서 k번째 사람을 제거해주면 됩니다.
        while (!people.isEmpty()) { // 모든 사람을 제거할 때까지 반복해줍니다.
            // 앞에서 k번째 사람을 제거해줍니다.
            // k번째 사람 전까지는 원을 이루어야 하므로 제거 한 뒤에 뒤로 붙여 줘야 합니다. ( 1이 8 뒤에 붙는 느낌 ? )
            for (int i = 0; i < K-1; i++) { // k번째 사람 전까지
                Integer person = people.pollFirst(); // 제거 한 다음에
                people.offerLast(person); // 맨 뒤로 붙입니다.
            }
            // 그 다음 k번째 사람을 제거합니다.
            Integer kPerson = people.pollFirst();
            if (people.size() == 0) { // 뒤에 더 사람이 없을때는 ,를 붙이면 안되고 >로 닫아줍니다.
                sb.append(kPerson + ">");
            } else {
                sb.append(kPerson + ", "); // 아닐 때는 ,로 결합합니다.
            }
        }

        System.out.print(sb);
    }
}
