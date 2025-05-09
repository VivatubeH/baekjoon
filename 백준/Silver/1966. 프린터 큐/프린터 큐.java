import java.util.*;
import java.io.*;

public class Main {
    // 정답을 이어붙여서 한 번에 출력하겠습니다.
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine()); // 테스트 케이스의 수

        // test개의 테스트 케이스에 대해 프로그램 실행
        for (int i = 0; i < test; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 문서의 개수
            int M = Integer.parseInt(st.nextToken()); // 목표가 되는 인덱스

            Deque<Document> deque = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                deque.offerLast(new Document(Integer.parseInt(st.nextToken()), j));
            }
            answer.append(getPrintOrder(M, deque)).append("\n");
        }

        System.out.print(answer);
    }

    // 타겟 인덱스와 배열을 전달받아서 -> 조작된 타겟인덱스 + 1을 반환해야 함 ( 0부터 시작 )
    public static int getPrintOrder(int num, Deque<Document> deque) {
        int targetIndex = num;
        int printCount = 0;

        while(true) {
            Document first = deque.pollFirst();
            boolean hasHigherPriority = false;
            for (Document doc : deque) {
                if (doc.priority > first.priority) {
                    hasHigherPriority = true;
                    break;
                }
            }
            if (hasHigherPriority) {
                deque.offerLast(first);
            } else {
                printCount++;
                if (first.index == targetIndex) {
                    break;
                }
            }
        }
        return printCount;
    }
}

class Document {
    int priority;
    int index;

    Document(int priority, int index) {
        this.priority = priority;
        this.index = index;
    }
}
