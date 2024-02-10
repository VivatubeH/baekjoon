import java.util.Scanner;

class Main{
	public static void main(String[] args) {
		int[][] apt = new int[15][15];
		for(int i=0;i<=14;i++) {
			apt[0][i] = i;
			apt[i][0] = 0;
		}
		for(int i=1;i<=14;i++) {
			for(int j=1;j<=14;j++) {
				apt[i][j] = apt[i][j-1]+apt[i-1][j];
			}
		}
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i=0;i<t;i++) {
			int k = in.nextInt();
			int n = in.nextInt();
			System.out.println(apt[k][n]);
		}
	}
}