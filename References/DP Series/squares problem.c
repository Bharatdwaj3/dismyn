#include <stdio.h>
#include <stdlib.h>

int min(int a, int b)
{
    return a < b ? a : b;
}

int countSquares(int n, int m, int **arr)
{
    int **dp = (int **)malloc(n * sizeof(int *));
    for (int i = 0; i < n; i++)
    {
        dp[i] = (int *)calloc(m, sizeof(int));
    }

    // Initialize first row and column
    for (int j = 0; j < m; j++)
        dp[0][j] = arr[0][j];
    for (int i = 0; i < n; i++)
        dp[i][0] = arr[i][0];

    // Fill the DP table
    for (int i = 1; i < n; i++)
    {
        for (int j = 1; j < m; j++)
        {
            if (arr[i][j] == 0)
                dp[i][j] = 0;
            else
            {
                int min_val = min(dp[i - 1][j], min(dp[i - 1][j - 1], dp[i][j - 1]));
                dp[i][j] = 1 + min_val;
            }
        }
    }

    // Sum all values in dp[][]
    int sum = 0;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            sum += dp[i][j];
        }
    }

    // Free allocated memory
    for (int i = 0; i < n; i++)
    {
        free(dp[i]);
    }
    free(dp);

    return sum;
}

int main()
{
    int n, m;
    printf("Enter the number of rows and columns: ");
    scanf("%d %d", &n, &m);

    // Allocate memory for input matrix
    int **arr = (int **)malloc(n * sizeof(int *));
    for (int i = 0; i < n; i++)
    {
        arr[i] = (int *)malloc(m * sizeof(int));
    }

    // Input matrix elements
    printf("Enter the matrix elements (0 or 1):\n");
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            scanf("%d", &arr[i][j]);
        }
    }

    // Compute and print result
    int squares = countSquares(n, m, arr);
    printf("The number of squares: %d\n", squares);

    // Free input matrix
    for (int i = 0; i < n; i++)
    {
        free(arr[i]);
    }
    free(arr);

    return 0;
}
