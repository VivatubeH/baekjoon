#include<stdio.h>

int main(void)
{
	int i = 0;
	int count = 0;
	int N;
	scanf("%d", &N);
	for (i = 1; i <= N; i++) // 1부터 1000까지 최대 범위, N에 따라 구하도록.
	{
		int temp = i; // 입력한 수를 계산을 위해 임시변수 temp에 저장
		int num_1000 = temp / 1000;
		temp %= 1000;
		int num_100 = temp / 100; // 100의 자리
		temp %= 100; // 남은 두 자리 수
		int num_10 = temp / 10; // 10의 자리
		temp %= 10; // 남은 한 자리 수
		int num_1 = temp / 1; // 1의 자리
		if (i <= 99) count++; // 두 자리수면 무조건 한수이므로 count 늘려주기 
		else if ((num_100 - num_10) == (num_10 - num_1)) count++; // 세 자리수면 각 자리 숫자의 차이가 같아야 한수
		if (i == 1000) count--; // i가 1000이면 num_100 = num_10 = num_1이므로 count가 늘어나니 예외처리
	}
	printf("%d", count); // 한수 개수 출력
	return 0;
}