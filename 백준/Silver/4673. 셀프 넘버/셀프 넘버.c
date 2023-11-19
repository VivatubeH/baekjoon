#include <stdio.h>

int main(void) {
    // 입력은 없고, 10000보다 작은 셀프 넘버 출력하기.
     int selfnumber_check[10001];
     int d_n;
     int i;
     for ( i = 1; i<=10000; i++)
     {
         selfnumber_check[i] = i; // 셀프 넘버 판별을 위해 해당 숫자로 초기화. 
     }
     for ( i = 1; i<=10000; i++)
     {
         int temp = i; 
         int num_10000 = temp/10000; 
         temp %= 10000; 
         int num_1000 = temp/1000;  
         temp %= 1000; 
         int num_100 = temp/100; 
         temp %= 100; 
         int num_10 = temp/10; 
         temp %= 10; 
         int num_1 = temp/1; 
         d_n = i + num_10000+ num_1000 + num_100 + num_10 + num_1;
         if (d_n <= 10000) selfnumber_check[d_n] = 0; // 생성자가 있다 = 셀프넘버가 아니다
         // 셀프 넘버가 아니면 그 배열 값은 0으로 만들어주자.
     }
     for( i=1; i<=10000;i++)
     {
         if ( selfnumber_check[i] != 0 ) // 셀프넘버인 수를 출력하자.
         {
            printf("%d\n", i);
         }
     }
     return 0;
}