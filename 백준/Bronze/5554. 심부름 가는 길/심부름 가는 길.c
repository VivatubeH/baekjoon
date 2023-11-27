#include<stdio.h>

int main(void)
{
	int sec[4];
	int i;
	int total = 0;
	for (i = 0; i < 4; i++)
	{
		scanf("%d", &sec[i]);
		total += sec[i];
	}
	printf("%d\n%d", total / 60, total % 60);
	return 0;
}