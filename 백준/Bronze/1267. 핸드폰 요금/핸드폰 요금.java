import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int callCount = scanner.nextInt(); // 통화의 개수를 저장할 변수

        int ysTotalMoney = 0; // 영식 요금제의 총 금액
        int msTotalMoney = 0; // 민식 요금제의 총 금액

        for (int i = 0; i < callCount; i++) {
            int callTime = scanner.nextInt(); // 통화 시간을 저장할 변수

            // 영식 요금제의 금액 구하기
            ysTotalMoney += ((callTime / 30) + 1) * 10;

            // 민식 요금제의 금액 구하기
            msTotalMoney += ((callTime / 60) + 1) * 15;
        }

        // 두 요금제 금액이 같다면 둘 다 출력한 후 금액을 출력합니다.
        if (ysTotalMoney == msTotalMoney) {
            System.out.print("Y M " + ysTotalMoney); // 아무거나 출력하면 됩니다.
        } else {
            // 영식 요금제의 금액이 더 크다면
            if (ysTotalMoney > msTotalMoney) {
                System.out.print("M " + msTotalMoney);
            } else { // 민식 요금제의 금액이 더 크다면
                System.out.print("Y " + ysTotalMoney);
            }
        }
    }
}
