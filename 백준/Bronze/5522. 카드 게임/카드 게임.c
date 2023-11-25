#include<stdio.h>

int main()
{
	int score[5];
	int i;
	int total = 0;
	for (i = 0; i < 5; i++)
	{
		scanf("%d", &score[i]);
		total += score[i];
	}
	printf("%d", total);
	return 0;
}