#include <stdio.h>
#include <stdlib.h>

int max(int a, int b)
{
    return a > b ? a : b;
}

// Solve the problem using dynamic programming with space optimization
int solve(int n, int *arr)
{
    if (n == 0)
        return 0;
    if (n == 1)
        return arr[0];

    int prev = arr[0];
    int prev2 = 0;

    for (int i = 1; i < n; i++)
    {
        int pick = arr[i];
        if (i > 1)
            pick += prev2;

        int nonPick = prev;

        int cur_i = max(pick, nonPick);
        prev2 = prev;
        prev = cur_i;
    }

    return prev;
}

int main()
{
    int n;
    printf("Enter the number of elements in the array: ");
    scanf("%d", &n);

    if (n <= 0)
    {
        printf("Array must have at least one element.\n");
        return 1;
    }

    int *arr = (int *)malloc(n * sizeof(int));
    printf("Enter the elements of the array:\n");

    for (int i = 0; i < n; i++)
    {
        scanf("%d", &arr[i]);
    }

    int result = solve(n, arr);
    printf("Maximum non-adjacent sum: %d\n", result);

    free(arr);
    return 0;
}
