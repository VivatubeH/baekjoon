#include<stdio.h>

int main(void)
{
	int i = 0, j = 0, k = 0;
	int save[100000] = { 0, };
	int n;
	int sum = 0;

	while (1)
	{
		sum = 0;
		j = 0;
		scanf("%d", &n);

		if (n == -1)
		{
			return 0;
		}

		for (i = 1; i < n; i++)
		{
			if (n % i == 0)
			{
				sum += i;
				save[j] = i;
				j++;
			}
		}

		if (sum == n)
		{
			printf("%d = %d", n, save[0]);
			for (k = 1; k < j; k++)
			{
				printf(" + %d", save[k]);
			}
			printf("\n");
		}

		if (sum != n)
		{
			printf("%d is NOT perfect.\n", n);
		}
	}
	return 0;
}