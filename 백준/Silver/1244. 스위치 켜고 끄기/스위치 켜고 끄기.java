import java.io.*;
import java.util.*;

public class Main {
    public static int[] switchArr; // 스위치의 상태를 저장할 배열입니다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfSwitch = Integer.parseInt(br.readLine()); // 스위치의 개수
        switchArr = new int[numberOfSwitch + 1]; // 스위치의 상태 배열 ( 1부터 번호 활용을 위해 1크게 만든다. )
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= numberOfSwitch; i++) { // 스위치 번호에 맞게
            switchArr[i] = Integer.parseInt(st.nextToken()); // 공백을 기준으로 입력된 스위치 상태를 입력합니다.
        }
        int student = Integer.parseInt(br.readLine()); // 학생 수가 주어집니다.
        for (int i = 0; i < student; i++) { // 학생 수만큼
            st = new StringTokenizer(br.readLine()); // 공백을 기준으로 성별과 받은 수가 주어집니다.
            int gender = Integer.parseInt(st.nextToken()); // 성별이 주어집니다. ( 1은 남학생, 2는 여학생 )
            int indexOfSwitch = Integer.parseInt(st.nextToken()); // 판단 기준이 될 스위치의 번호가 주어집니다.

            // 스위치의 상태를 변경하는 메서드를 실행합니다.
            changeSwitch(gender, indexOfSwitch); // 성별과 스위치 번호를 통해 스위치를 변경합니다.
        }
        // 결과를 N의 크기에 맞게 출력합니다.
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= numberOfSwitch; i++) {
            sb.append(switchArr[i] + " ");
            if (i % 20 == 0) { // 줄 바꿈이 필요할 때는, 처음에는 줄 바꿈을 하면 안됩니다.
                sb.append("\n"); // 20번째마다 줄을 바꿉니다.
            }
        }
        System.out.print(sb); // 결과를 출력합니다.
    }

    public static void changeSwitch(int gender, int index) {
        // 남자일 때 변경하기
        if (gender == 1) { // 학생이 남자라면
            // 자기가 받은 index의 배수의 상태를 변경합니다. ( 1이면 0으로, 0이면 1로)
            for (int i = index; i <= switchArr.length - 1; i += index) { // 배열의 마지막 요소까지 나눠떨어지면 상태를 변경합니다.
                switchArr[i] = switchArr[i] == 1 ? 0 : 1;
            }
        }

        // 여자일 때 변경하기
        if (gender == 2) { // 학생이 여자라면
            // 해당 인덱스부터 퍼져 나가면서 대칭인 구간에 대해서 변경해야 합니다.
            int left = index; // 왼쪽
            int right = index; // 오른쪽입니다.

            int start = 0; // 변경 시작 범위부터
            int end = 0; // 변경 끝 범위까지 체크합니다.

            // 왼쪽과 오른쪽이 같다면 변경하고, 다르다면 종료합니다.
            while (left >= 1 && right < switchArr.length) { // 배열 범위 내에 있을 때는 수행합니다.
                if (switchArr[left] == switchArr[right]) {
                    start = left;
                    end = right;
                } else { // 좌우가 달라지면 더 이상 변경할 필요 없이 종료합니다.
                    break;
                }
                // 왼쪽은 줄이고, 오른쪽은 늘립니다.
                left--;
                right++;
            }

            // 이제 대칭되는 범위에 대한 변경을 수행합니다.
            for (int i = start; i <= end; i++) {
                switchArr[i] = switchArr[i] == 1 ? 0 : 1;
            }
        }
    }
}
