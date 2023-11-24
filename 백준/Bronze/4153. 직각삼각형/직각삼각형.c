#include <stdio.h>

void R_triangle(int x, int y, int z);

int main(void)
{
	int a, b, c;
	while (1)
	{
		scanf("%d%d%d", &a, &b, &c);
		if (a == 0 && b == 0 && c == 0) break;
		R_triangle(a, b, c);
	}
	return 0;
}

void R_triangle(int x, int y, int z)
{
	int max = x;
	if (y > max) max = y;
	if (z > max) max = z;

	if (max == x)
	{
		if (max * max == y * y + z * z)
		{
			printf("right\n");
		}
		else printf("wrong\n");
	}
	if (max == y)
	{
		if (max * max == x * x + z * z)
		{
			printf("right\n");
		}
		else printf("wrong\n");
	}
	if (max == z)
	{
		if (max * max == x * x + y * y)
		{
			printf("right\n");
		}
		else printf("wrong\n");
	}
}