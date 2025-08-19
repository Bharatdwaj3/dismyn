#include <stdio.h>
#include <stdlib.h>

int max(int a, int b)
{
    return a > b ? a : b;
}

// Stack structure
typedef struct
{
    int *data;
    int top;
} Stack;

void initStack(Stack *s, int size)
{
    s->data = (int *)malloc(size * sizeof(int));
    s->top = -1;
}

void push(Stack *s, int value)
{
    s->data[++(s->top)] = value;
}

int pop(Stack *s)
{
    return s->data[(s->top)--];
}

int peek(Stack *s)
{
    return s->data[s->top];
}

int isEmpty(Stack *s)
{
    return s->top == -1;
}

void freeStack(Stack *s)
{
    free(s->data);
}

int largestRectangleArea(int *histo, int n)
{
    Stack st;
    initStack(&st, n + 1);
    int maxA = 0;

    for (int i = 0; i <= n; i++)
    {
        while (!isEmpty(&st) && (i == n || histo[peek(&st)] >= histo[i]))
        {
            int height = histo[pop(&st)];
            int width;
            if (isEmpty(&st))
            {
                width = i;
            }
            else
            {
                width = i - peek(&st) - 1;
            }
            maxA = max(maxA, width * height);
        }
        push(&st, i);
    }

    freeStack(&st);
    return maxA;
}

int maximalAreaOfSubMatrixOfAll1(int **mat, int n, int m)
{
    int *height = (int *)calloc(m, sizeof(int));
    int maxArea = 0;

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            if (mat[i][j] == 1)
                height[j]++;
            else
                height[j] = 0;
        }
        int area = largestRectangleArea(height, m);
        maxArea = max(maxArea, area);
    }

    free(height);
    return maxArea;
}

int main()
{
    int n, m;
    printf("Enter the number of rows and columns: ");
    scanf("%d %d", &n, &m);

    int **mat = (int **)malloc(n * sizeof(int *));
    for (int i = 0; i < n; i++)
    {
        mat[i] = (int *)malloc(m * sizeof(int));
    }

    printf("Enter the matrix elements (0 or 1):\n");
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            scanf("%d", &mat[i][j]);
        }
    }

    int maxArea = maximalAreaOfSubMatrixOfAll1(mat, n, m);
    printf("The maximum area is: %d\n", maxArea);

    for (int i = 0; i < n; i++)
    {
        free(mat[i]);
    }
    free(mat);

    return 0;
}
