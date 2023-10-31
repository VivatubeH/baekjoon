#include<stdio.h>

int main(void)
{
	int N;
	scanf("%d", &N);
	int i;
	if (N == 1) return 0;
	for (i = 2; i <= N; i++)
	{
		if (N % i == 0)
		{
			printf("%d\n", i);
			N = N / i;
			i = 1;
		}
	}
	return 0;
}