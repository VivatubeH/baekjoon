#include<stdio.h>

int main(void)
{
	int A, B, C;
	int num = 0;
	int i = 0;
	scanf("%d%d%d", &A, &B, &C);
	num = A * B * C;
	int com[10] = { 0 };
	while (num != 0)
	{
		i = num % 10;
		com[i]++;
		num = num / 10;
	}
	for (i = 0; i < 10; i++)
	{
		printf("%d\n", com[i]);
	}
	return 0;
}