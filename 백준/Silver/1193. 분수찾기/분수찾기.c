#include<stdio.h>

int main(void)
{
	int X;
	int a, b, c = 0;
	int n = 1;

	scanf("%d", &X);
	while (1)
	{
		if (((n * (n - 1)) / 2 < X) && (n * (n + 1)) / 2 >= X)
		{
			break;
		}
		n++;
	}

	if (n % 2 == 0)
	{
		c = (n * (n + 1)) / 2 - X;
		a = n - c;
		b = 1 + c;
	}
	else
	{
		c = (n * (n + 1)) / 2 - X;
		a = 1 + c;
		b = n - c;
	}

	if (X == 1)
	{
		printf("%d/%d", 1, 1);
	}
	else
	{
		printf("%d/%d", a, b);
	}
}
