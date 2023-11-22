#include <stdio.h>

int main()
{
	int N;
	int i;
	int count_2 = 0;
	int count_5 = 0;
	int current = 0;
	scanf("%d", &N);
	/* 5! = 5x4x3x2x1 = 5x2x3x4x1 ( 5x2가 곱해지면 10의 배수, 그러면 0이 하나 붙음.
	   10! = 10x9x8x7x6x5x4x3x2x1 ( 10 = 5x2, 5x2 10의 배수가 2번 곱해짐. 그러면 0이 2개 붙음
	   계산하면 overflow가 날 테니, 계산할 필요 없이 2와 5의 개수를 세서
	   2와 5의 개수 중 적은 수가 총 0의 개수가 될 거임. ( 왜냐하면 2x5로 0의 개수가 결정날테니 ) */
	for (i = N; i >= 1; i--)
	{
		current = i;
		while (current % 2 == 0)
		{
			current /= 2;
			count_2++;
		}
		while (current % 5 == 0)
		{
			current /= 5;
			count_5++;
		}
	}
	int min_count = ((count_2 < count_5) ? count_2 : count_5);
	printf("%d", min_count);
	return 0;
}