import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int S = scanner.nextInt();
		int T = scanner.nextInt();
		int D = scanner.nextInt();
		
		int time = D/(S*2);
		System.out.println(time*T);
		scanner.close();
	}
}
