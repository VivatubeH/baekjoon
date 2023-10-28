#include<stdio.h>

int main(void)
{
	int a = 0, N = 0, i = 0, j = 2, count = 0, b = 0;
	scanf("%d", &N);
	for (i = 0; i < N; i++) // N번 입력을 받는다.
	{
		scanf("%d", &a); //숫자를 입력을 받고 배열을 쓸 지, 바로 구할 지 
		b = 0; // b 값의 초기화는 블록 내에도 있어야 한다.

		if (a == 1)
		{
			continue; // 1일 경우에는 아무것도 하면 안됨. 단 반복문을 빠져나가면 입력을 못 받음.
		}	          // continue로 반복문의 조건 검사식으로

		if (a == 2)
		{
			count++; // 2는 소수니까 count를 늘려주고
			continue; // continue를 써야 마지막 if문 조건 검사를 안함
		}

		for (j = 2; j < a; j++)
		{
			if (a % j == 0) // 하나라도 나누어 떨어지면
			{
				b = 1;  // b를 1로 바꾼다.
			}
		}

		if (b != 1) // b가 1로 변한 상태에서 조건 검사
		{
			count++; // 개수를 안 늘린다. ( 소수가 아니다 )
		}
		
	}
	printf("%d", count);
	return 0;
}