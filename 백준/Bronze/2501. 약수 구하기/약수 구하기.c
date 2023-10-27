#include <stdio.h>

int main(void)
{
	int N, K;
	int i;
	int a, count = 0;

	scanf("%d %d", &N, &K);
	for (i = 1; i <= N; i++)
	{
		if (N % i == 0)
		{
			a = i;
			count++;
			if (K == count) break;
		}
	}
	if (count < K)
	{
		printf("%d", 0);
	}
	else
	{
		printf("%d", a);
	}
	return 0;
}