import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		long A = in.nextInt();
		int B = in.nextInt();
		
		System.out.println((A+B)*(A-B));
	}
}