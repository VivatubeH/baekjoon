#include<stdio.h>

int main(void)
{
	int N[5];
	int i;
	int avg = 0;
	int count = 1;
	int temp = 0;
	for (i = 0; i < 5; i++)
	{
		scanf("%d", &N[i]);
	}
	for (i = 0; i < 5; i++)
	{
		avg += (N[i] / 5);
	}
	while (count != 0)
	{
		count = 0;
		for (i = 0; i < 4; i++)
		{
			if (N[i] > N[i + 1])
			{
				temp = N[i];
				N[i] = N[i + 1];
				N[i + 1] = temp;
				count++;
			}
		}
	}
	printf("%d\n%d", avg, N[2]);
	return 0;
}
