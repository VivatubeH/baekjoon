#include<stdio.h>

int main(void)
{
	int N;
	int i;
	int case_num = 1;
	scanf("%d", &N);
	for (i = 0; i < N; i++) case_num *= 2;
	printf("%d", case_num);
	return 0;
}