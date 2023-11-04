#include<stdio.h>

int main(void)
{
	int N;
	int count = 0;
	scanf("%d", &N);
	for (int i = 1; i*i <= N; i++)
	{
		if (N >= i * i)
		{
			count++;
		}
	}
	printf("%d", count);
	return 0;
}