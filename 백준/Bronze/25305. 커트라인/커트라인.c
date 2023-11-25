#include <stdio.h>

int main(void)
{
	int N, K;
	int temp, i;
	int count = 0;
	int score[10000];
	scanf("%d%d", &N, &K);
	for (i = 0; i < N; i++)
	{
		scanf("%d", &score[i]);
	}
	while (1)
	{
		count = 0;
		for (i = 0; i < N - 1; i++)
		{
			if (score[i] > score[i + 1])
			{
				temp = score[i];
				score[i] = score[i + 1];
				score[i + 1] = temp;
				count++;
			}
		}
		if (count == 0) break;
	}
	printf("%d", score[N - K]);
	return 0;
}