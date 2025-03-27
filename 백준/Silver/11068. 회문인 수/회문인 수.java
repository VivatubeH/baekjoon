import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 표준 입출력을 사용하겠습니다.
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int number = scanner.nextInt(); // 정수를 입력받습니다.
            boolean isAnswer = false;
            // 해당 수가 1번이라도 회문이 되면 회문인 것이므로
            for (int j = 2; j <= 64; j++) {
                // 한 번이라도 회문이 되면 isAnswer을 true로 바꾸고 종료합니다.
                if (makeFormation(number, j)) {
                    isAnswer = true;
                    break;
                }
            }
            if (isAnswer) System.out.println(1);
            else System.out.println(0);
        }
    }

    // 진법 변환을 하기 위한 메서드를 생성합니다.
    // n : 입력되는 어떤 수, b : 진법
    public static boolean makeFormation(int n, int b) {
        // 원래 수를 진법변환하기 위한 변수를 선언합니다.
        StringBuilder sb = new StringBuilder();
        // 어떤 수를 계속해서 n으로 나눠야 하기 때문에 연산에 사용할 현재값 변수 currentValue를 선언합니다.
        int currentValue = n;
        // 나머지를 계속해서 이어붙여야하기 때문에 나머지 변수 remain을 선언합니다.
        int remain = 0;

        // 64진법에 해당하는 문자가 필요한데
        // 나머지가 0~9는 그대로, 10부터 A이고 사실 회문한다는 건 그 이상 문자가 무엇인지는 중요하지 않고
        // 대칭성을 뛰냐만 판단하면 되기 때문에 임의의 문자만 할당해줄 것입니다.
        char[] alphabets = new char[64]; // 나머지는 0부터 63까지이고, 이에 따라 문자가 정해집니다.
        for(int i = 0; i < alphabets.length; i++) {
            alphabets[i] = (char)('0' + i);
        }
        // b 진법을 구하는 로직은 다음과 같습니다.
        // 만약 currentValue가 b보다 작다면 -> currentValue를 이어붙이고 끝냅니다.
        // currentValue가 b보다 크거나 같다면 -> b로 나눈 나머지를 구하고, 그 수는 줄여나갑니다.

        // 이 과정을 계속 반복합니다.
        while (true) {
            if (currentValue < b) {
                sb.append(alphabets[currentValue]);
                break;
            }
            remain = currentValue%b;
            currentValue = currentValue/b;
            sb.append(alphabets[remain]); // 나머지를 이어붙입니다.
        }
        // 그 문자가 회문이 되면 종료하면 되기 때문에
        String str1 = sb.toString(); // 해당 문자열
        String str2 = sb.reverse().toString(); // 뒤집은 문자열

        return str1.equals(str2);
    }
}
