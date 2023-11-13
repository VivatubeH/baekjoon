#include<stdio.h>

int main(void)
{
	int a[5];
	int i;
	int sum = 0;
	for (i = 0; i < 5; i++)
	{
		scanf("%d", &a[i]);
		sum += (a[i] * a[i]);
	}
	printf("%d", sum % 10);
	return 0;
}
