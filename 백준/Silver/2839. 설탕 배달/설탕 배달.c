#include<stdio.h>

int main(void)
{
	int count_3 = 0;
	int count_5 = 0;
	int N;
	scanf("%d", &N);
	while (N > 0)
	{
		if (N % 5 == 0)
		{
			N -= 5;
			count_5++;
		}
		else
		{
			N -= 3;
			count_3++;
		}
	}
	if (N == 0) printf("%d", count_5 + count_3);
	else printf("%d", -1);
	return 0;
}