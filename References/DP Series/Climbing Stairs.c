#include <stdio.h>
#include <stdlib.h>

int main()
{
    int n;
    printf("Enter the value of n: ");
    scanf("%d", &n);

    if (n < 0)
    {
        printf("Invalid input! n must be non-negative.\n");
        return 1;
    }

    int *dp = (int *)malloc((n + 1) * sizeof(int));

    dp[0] = 1;
    if (n >= 1)
        dp[1] = 1;

    for (int i = 2; i <= n; i++)
    {
        dp[i] = dp[i - 1] + dp[i - 2];
    }

    printf("Fibonacci(%d) = %d\n", n, dp[n]);

    free(dp);
    return 0;
}
