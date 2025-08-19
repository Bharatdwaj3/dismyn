#include <stdio.h>
#include <stdlib.h>

// Structure to represent an item
struct Item
{
    int value;
    int weight;
};

// Comparison function for sorting items by value/weight ratio
int compare(const void *a, const void *b)
{
    struct Item *item1 = (struct Item *)a;
    struct Item *item2 = (struct Item *)b;

    double r1 = (double)item1->value / item1->weight;
    double r2 = (double)item2->value / item2->weight;

    if (r1 < r2)
        return 1;
    else if (r1 > r2)
        return -1;
    else
        return 0;
}

// Function to calculate the maximum value with fractional knapsack
double fractionalKnapsack(int capacity, struct Item arr[], int n)
{
    qsort(arr, n, sizeof(struct Item), compare);

    int currentWeight = 0;
    double finalValue = 0.0;

    for (int i = 0; i < n; i++)
    {
        if (currentWeight + arr[i].weight <= capacity)
        {
            currentWeight += arr[i].weight;
            finalValue += arr[i].value;
        }
        else
        {
            int remain = capacity - currentWeight;
            finalValue += ((double)arr[i].value / arr[i].weight) * remain;
            break;
        }
    }

    return finalValue;
}

int main()
{
    int n, capacity;

    // User input: number of items and knapsack capacity
    printf("Enter number of items: ");
    scanf("%d", &n);

    printf("Enter knapsack capacity: ");
    scanf("%d", &capacity);

    struct Item *arr = (struct Item *)malloc(n * sizeof(struct Item));

    // Input item values and weights
    printf("Enter value and weight for each item:\n");
    for (int i = 0; i < n; i++)
    {
        printf("Item %d - Value: ", i + 1);
        scanf("%d", &arr[i].value);
        printf("Item %d - Weight: ", i + 1);
        scanf("%d", &arr[i].weight);
    }

    // Calculate result
    double maxValue = fractionalKnapsack(capacity, arr, n);

    printf("The maximum value is: %.2lf\n", maxValue);

    free(arr);
    return 0;
}
