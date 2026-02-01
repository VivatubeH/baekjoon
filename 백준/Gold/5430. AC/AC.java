import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> deque = new ArrayDeque<>();

        // 테스트 케이스 수 입력
        int T = Integer.parseInt(br.readLine());

        // T개의 테스트 케이스
        for (int i = 0; i < T; i++) {
            String function = br.readLine();
            int N = Integer.parseInt(br.readLine());
            String arrayString = br.readLine();
            String subString = arrayString.substring(1, arrayString.length() - 1);

            boolean isReversed = false;
            boolean isError = false;

            StringTokenizer st = new StringTokenizer(subString, ",");
            for (int j = 0; j < N; j++) {
                deque.offerLast(Integer.parseInt(st.nextToken()));
            }

            for (int k = 0; k < function.length(); k++) {
                char instruct = function.charAt(k);

                if (instruct == 'R') {
                    isReversed = !isReversed;
                }
                if (instruct == 'D') {
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    } else {
                        if (isReversed) {
                            deque.pollLast();
                        } else {
                            deque.pollFirst();
                        }
                    }
                }
            }

            if (isError) bw.write("error\n");
            else {
                bw.write("[");
                if (isReversed) {
                    while (!deque.isEmpty()) {
                        bw.write(String.valueOf(deque.pollLast()));
                        if (!deque.isEmpty()) bw.write(",");
                    }
                } else {
                    while (!deque.isEmpty()) {
                        bw.write(String.valueOf(deque.pollFirst()));
                        if (!deque.isEmpty()) bw.write(",");
                    }
                }
                bw.write("]\n");
            }
            deque.clear();
        }
        bw.flush();
    }
}
