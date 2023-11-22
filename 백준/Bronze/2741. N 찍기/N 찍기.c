#include <stdio.h>

int main()
{
	int N;
	int start = 1;
	scanf("%d", &N);
	while (1)
	{
		printf("%d\n", start);
		if (N == start) break;
		start++;
	}
	return 0;
}