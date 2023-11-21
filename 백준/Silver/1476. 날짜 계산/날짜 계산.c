#include <stdio.h>

int main()
{
	int N = 1;
	int E, S, M;
	scanf("%d%d%d", &E, &S, &M);
	while (1)
	{
		if ((N - E)%15 == 0 && (N-S)% 28 == 0 && (N-M)%19 == 0)
		{
			break;
		}
		N++;
	}
	printf("%d", N);
	return 0;
}