#include<stdio.h>

int main(void)
{
	char str[101];
	char* ps = str;

	scanf("%s", str);
	
	while (*ps != '\0') // WrongAnswer
	{
		if ((*ps >= 'a') && (*ps <= 'z')) // 소문자면
		{
			*ps = *ps - ('a' - 'A'); // 대문자로 바꾸기, 코드값 32를 빼주기.
		}
		else if ((*ps >= 'A') && (*ps <= 'Z')) // 대문자면
		{
			*ps = *ps + ('a' - 'A'); // 소문자로 바구기, 코드값 32 더해주기
		}

		ps++; // 다음 문자로 간다.
	}
	printf("%s", str);
	return 0;
}