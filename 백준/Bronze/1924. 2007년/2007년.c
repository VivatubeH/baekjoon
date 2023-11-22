#include <stdio.h>

int main(void)
{
	int day[13] = { 0,31,28,31,30,31,30,31,31,30,31,30,31 };
	int total_day = 0;
	int rest = 0;
	int x, y, i;
	scanf("%d%d", &x, &y);
	for (i = 1; i < x; i++)
	{
		total_day += day[i];
	}
	total_day += y;
	rest = total_day % 7;
	// 나머지가 1일때 MON이므로
	switch (rest)
	{
	case 0: printf("SUN"); break;
	case 1: printf("MON"); break;
	case 2: printf("TUE"); break;
	case 3: printf("WED"); break;
	case 4: printf("THU"); break;
	case 5: printf("FRI"); break;
	case 6: printf("SAT"); break;
	}
	return 0;
}