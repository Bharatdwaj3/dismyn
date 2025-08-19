#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

int absDiff(int a, int b)
{
    return a > b ? a - b : b - a;
}

int min(int a, int b)
{
    return a < b ? a : b;
}

// Function to solve the minimum energy with up to k jumps
int solveUtil(int n, int *height, int *dp, int k)
{
    dp[0] = 0;

    for (int i = 1; i < n; i++)
    {
        int mmSteps = INT_MAX;

        for (int j = 1; j <= k; j++)
        {
            if (i - j >= 0)
            {
                int jump = dp[i - j] + absDiff(height[i], height[i - j]);
                mmSteps = min(mmSteps, jump);
            }
        }
        dp[i] = mmSteps;
    }

    return dp[n - 1];
}

int solve(int n, int *height, int k)
{
    int *dp = (int *)malloc(n * sizeof(int));
    int result = solveUtil(n, height, dp, k);
    free(dp);
    return result;
}

int main()
{
    int n, k;
    printf("Enter the number of stones: ");
    scanf("%d", &n);

    int *height = (int *)malloc(n * sizeof(int));

    printf("Enter the heights of the stones:\n");
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &height[i]);
    }

    printf("Enter the maximum number of jumps (k): ");
    scanf("%d", &k);

    int minCost = solve(n, height, k);
    printf("Minimum energy required: %d\n", minCost);

    free(height);
    return 0;
}
