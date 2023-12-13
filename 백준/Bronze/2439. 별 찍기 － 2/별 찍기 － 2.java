import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		for (int i = 1; i<= n; i++) {
			for ( int j = 1; i+j<=n;j++) {
			System.out.print(" ");
			}
			for (int k=1; k<=i;k++) {
		    System.out.print("*");
			}
		System.out.println();
		}
	}
}