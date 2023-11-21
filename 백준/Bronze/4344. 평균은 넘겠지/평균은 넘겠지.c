#include<stdio.h>

int main(void)
{
	int point[1000];
	double avg = 0;
	int over_count = 0;
	int C = 0, N = 0;
	int i, j;
	scanf("%d", &C);
	for (i = 0; i < C; i++)
	{
		scanf("%d", &N);
		avg = 0;
		for (j = 0; j < N; j++)
		{
			scanf("%d", &point[j]);
			avg += point[j];
		}
		avg /= N;
		over_count = 0;
		for (j = 0; j < N; j++)
		{
			if (point[j] > avg)
			{
				over_count++;
			}
		}
		printf("%.3lf%%\n", (double)over_count*100 / N);
	}
	return 0;
}