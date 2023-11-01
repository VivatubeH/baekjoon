#include<stdio.h>

int main(void)
{
	int a = 0, b = 0, c = 0;
	int max, len;
	scanf("%d%d%d", &a, &b, &c);
	max = a;
	if (b > max) max = b;
	if (c > max) max = c;

	if (a == max)
	{
		while (max >= b + c)
		{
			max--;
		}
		len = max + b + c;
	}
	else if (b == max) // b == 100
	{
		while (max >= a + c)
		{
			max--;
		}
		len = max + a + c;
	}
	else if (c == max)
	{
		while (max >= a + b)
		{
			max--;
		}
		len = max + a + b;
	}
	printf("%d", len);
	return 0;
}