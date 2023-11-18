import java.util.Scanner;

class Main{
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int A = in.nextInt();
		int B = in.nextInt();
		System.out.printf("%d", A+B);
		in.close();
	}
}
