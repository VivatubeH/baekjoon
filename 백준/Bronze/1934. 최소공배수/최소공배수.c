#include<stdio.h>

int main(void)
{
	int T;
	int A, B;
	int i, j;
	int max = 0;
	long long min;
	scanf("%d", &T);
	for (i = 0; i < T; i++)
	{
		scanf("%d%d", &A, &B);
		if (A > B)
		{
			for (j = 1; j <= B; j++)
			{
				if ((A % j == 0) && (B % j == 0))
				{
					max = j;
				}
			}
			min = (A / max) * (B / max) * max;
		}
		if (A == B) min = A;
		if (A < B)
		{
			for (j = 1; j <= A; j++)
			{
				if ((A % j == 0) && (B % j == 0))
				{
					max = j;
				}
			}
			min = (A / max) * (B / max) * max;
		}
		printf("%lld\n", min);
	}
	return 0;
}