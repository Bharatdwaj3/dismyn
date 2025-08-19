#include <iostream>
#include <vector>

int main()
{
    int n;
    std::cout << "Enter the value of n: ";
    std::cin >> n;

    if (n < 0)
    {
        std::cout << "Invalid input! n must be non-negative." << std::endl;
        return 1;
    }

    std::vector<int> dp(n + 1, 0);

    dp[0] = 1;
    if (n >= 1)
        dp[1] = 1;

    for (int i = 2; i <= n; i++)
    {
        dp[i] = dp[i - 1] + dp[i - 2];
    }

    std::cout << "Fibonacci(" << n << ") = " << dp[n] << std::endl;

    return 0;
}
