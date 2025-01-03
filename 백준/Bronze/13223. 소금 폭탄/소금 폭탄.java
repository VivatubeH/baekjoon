import java.util.Scanner;

/*
철수는 화학 시험을 망치고, 애꿎은 화학 선생님에게 복수를하기로 한다.

철수는 집에서 만든 자동 로봇팔을 선생님의 책상에 숨겨,
선생님이 수업을 시작하려 들어온 순간 숨겨놓은 로봇팔을 이용해 선생님을 혼내주려고한다.
철수는 선생님이 늘 애용하는 물컵에 시간이 되면 로봇팔이 소금을 잔뜩 집어넣도록
프로그램을 짜려고한다.

철수는 현재시각과 선생님이 언제 컵을 사용할지 시간을 알고있지만,
수 계산에 정말 약해서 로봇팔에 입력해야할 시간 계산을 못한다.
철수가 로봇팔에 알맞은 시간을 입력할수 있도록 도와주자.

입력
첫째 줄에는 현재 시각이 hh:mm:ss로 주어진다.
시간의 경우 0≤h≤23 이며, 분과 초는 각각 0≤m≤59, 0≤s≤59 이다.

두 번째 줄에는 소금 투하의 시간이 hh:mm:ss로 주어진다.

출력
로봇팔이 소금을 투하할때까지 필요한 시간을 hh:mm:ss로 출력한다.
이 시간은 1초보다 크거나 같고, 24시간보다 작거나 같다.

예제 입력 1
20:00:00
04:00:00
예제 출력 1
08:00:00
예제 입력 2
12:34:56
14:36:22
예제 출력 2
02:01:26
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String currentTime = scanner.nextLine(); // 현재 시간
        String inputTime = scanner.nextLine(); // 입력된 소금 투하 시간

        String[] currentHMS = currentTime.split(":"); // 현재 시분초 -> 각각 문자열
        String[] inputHMS = inputTime.split(":"); // 입력한 시분초 -> 각각 문자열

        int currentHour = Integer.parseInt(currentHMS[0]); // 현재 시
        int currentMinute = Integer.parseInt(currentHMS[1]); // 현재 분
        int currentSecond = Integer.parseInt(currentHMS[2]); // 현재 초

        int inputHour = Integer.parseInt(inputHMS[0]); // 입력 시
        int inputMinute = Integer.parseInt(inputHMS[1]); // 입력 분
        int inputSecond = Integer.parseInt(inputHMS[2]); // 입력 초

        int currentTotal = currentHour*60*60 + currentMinute*60 + currentSecond;
        int inputTotal = inputHour*60*60 + inputMinute*60 + inputSecond;
        // 초단위 환산으로 계산을 용이하게 하기 위해서

        // 현재의 총 초가 더 길다 -> 입력한 총 초가 다음날이므로 24시간치 초를 더해준다.
        if (currentTotal > inputTotal) {
            inputTotal += 24 * 60 * 60;
        }
        // 총 초가 같으면 시간 보정이 필요하다 ->
        if (currentTotal == inputTotal) {
            inputTotal += 24 * 60 * 60;
        }
        // 입력한 초가 더 긴 경우는 같은 날이니 시간 보정이 필요없다.

        int resultTotal = 0; // 결과로 나올 시간의 총 초
        resultTotal = inputTotal - currentTotal; // 결과로 나올 시간의 총 초 구하는 연산

        // 이렇게 구한 초를 각각 시, 분, 초로 변환해야 한다.
        int resultHour = 0; // 결과로 나올 시
        int resultMinute = 0; // 결과로 나올 분
        int resultSecond = 0; // 결과로 나올 초

        resultHour = resultTotal / (60*60);
        resultTotal %= (60*60);
        resultMinute = resultTotal / 60;
        resultTotal %= 60;
        resultSecond = resultTotal;

        // 시, 분, 초를 구했고 출력만 남았다.
        // 단 10보다 작은 경우는 앞에 0을 붙여야 하므로 형식만 변경해준다.
        System.out.println(String.format("%02d", resultHour) + ":" + String.format("%02d", resultMinute) + ":" + String.format("%02d", resultSecond));
    }
}
