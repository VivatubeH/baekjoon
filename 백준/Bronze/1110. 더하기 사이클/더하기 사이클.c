#include<stdio.h>

int main(void)
{
	int sum = 0;
	int N;
	int cycle = 0;
	scanf("%d", &N);
	int new_number = N;
	while (1)
	{
		sum = (new_number / 10) + (new_number % 10);
		new_number = (new_number % 10) * 10 + (sum % 10);
		cycle++;
		if (new_number == N)break;
	}
	printf("%d", cycle);
	return 0;
}