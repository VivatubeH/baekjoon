#include <stdio.h>

int main(void)
{
	int N;
	char ch;
	int point = 0;
	int count = 1;
	scanf("%d", &N);
	fgetc(stdin);
	for (int i = 0; i < N; i++) // N = 5인경우 i= 0, 1, 2, 3, 4 5번 진행
	{
		point = 0, count = 1; 
		while ((ch=getchar()) != '\n')
		{
			if (ch == 'O')
			{
				point += count;
				count++;
			}
			if (ch == 'X')
			{
				count = 1;
			}
		}
		printf("%d\n", point);
	}
	return 0;
}