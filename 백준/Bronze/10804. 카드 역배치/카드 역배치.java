import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[21]; // 1 ~ 20까지 인덱스를 그대로 쓰기 위해 1크게 만든다.
        // 초기값을 1부터 20까지 심어둔다.
        for (int i = 1; i <= 20; i++) {
            array[i] = i;
        }
        // 10개의 줄에 걸쳐서 한 줄에 하나씩 10개의 구간이 주어지는데
        // 구간의 시작점인 a, 구간의 끝점인 b가 주어진다.
        Scanner scanner = new Scanner(System.in);
        for (int j = 0; j < 10; j++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            // 뒤집힌 배열을 반영한다.
            array = reverseFromAtoB(array, a, b);
        }
        // 마지막 카드들의 배치를 출력한다.
        for (int i = 1; i <= 20; i++) {
            System.out.print(array[i] + " ");
        }
    }

    // 배열의 start부터 end 위치까지를 뒤집는 메서드
    // 뒤집은 이후에는 뒤집은 배열을 반환해서, 뒤집힌 배열을 계속 뒤집도록 한다.
    public static int[] reverseFromAtoB(int[] arr, int start, int end) {
        while (start < end) { // 시작 위치와 끝 위치가 같을 때는 바꿀 필요가 없다.
            int temp = arr[start]; // 시작값을 임시변수에 저장하고
            arr[start] = arr[end]; // 시작값에 끝값을 넣고
            arr[end] = temp; // 끝값에 시작값을 넣는다.

            start++; // 시작 위치는 뒤로 이동하고
            end--; // 끝 위치는 앞으로 이동한다.
        }
        return arr; // 뒤집힌 배열을 반환한다.
    }
}
