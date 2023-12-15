import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N  = in.nextInt();

		System.out.print((int)(N*0.78)+" "+(int)(0.8*N+(0.2*N*0.78)));
	}
}