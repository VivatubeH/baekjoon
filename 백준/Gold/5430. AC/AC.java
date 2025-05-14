import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 첫째 줄에 테스트 케이스의 수 T가 주어집니다. T는 최대 100입니다.
        int T = Integer.parseInt(br.readLine());
        // Deque을 통해 앞뒤에서 삭제하는 식으로 진행하겠습니다.
        Deque<Integer> deque = new ArrayDeque<>();
        // 정답을 한 번에 출력하기 위한 StringBuilder입니다.
        StringBuilder answer = new StringBuilder();

        // 시간 복잡도 : O(ij) = 100 x (약 200 + 100,000) -> 대략 1000만번의 연산
        // 테스트 케이스의 수만큼 수행할 함수가 입력됩니다.
        for (int i = 0; i < T; i++) {
            // 케이스마다
            String instruction = br.readLine(); // 문자열 형태로 한 줄로 명령어를 입력받습니다.
            int n = Integer.parseInt(br.readLine()); // 배열에 들어있는 수의 개수 n을 입력받습니다.
            String input = br.readLine(); // [숫자, 숫자, 숫자, 숫자, ..., 숫자]의 형태로 입력을 받습니다.
            String sub = input.substring(1, input.length() - 1); // [와 ]는 무시합니다.
            boolean direction = false; // 모든 케이스는 정방향으로 시작해야 합니다.

            // 매번 deque은 비우고 새롭게 입력을 받아야 합니다.
            deque.clear();

            StringTokenizer st = new StringTokenizer(sub, ","); // ,를 기준으로 토큰화합니다. -> 문자형 형태의 숫자만 들어있음.
            while (st.hasMoreTokens()) { // 모든 토큰에 대해서
                int num = Integer.parseInt(st.nextToken()); // 숫자로 변환하고
                deque.offerLast(num); // 최초에는 정방향으로 수를 추가합니다.
            }

            // 각 경우에 대해 에러인지 아닌지 체크하기 위한 변수입니다.
            boolean isError = false;

            // 이 아래부터 함수를 분석해서 실행하게 됩니다.
            for (int j = 0; j < instruction.length(); j++) {
                // 방향 전환인 경우, 정방향이면 역방향, 역방향이면 정방향 처리합니다.
                if (instruction.charAt(j) == 'R') {
                    direction = !direction; // 이렇게 하면 true면 false, false면 true로 뒤집습니다.
                }
                // 삭제인 경우, 정방향이면 앞에서 삭제, 역방향이면 뒤에서 삭제합니다.
                if (instruction.charAt(j) == 'D') {
                    if (deque.isEmpty()) { // 만약에 배열이 비어있으면
                        isError = true; // 에러임을 표시하고,
                        break; // 더 이상 반복문을 도는 건 불필요합니다.
                    }
                    if (!direction) { // 정방향이면
                        deque.pollFirst(); // 앞에서 삭제합니다.
                    } else { // 역방향이면
                        deque.pollLast(); // 뒤에서 삭제합니다.
                    }
                }
            }

            // 각 테스트 케이스에 대한 결과를 answer에 붙이겠습니다.
            // 먼저 error가 난 경우
            if (isError == true) {
                answer.append("error" + "\n"); // 에러 메시지를 붙이고 줄을 바꿉니다.
            } else { // 에러가 나지 않은 경우는
                answer.append("["); // 앞에 다시 배열 기호를 붙이고
                while(!deque.isEmpty()) { // 큐에 숫자가 있는 동안은 1 2 3 4
                    if (!direction) { // 배열이 정방향이면 -> 앞에서부터 뺍니다.
                        answer.append(deque.pollFirst());
                    } else { // 역방향이면 -> 뒤에서부터 뺍니다.
                        answer.append(deque.pollLast());
                    }
                    if (!deque.isEmpty()) { // 숫자가 남아있는 동안은
                        answer.append(","); // 콤마를 붙입니다.
                    }
                }
                answer.append("]" + "\n"); // 배열 기호를 닫아줍니다.
            }
        }

        // 출력은 한 번에 진행합니다.
        System.out.print(answer);
    }
}
