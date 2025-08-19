#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

// Function to check if characters match
bool isMatching(char open, char close)
{
    return (open == '(' && close == ')') ||
           (open == '{' && close == '}') ||
           (open == '[' && close == ']');
}

// Function to check if the parentheses string is valid
bool isValidParentheses(char *s)
{
    int len = strlen(s);

    // Stack for storing opening brackets
    char *stack = (char *)malloc(len * sizeof(char));
    int top = -1;

    for (int i = 0; i < len; i++)
    {
        char ch = s[i];

        // If opening bracket, push to stack
        if (ch == '(' || ch == '{' || ch == '[')
        {
            stack[++top] = ch;
        }
        // If closing bracket
        else if (ch == ')' || ch == '}' || ch == ']')
        {
            if (top == -1 || !isMatching(stack[top], ch))
            {
                free(stack);
                return false;
            }
            top--; // matched, so pop
        }
    }

    bool isValid = (top == -1); // if stack is empty, it's valid
    free(stack);
    return isValid;
}

int main()
{
    char input[1000];

    printf("Enter a string of parentheses: ");
    scanf("%s", input);

    if (isValidParentheses(input))
    {
        printf("The parentheses string is VALID.\n");
    }
    else
    {
        printf("The parentheses string is INVALID.\n");
    }

    return 0;
}
