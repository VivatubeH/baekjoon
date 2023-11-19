#include <stdio.h>

int main() {
    char chess[8][8];
    int i,j;
    
    for(i=0;i<8;i++)
        {
            for(j=0;j<8;j++)
                {
                    scanf(" %c", &chess[i][j]);  
                }
        }
        
    int count = 0;
    
    for (i=0;i<8;i++)
        {
            for (j=0;j<8;j++)
                {
                    if(((i+j)%2==0) && (chess[i][j] == 'F'))
                    {
                        count++;
                    }
                }
        }
    printf("%d",count);
    return 0;
}