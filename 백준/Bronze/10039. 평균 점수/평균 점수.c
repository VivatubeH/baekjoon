#include <stdio.h>

int main(void)
{
	int point[5];
	int total = 0;
	int i = 0;
	for (i = 0; i < 5; i++)
	{
		scanf("%d", &point[i]);
		if (point[i] < 40) point[i] = 40;
		total += point[i];
	}
	printf("%d", total / 5);
	return 0;
}