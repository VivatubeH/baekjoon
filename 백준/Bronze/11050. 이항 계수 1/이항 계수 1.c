#include<stdio.h>

int Combination(int a, int b);

int main(void)
{
	int N, K;
	scanf("%d%d", &N, &K);
	printf("%d", Combination(N, K));
	return 0;
}

int Combination(int a, int b)
{
	int i;
	int factorial1 = 1;
	int factorial2 = 1;
	int factorial3 = 1;
	for (i = 1; i <= a; i++)
	{
		factorial1 *= i;
	}
	for (i = 1; i <= a-b; i++)
	{
		factorial2 *= i;
	}
	for (i = 1; i <= b; i++)
	{
		factorial3 *= i;
	}
	return factorial1 / (factorial2 * factorial3);
}