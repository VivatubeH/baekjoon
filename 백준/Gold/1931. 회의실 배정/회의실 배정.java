import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int maxInput = Integer.parseInt(br.readLine()); // 최대 회의의 수 N을 저장하기 위한 변수 maxInput입니다.

        // 회의를 다루기 위한 ArrayList를 생성합니다.
        ArrayList<Meeting> meetings = new ArrayList<>();

        // 이후 총 maxInput만큼의 줄 동안 공백을 기준으로 각 회의의 시작 시간과 끝 시간이 주어집니다.
        for (int i = 0; i < maxInput; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
            // 토큰 기준으로 시작 시간과 끝 시간을 나눠서 입력받습니다.
            int startTime = Integer.parseInt(tokenizer.nextToken());
            int endTime = Integer.parseInt(tokenizer.nextToken());

            meetings.add(new Meeting(startTime, endTime));
        }

        // 회의 시간이 끝나는 게 빠른 걸 선택하는 것이 최적해를 보장하기 때문에
        // 회의가 끝나는 시간을 기준으로 오름차순 정렬합니다.
        // 끝나는 시간이 빠르다면, 시작 시간 기준 오름차순 정렬합니다.
        Collections.sort(meetings, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                if (o1.getEndTime() == o2.getEndTime()) { // 끝나는 시간이 같다면
                    return o1.getStartTime() - o2.getStartTime(); // 시작 시간 기준 오름차순 정렬
                }
                return o1.getEndTime() - o2.getEndTime(); // 끝나는 시간이 다르다면 끝나는 시간 기준 정렬
            }
        });

        // 이제 회의 시간이 끝나는 걸 기준으로 최적해의 개수를 counting 하면 됩니다.
        int bestSolution = 0; // 최적해의 개수를 저장할 변수 bestSolution 입니다.
        int minEndTime = 0; // 가장 빠르게 끝나는 시간을 계속 선택해야 하므로 minEndTime 변수를 만듭니다.

        int nowStartTime = 0; // 현재 시작 시간을 담을 변수
        int nowEndTime = 0; // 현재 종료 시간을 담을 변수
        for (int i = 0; i < meetings.size(); i++) {
            nowStartTime = meetings.get(i).getStartTime();
            nowEndTime = meetings.get(i).getEndTime();

            if (nowStartTime >= minEndTime) { // 현재 시작 시간이 이전 최소 끝나는 시간보다 크거나 같은 경우에만
                minEndTime = nowEndTime; // 최소 끝나는 시간을 변경하고 ( 다음 번째로 이동했습니다. )
                bestSolution++; // 최적해의 개수를 늘립니다.
            }
        }

        System.out.println(bestSolution); // 최적해의 개수를 출력합니다.
    }
}

class Meeting { // 회의 시간을 다루기 위한 Meeting 클래스를 만듭니다.
    final private int startTime; // 회의의 시작 시간을 저장할 변수입니다.
    final private int endTime; // 회의의 종료 시간을 저장할 변수입니다.

    public Meeting(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public int getStartTime() {
        return startTime;
    }
}