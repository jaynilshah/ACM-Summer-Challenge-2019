#include<stdio.h>


int main()
{
    char str[100001];
    scanf("%s", str);
    printf("%s", str);
    while(scanf("%s", str) != EOF) {
        printf("\\%s", str);
    }
    return 0;
}