#include<stdio.h>

int main(void)
{
	int N = 0;
	long long sum = 0;
	int x, y = 0;
	int max_x, min_x, max_y, min_y = 0;
	int i = 0;

	scanf("%d", &N);
	scanf("%d %d", &x, &y);
	max_x = min_x = x;
	max_y = min_y = y;
	sum = (max_x - min_x) * (max_y - min_y);
	// 초기 세팅

	for (i = 1; i < N; i++)
	{
		scanf("%d %d", &x, &y);
		if (x < min_x)
		{
			min_x = x;
		}
		if (y < min_y)
		{
			min_y = y;
		}
		if (x > max_x)
		{
			max_x = x;
		}
		if (y > max_y)
		{
			max_y = y;
		}
	}
	sum = (max_x - min_x) * (max_y - min_y);
	printf("%lld", sum);
	return 0;
}
