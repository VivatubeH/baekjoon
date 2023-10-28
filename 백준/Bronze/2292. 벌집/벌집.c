#include<stdio.h>

int main(void)
{
	int N;
	int i = 0, count = 1;
	int x = 2, y = 7;
	scanf("%d", &N);
	
	while (1)
	{
		count++;
		if (N == 1)
		{
			break;
		}
		if ((x <= N) && (N <= y))
		{
			break;
		}
		if (N > y);
		{
			i++;
			x += (6 * i);
			y += 6 * (i + 1);
		}
	}
	if (N == 1)
	{
		printf("%d", 1);
	}
	else
	{
		printf("%d", count);
	}
	return 0;
}