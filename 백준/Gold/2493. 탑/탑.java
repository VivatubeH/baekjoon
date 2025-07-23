import java.io.*;
import java.util.*;

public class Main {
    public static Deque<Top> candidates = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer inputNumberString = new StringTokenizer(br.readLine());

        ArrayList<Top> topList = new ArrayList<Top>();
        for (int i = 1; i <= N; i++) {
            int height = Integer.parseInt(inputNumberString.nextToken());
            Top top = new Top(i, height);
            topList.add(top);
        }

        // 레이저를 수신할 수 있는 후보 탑을 저장할 Stack
        ArrayDeque<Top> candidateStack = new ArrayDeque<>();
        // 정답을 한 번에 출력하기 위해 번호를 저장할 스택
        StringBuilder answer = new StringBuilder();

        // 1. 탑들을 하나씩 꺼낸다.
        for (Top top : topList) {
            // 현재 탑을 가져온다.
            Top currentTop = top;

            // 현재 탑과의 스택 검사
            while (true) {
                // 스택이 비어있으면 후보탑이 없으므로
                // 현재 탑을 추가하고 0을 출력합니다.
                if (candidateStack.isEmpty()) {
                    candidateStack.offerLast(currentTop);
                    answer.append("0").append(" ");
                    break; // 현재 탑에 대한 검증이 끝났으니 다음 탑으로 이동합니다.
                } // 스택이 비어있지 않으면
                else {
                    // 가장 가까운 탑을 체크해서
                    Top topOfStack = candidateStack.peekLast();
                    // 걔가 더 높거나 같다면 얘가 가장 높은 첫 탑이므로
                    if (topOfStack.height >= currentTop.height) {
                        // 걔를 출력하고
                        answer.append(topOfStack.index).append(" ");
                        candidateStack.offerLast(currentTop); // 현재 탑은 스택에 넣습니다.
                        break; // 현재 탑에 대한 검증이 끝났으니 다음탑으로 이동합니다.
                    } else { // 현재 탑이 더 높다면
                        candidateStack.pollLast(); // 바로 앞의 탑은 가려지므로 제거합니다.
                    }
                }
            }
        }

        System.out.print(answer);
    }
}

class Top {
    public int index;
    public int height;

    Top(int index, int height) {
        this.index = index;
        this.height = height;
    }
}