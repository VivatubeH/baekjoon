#include<stdio.h>
#include<string.h>

int main(void)
{
    char str[51];
    scanf("%s", str);
    strcat(str,"??!");
    printf("%s", str);
    return 0;
}