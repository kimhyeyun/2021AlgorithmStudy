#include <iostream>

#define MAX 1001
using namespace std;

int NUM[MAX], DP[MAX];

int main()
{
    int n;
    cin >> n;

    for (int i = 0; i < n; i++)
    {
        cin >> NUM[i];
    }

    int m = 0;

    for (int i = 0; i < n; i++)
    {
        DP[i] = 1;
        for (int j = 0; j < i; j++)
        {
            if (NUM[i] < NUM[j] && DP[i] <= DP[j] + 1)
                DP[i] = DP[j] + 1;
        }
    }

    for (int i = 0; i < n; i++)
    {
        m = max(m, DP[i]);
    }

    cout << m << "\n";
}