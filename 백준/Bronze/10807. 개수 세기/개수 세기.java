import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int[] t = new int[n];
		
		for(int i=0;i<n;i++) {
			t[i] = in.nextInt();
		}
		int k = in.nextInt();
		int num = 0;
		for (int i =0; i<n;i++) {
			if ( t[i] == k ) num++;
		}
		System.out.println(num);
	}
}