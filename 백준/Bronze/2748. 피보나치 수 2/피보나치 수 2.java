import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		long[] t = new long[91];
		t[0] = 0;
		t[1] = 1;
		for(int i=2;i<t.length;i++) {
			t[i] = t[i-2]+t[i-1];  
		}
		System.out.println(t[n]);
		}
}
