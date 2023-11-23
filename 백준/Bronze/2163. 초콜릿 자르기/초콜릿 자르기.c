#include <stdio.h>

int main(void)
{
	int N, M;
	int count = 0;
	scanf("%d%d", &N, &M);
	if (N == 1 && M == 1) count = 0;
	else count = N * M - 1;
	printf("%d", count);
	return 0;
}