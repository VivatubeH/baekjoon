import java.io.*;
import java.util.*;

public class Main {
    public static Map<Integer, Deque<Integer>> map = new HashMap<>();
    public static int maxSize = 0;
    public static int count = 0;
    public static void main(String[] args) throws IOException {
        input();
        System.out.print(count);
    }

    public static void input() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            maxSize = Integer.parseInt(st.nextToken());
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int lineNumber = Integer.parseInt(st.nextToken());
                int fretNumber = Integer.parseInt(st.nextToken());
                algorithm(lineNumber, fretNumber);
            }
        }
    }

    public static void algorithm(int lineNumber, int fretNumber) {
        // 해당 줄번호에 대한 스택이 존재하지 않으면
        if (!map.containsKey(lineNumber)) {
            // 스택을 새롭게 생성해서 줄 번호와 매핑한다.
            map.put(lineNumber, new ArrayDeque<>());
            map.get(lineNumber).push(fretNumber);
            count++;
        } else { // 해당 줄번호에 대한 스택이 존재한다면
            // 해당 스택을 조회한다.
            Deque<Integer> stack = map.get(lineNumber);
            // 스택이 비어 있으면 지금 프랫 번호만 스택 최상단에 추가하면 연주할 수 있다.
            if (stack.isEmpty()) {
                stack.push(fretNumber);
                count++;
            } else { // 스택이 비어 있지 않으면
               // 1. 스택 최상단보다 프랫번호가 더 크면
                if (stack.peek() < fretNumber) {
                    stack.push(fretNumber);
                    count++;
                } // 2. 스택 최상단과 프랫 번호가 같으면
                else if (stack.peek() == fretNumber) {
                    // 누를 필요가 없습니다.
                } // 3. 스택 최상단보다 프랫 번호가 작으면
                else {
                    // 스택이 비어있지 않고 최상단보다 프랫이 작은동안은
                    while (!stack.isEmpty() && stack.peek() > fretNumber) {
                        stack.pop();
                        count++;
                    }
                    // 프랫 번호보다 큰 숫자를 다 뺐다면
                    // 스택의 최상단과 프랫 번호가 같다면
                    if (!stack.isEmpty() && stack.peek() == fretNumber) {
                        // 누르거나 뗄 필요 없음
                    } else { // 스택 최상단이 프랫번호보다 작든 비었든
                        stack.push(fretNumber);
                        count++;
                    }
                }
            }
        }
    }
}
