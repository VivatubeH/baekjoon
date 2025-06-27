import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[3];

        int max = 0;
        int min = 1000001;
        for (int i = 0; i < 3; i++) {
            int num = scanner.nextInt();
            array[i] = num;
            if (num > max) max = num;
            if (num < min) min = num;
        }
        int mid = 0;
        for (int i = 0; i < 3; i++) {
            if (array[i] != min && array[i] != max) {
                mid = array[i];
            }
        }
        System.out.print(min + " " + mid + " " + max);
    }
}
