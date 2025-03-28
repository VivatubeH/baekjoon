import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 첫째 줄에 바퀴의 칸 수 N과 바퀴 돌리는 횟수 K가 공백을 기준으로 입력됩니다.
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());

        // 바퀴를 다루는 클래스의 메서드들을 사용하기 위해 바퀴 인스턴스를 생성하면서
        // 생성자로 바퀴의 칸 수를 넘겨줍니다.
        Wheel wheel = new Wheel(N);

        // 이후 K번 바퀴를 돌리게 됩니다.
        for (int i = 0; i < K; i++) {
            // 사용자의 명령을 입력받아서 그만큼 바퀴를 돌리겠습니다.
            StringTokenizer instrunctions = new StringTokenizer(br.readLine(), " ");
            // 몇 번 글자가 바뀌는지, 어떤 알파벳을 가리키는 지를 저장합니다.
            int count = Integer.parseInt(instrunctions.nextToken());
            char alphabet = instrunctions.nextToken().charAt(0); // "A"와 같은 알파벳에서 'A'를 문자로 반환합니다.
            // 바퀴를 돌립니다.
            wheel.spinTheWheel(count, alphabet);

            // 결정되지 않으면 바로 출력하라는 말이 없으므로 일단 모든 입력은 다 받고 이후 출력하겠습니다.
        }

        wheel.printTheWheel();
    }
}

// 바퀴를 다루는 클래스입니다.
class Wheel {
    // 칸 수에 맞게 바퀴를 담을 char 배열을 사용해야 하므로, char[] 변수를 생성합니다.
    // 메서드가 반복 실행되면서 칸들을 계산해야 하니, 클래스의 인스턴스 변수로 생성합니다.
    private char[] wheel;
    private int index = 0; // 현재 인덱스를 저장하는데, 초기 시작위치는 0으로 잡습니다.
    private int size = 0; // 칸수인 size를 저장합니다.
    private boolean isDetermined = true; // 결정되었는지 여부를 저장할 변수 isDetermined입니다.

    public boolean getIsDetermined() {
        return isDetermined;
    }

    public Wheel(int size) {
        wheel = new char[size]; // 사용자로부터 입력받은 칸 수만큼 바퀴를 담을 배열을 생성합니다.
        for (int i = 0; i < size; i++) {
            wheel[i] = '?'; // 일단 모든 문자의 기본값은 ?입니다.
        }
        this.size = size;
    }

    // 바퀴를 돌릴 때는, 매번 사용자로부터 글자가 바뀐 횟수와 회전을 멈추었을 때 가리키는 글자가 주어집니다.
    public void spinTheWheel(int count, char alphabet) {
        // 시계 방향으로 회전시키면, 글자는 시계 반대방향으로 할당되므로 반대방향으로 진행합니다.
        int realmove = count % size; // 불필요한 계산을 없애기 위해 주기를 구합니다.
        // 먼저 이동을 구현하고, 이동한 현재 인덱스를 wheel에 저장합니다.
        // 이동 : 인덱스인 index를 변경합니다.

        // index가 realMove보다 크거나 같으면 단순히 index를 빼주면 됩니다. ( 좌측 끝에 닫지 못함 )
        if (index >= realmove) {
            index = index - realmove;
        } else { // 만약 index보다 realMove가 크다면 우측 끝(size-1)에서부터 Math.abs(index-count) - 1칸 이동이 필요합니다.
            index = (size - 1) - (Math.abs(index-realmove) - 1);
        }
        // index를 구한 뒤에 해당 index에 알파벳을 저장해야 합니다.
        // 이 때 저장하려는 알파벳과 동일한 문자가 다른 index에 존재하면
        // isDetermined를 false로 바꾼 후 종료합니다.
        for (int i = 0; i < size; i++) {
            if (alphabet == wheel[i] && i != index) {
                isDetermined = false;
                return;
            }
        }

        // 해당 인덱스에 문자가 할당되지 않은 상태라면
        if (wheel[index] == '?') {
            wheel[index] = alphabet; // 문자를 저장해줍니다.
        } // 문자가 할당되었는데, 할당된 문자가 지금의 문자와 다르다면
        else if (wheel[index] != '?' && wheel[index] != alphabet) {
            isDetermined = false; // 결정되지 않았으므로 false를 할당하고
            return;  // 종료합니다.
        }
    }

    // 출력은 !가 포함된 경우라면 !만 출력하고 종료합니다.
    public void printTheWheel() {
        String str = String.valueOf(wheel);

        if (!isDetermined) { // 결정되지 않은 경우
            System.out.println("!"); // !를 출력하고 종료합니다.
            return;
        }

        System.out.print(str.substring(index));
        System.out.print(str.substring(0, index));
    }

}
