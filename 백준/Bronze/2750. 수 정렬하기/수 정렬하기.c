#include<stdio.h>

int main(void)
{
	int count = 1;
	int N;
	int a[1000];
	int i;
	int temp = 0;
	scanf("%d", &N);
	for (i = 0; i < N; i++)
	{
		scanf("%d", &a[i]);
	}
	while (count != 0)
	{
		count = 0;
		for (i = 0; i < N - 1; i++)
		{
			if (a[i] > a[i + 1])
			{
				temp = a[i];
				a[i] = a[i + 1];
				a[i + 1] = temp;
				count++;
			}
		}
	}
	for (i = 0; i < N; i++)
	{
		printf("%d\n", a[i]);
	}
	return 0;
}