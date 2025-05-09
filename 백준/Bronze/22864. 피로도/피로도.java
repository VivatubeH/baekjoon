import java.io.*;
import java.util.*;

public class Main {
    public static int tph; // tired per hour -> 시간당 피로도
    public static int wph; // work per hour -> 시간당 일처리량
    public static int rph; // rest per hour -> 시간당 휴식량
    public static int limit; // 피로도의 한계
    public static final int HOUR = 24; // 하루는 24시간, 변경 불가

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        tph = Integer.parseInt(token.nextToken());
        wph = Integer.parseInt(token.nextToken());
        rph = Integer.parseInt(token.nextToken());
        limit = Integer.parseInt(token.nextToken());

        // 메서드를 통해 하루에 할 수 있는 최대 일처리량 구해서 출력하기
        System.out.println(getMaxWork());
    }

    public static int getMaxWork() {
        int remainHour = HOUR; // 현재 남은 시간
        int currentTired = 0; // 현재 피로도
        int maxWork = 0; // 하루에 최대 수행 가능한 일의 양

        while (true) {
            // 어차피 24시간동안이라 나누기 연산 없이 매 시간 간격으로 돌아버립니다.

            // 일이 가능하면 일을 시키고, 불가능하면 휴식합니다.
            if (currentTired + tph <= limit) { // 시간당 피로만큼이 누적되도 피로도의 한계를 넘지 않는 이상
                maxWork += wph; // 일을 시키고
                currentTired += tph; // 그만큼 피로가 쌓이고
                remainHour--; // 남은 시간이 1 감소합니다.
            } else { // 일이 불가능하면 휴식을 부여합니다.
                if (currentTired - rph < 0) { // 피로도가 음수가 되는 상황이라면 피로도를 0으로 만듭니다.
                    currentTired = 0;
                    remainHour--; // 남은 시간이 1 감소합니다.
                } else { // 피로도가 음수가 되지 않는다면
                    currentTired -= rph; // 피로도를 그만큼 감소시킵니다.
                    remainHour--; // 남은 시간이 1 감소합니다.
                }
            }
            if (remainHour == 0)  { // 하루가 종료되면 반복문을 끝냅니다.
                break;
            }
        }
        return maxWork;
    }
}
