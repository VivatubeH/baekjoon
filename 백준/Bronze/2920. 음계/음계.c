#include <stdio.h>

int main()
{
	int N[8];
	int i;
	int check = 0;
	for (i = 0; i < 8; i++)
	{
		scanf("%d", &N[i]);
	}
	for (i = 0; i < 7; i++)
	{
		if ((N[i + 1] - N[i] == 1) && (N[0] == 1))
		{
			check++;
		}
		if ((N[i + 1] - N[i] == -1) && (N[0] = 8))
		{
			check--;
		}
	}
	if (check == 7) printf("ascending");
	else if (check == -7) printf("descending");
	else printf("mixed");
	return 0;
}