import java.util.Scanner;

class Main{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		int[] ball = new int[n+1];
		for (int i =1; i<n+1;i++) {
			ball[i] = i;
		}
		for (int t =0; t<m; t++){
			int i = in.nextInt();
			int j = in.nextInt();
			
			int tmp = 0;
			tmp = ball[i];
			ball[i] = ball[j];
			ball[j] = tmp;
		}
		for (int t=1; t<=n; t++) {
			System.out.print(ball[t] + " ");
			}
	}
}