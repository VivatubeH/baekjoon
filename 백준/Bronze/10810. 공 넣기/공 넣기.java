import java.util.Scanner;

class Main{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		int[] ball = new int[n+1];
		for (int t =0; t<m; t++){
			int i = in.nextInt();
			int j = in.nextInt();
			int k = in.nextInt();
			for ( int p = i; p<= j; p++) {
				ball[p] = k;
			}
		}
		for (int t=1; t<=n; t++) {
			System.out.print(ball[t] + " ");
			}
	}
}