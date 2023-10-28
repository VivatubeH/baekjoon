#include<stdio.h>

int main(void)
{
	int p1[2], p2[2], p3[2];
	int p4[2];
	int i;

	scanf("%d %d", &p1[0], &p1[1]);
	scanf("%d %d", &p2[0], &p2[1]);
	scanf("%d %d", &p3[0], &p3[1]);

	for (i = 0; i <= 1; i++)
	{
		if (p1[i] == p2[i])
		{
			p4[i] = p3[i];
		}
		if (p1[i] == p3[i])
		{
			p4[i] = p2[i];
		}
		if (p2[i] == p3[i])
		{
			p4[i] = p1[i];
		}
	}
	printf("%d %d", p4[0],p4[1]);
	return 0;
}
