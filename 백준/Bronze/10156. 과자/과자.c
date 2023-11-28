#include<stdio.h>

int main(void)
{
	int k, n, m;
	scanf("%d %d %d", &k, &n, &m);
	if (m >= (k * n)) printf("%d", 0);
	else printf("%d", k * n - m);
	return 0;
}