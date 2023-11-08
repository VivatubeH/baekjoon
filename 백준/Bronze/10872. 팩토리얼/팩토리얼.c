#include<stdio.h>

int factorial(int a);

int main(void)
{
	int N;
	scanf("%d", &N);
	printf("%d", factorial(N));
	return 0;
}

int factorial(int a)
{
	int res = 1;
	while (a >= 1)
	{
		res *= a;
		a--;
	}
	return res;
}