import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N  = in.nextInt();
		int X = in.nextInt();
		
		int[] a = new int[N];
		for ( int i =0; i<N; i++) {
			a[i] = in.nextInt();
			if ( a[i] < X) System.out.print(a[i]+" ");
		}
	}
}