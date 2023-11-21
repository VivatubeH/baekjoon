#include<stdio.h>

int main(void)
{
	int a, b;
	int i;
	int max = 0, min = 0;
	scanf("%d%d", &a, &b);
	for (i = 1; i <= ((a > b) ? a : b); i++)
	{
		if ((a % i == 0) && (b % i == 0))
		{
			max = i;
		}
	}
	min = max * (a / max) * (b / max);
	printf("%d\n%d", max, min);
	return 0;
}