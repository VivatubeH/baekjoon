import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int underScoreCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sb
                .append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        recur(0); // 재귀 횟수에 따라 뒤에 붙어야 합니다.
        System.out.println(sb);
    }

    // 재귀 패턴 파악하기
    // 입력된 N에 따라 _의 개수가 달라짐.
    // 어느 ~ 물었어." 까지는 하나의 템플릿 ( 시작이고 고정 )
    // 재귀 되는 부분에 대한 처리를 해야 함.

    // depth가 커짐에 따라서 ____의 개수가 늘어나고
    // depth가 1일 때, 멘트가 변경되고
    // depth가 그 이상일 때는 멘트 변경은 없고 앞에 내용이 붙음.
    // 그리고 재귀가 종료될 때 라고 답변하였지가 붙어야 함.

    // 재귀 호출 시 -> 기본 멘트 출력
    // 재귀 종료 시 -> 종료 멘트 출력

    /*
        ________"재귀함수가 뭔가요?"
        ________"재귀함수는 자기 자신을 호출하는 함수라네"
        ________라고 답변하였지.
     */
    public static void recur(int depth) {
        if (depth == N) { // depth가 끝에 도달하면 출력하고 종료해야 합니다.
            printUnderScore(depth);
            sb.append("\"재귀함수가 뭔가요?\"\n");
            printUnderScore(depth);
            sb.append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
            printUnderScore(depth);
            sb.append("라고 답변하였지.\n");
            return;
        }
        else {
            printUnderScore(depth);
            sb.append("\"재귀함수가 뭔가요?\"\n");
            printUnderScore(depth);
            sb.append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
            printUnderScore(depth);
            sb.append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
            printUnderScore(depth);
            sb.append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
            recur(depth + 1);
            printUnderScore(depth);
            sb.append("라고 답변하였지.\n");
        }
    }

    public static void printUnderScore(int count) {
        int realCount = count * 4;
        for (int i = 0; i < realCount; i++) {
            sb.append("_");
        }
    }
}
