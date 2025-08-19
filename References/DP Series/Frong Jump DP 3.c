#include <stdio.h>
#include <stdlib.h>

int absDiff(int a, int b)
{
    return a > b ? a - b : b - a;
}

int min(int a, int b)
{
    return a < b ? a : b;
}

int main()
{
    int n;
    printf("Enter the number of stones: ");
    scanf("%d", &n);

    if (n <= 0)
    {
        printf("Invalid input! Number of stones must be positive.\n");
        return 1;
    }

    int *height = (int *)malloc(n * sizeof(int));
    int *dp = (int *)malloc(n * sizeof(int));

    printf("Enter the heights of the stones:\n");
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &height[i]);
    }

    dp[0] = 0;

    for (int i = 1; i < n; i++)
    {
        int jumpOne = dp[i - 1] + absDiff(height[i], height[i - 1]);
        int jumpTwo = i > 1 ? dp[i - 2] + absDiff(height[i], height[i - 2]) : __INT_MAX__;
        dp[i] = min(jumpOne, jumpTwo);
    }

    printf("Minimum energy required: %d\n", dp[n - 1]);

    free(height);
    free(dp);

    return 0;
}
