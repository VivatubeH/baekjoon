#include<stdio.h>

int main(void)
{
	int min1, min2 = 0;
	int x, y, w, h;
	scanf("%d %d %d %d", &x, &y, &w, &h);

	if (x < y)
	{
		min1 = x;
	}
	else
	{
		min1 = y;
	}

	if (w - x < h - y)
	{
		min2 = w - x;
	}
	else
	{
		min2 = h - y;
	}
	
	if (min1 < min2)
	{
		printf("%d", min1);
	}
	else
	{
		printf("%d", min2);
	}

	return 0;
}
