#include <iostream>

#define MAX 1001
using namespace std;

int NUMS[MAX], DPL[MAX], DPR[MAX];

int main()
{
    int n;
    cin >> n;

    for (int i = 0; i < n; i++)
        cin >> NUMS[i];


    for (int i = 0; i < n; i++)
    {
        DPL[i] = 1;
        for (int j = 0; j < i; j++)
        {
            if (NUMS[j] < NUMS[i] && DPL[i] <= DPL[j])
                DPL[i] = DPL[j] + 1;
        }
    }

    for (int i = n - 1; i >= 0; i--)
    {
        DPR[i] = 1;
        for (int j = n - 1; j > i; j--)
        {
            if (NUMS[i] > NUMS[j] && DPR[i] <= DPR[j])
                DPR[i] = DPR[j] + 1;
        }
    }

    int ans = 0;
    for (int i = 0; i < n; i++)
        ans = max(ans, DPL[i] + DPR[i]);

    cout << ans-1 << "\n";
}