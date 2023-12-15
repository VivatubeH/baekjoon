import java.util.Scanner;


	class Main {
			public static void main(String[] args) {
				Scanner in = new Scanner(System.in);

				int n  = in.nextInt();
				int[] a = new int[n];
				int max = -1000000;
				int min = 1000000;
				
				for (int i =0; i<n;i++) {
					a[i] = in.nextInt();
				}
				for (int i =0;i<n;i++) {
				 if ( a[i] > max ) max = a[i];
				 if ( a[i] < min ) min = a[i];
				}
				System.out.print(min+" "+max);
			}
	}
