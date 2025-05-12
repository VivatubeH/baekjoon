import java.io.*;
import java.util.*;

public class Main {

    // 현재 집합을 저장하기 위한 currentSet입니다.
    // 기본값이 false이니 별도 초기화는 하지 않습니다.
    public static boolean[] currentSet = new boolean[21];

    // 출력 시간을 단축하기 위해서 answer에 저장해두고 다 끝났을 때 출력합니다.
    public static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // 먼저 사용자로부터 입력을 받기 위해 BufferedReader 객체를 생성합니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 수행해야 할 연산의 수 M ( 1과 300만 사이 ) 를 입력받습니다.
        int m = Integer.parseInt(br.readLine());
        // M개의 줄에 걸쳐 수행해야 하는 연산이 한 줄에 하나씩 주어집니다
        // 연산은 명령어만 오거나, 명령어 + 매개변수가 오거나 둘 중 하나입니다.

        for (int i = 0; i < m; i++) {
            // 사용자로부터 명령을 입력받습니다.
            String instruction = br.readLine();
            // 명령을 해석해서 실행하는 메서드에 명령어를 매개변수로 넘깁니다.
            analyzeAndRunByInstruction(instruction);
        }

        // 모든 연산이 끝나면
        System.out.println(answer); // 정답을 출력합니다.
    }

    // 명령어를 입력받아서 해석하고 실행하는 메서드입니다.
    public static void analyzeAndRunByInstruction(String instruction) {
        if (instruction.equals("all")) { // 명령어가 all이면
            for(int i = 1; i <= 20; i++) {
                currentSet[i] = true;
            }
            return;
            // 어차피 기존 집합은 trueSet으로 변경되기 때문에 기억할 필요 없습니다.
        } else if (instruction.equals("empty")) { // 명령어가 empty이면
            for(int i = 1; i <= 20; i++) {
                currentSet[i] = false;
            }
            return;
            // 어차피 기존 집합은 falseSet으로 변경되기 때문에 기억할 필요 없습니다.
        }

        // check, remove, toggle의 경우 숫자를 매개변수로 사용해야 하므로
        String[] split = instruction.split(" "); // 공백을 기준으로 나눈 다음
        int index = Integer.parseInt(split[1]); // 숫자를 추출합니다.

        // 명령에 맞게 명령을 실행해주면 됩니다.
        // toggle -> true면 false로, false면 true로
        if (split[0].equals("toggle")) {
            if (currentSet[index]) { // true이면
                currentSet[index] = false; // false로 바꾸고
            } else { // false이면
                currentSet[index] = true;
            }
        }

        // remove -> true면 false로, 아니면 신경 x
        if (split[0].equals("remove")) {
            if (currentSet[index]) {
                currentSet[index] = false;
            }
        }

        // add -> false이면 true로 변경
        if (split[0].equals("add")) {
            if (!currentSet[index]) {
                currentSet[index] = true;
            }
        }

        // check -> true이면 1을, false면 0을 출력
        if (split[0].equals("check")) {
            // true 배열이나 false 배열이 아닐때만
            if (currentSet[index]) { // true면
                answer.append(1 + "\n"); // 1을 출력( 이어붙이고 )
            } else { // false면
                answer.append(0 + "\n"); // 0을 출력( 이어붙입니다. )
            }
        }

    }
}
