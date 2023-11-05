#include<stdio.h>

int main(void)
{
	long long A, B;
	long long min = 0, max = 0;
	int i = 0;

	scanf("%lld%lld", &A, &B);

	if (A >= B)
	{
		for (i = 1; i <= B; i++)
		{
			if ((A % i == 0) && (B % i == 0))
			{
				max = i;
			}
		}
	}
	else
	{
		for (i = 1; i <= A; i++)
		{
			if ((A % i == 0) && (B % i == 0))
			{
				max = i;
			}
		}
	}
	min = max * (A / max) * (B / max);
	printf("%lld", min);
	return 0;
}