#include <stdio.h>

int main(void)
{
	int H, W, N;
	int T;
	int i;
	int x, y;
	scanf("%d", &T);
	for (i = 0; i < T; i++)
	{
		scanf("%d%d%d", &H, &W, &N);
		x = 0, y = 0;
		if (N % H == 0) x = H;
		else x = N % H;
		while (N > 0)
		{
			N -= H;
			y++;
		}
		printf("%d\n", x * 100 + y);
	}
	return 0;
}