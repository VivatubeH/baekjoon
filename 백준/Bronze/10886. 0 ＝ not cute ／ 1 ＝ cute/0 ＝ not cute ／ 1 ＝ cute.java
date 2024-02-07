import java.util.Scanner;

class Main{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = 0;
		int[] tmp = new int[2];
		for(int i=0;i<n;i++) {
			m = in.nextInt();
			if(m==0) tmp[0]++;
			if(m==1) tmp[1]++;
		}
		if(tmp[0]>tmp[1]) System.out.println("Junhee is not cute!");
		else System.out.println("Junhee is cute!");
		}
}