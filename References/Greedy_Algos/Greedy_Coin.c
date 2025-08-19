#include <stdio.h>
#include <stdlib.h>

int main()
{
    int coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
    int n = sizeof(coins) / sizeof(coins[0]);

    int V;
    printf("Enter the amount: ");
    scanf("%d", &V);

    // Array to store chosen coins (worst case, V coins of 1)
    int *ans = (int *)malloc(V * sizeof(int));
    int count = 0;

    for (int i = n - 1; i >= 0; i--)
    {
        while (V >= coins[i])
        {
            V -= coins[i];
            ans[count++] = coins[i];
        }
    }

    printf("The minimum number of coins is: %d\n", count);
    printf("The coins are:\n");
    for (int i = 0; i < count; i++)
    {
        printf("%d ", ans[i]);
    }
    printf("\n");

    free(ans);
    return 0;
}
