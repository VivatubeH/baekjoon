#include<stdio.h>

int main(void)
{
	int a, b, c;
	scanf("%d%d%d", &a, &b, &c);
	if (a + b + c == 180)
	{
		if ((a == b) && (b == c))
		{
			printf("Equilateral");
		}
		else if ((a != b) && (b != c) && (a != c))
		{
			printf("Scalene");
		}
		else
		{
			printf("Isosceles");
		}
	}
	else
	{
		printf("Error");
	}
	return 0;
}