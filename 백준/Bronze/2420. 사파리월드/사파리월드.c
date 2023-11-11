#include<stdio.h>

int main(void)
{
	long long N, M;
	scanf("%lld%lld", &N, &M);
	if (N - M < 0)
	printf("%lld", -(N - M));
	else printf("%lld", N - M);
	return 0;
}
