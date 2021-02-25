#include <iostream>

#define MAX 31
using namespace std;

int WALL[MAX];

int main()
{
    int n;

    cin >> n;

    if (n % 2 == 1)
    {
        cout << 0 << "\n";
    }

    else
    {
        WALL[0] = 1;
        WALL[2] = 3;

        for (int i = 4; i <= n; i += 2)
        {
            //3x2 의 갯수가 3개이므로 B
            WALL[i] = 3 * WALL[i - 2];
            //이후 부터는 겹치기 때문에 특별한 경우인 2개씩
            for (int j = 4; j <= i; j += 2)
            {
                WALL[i] += (2 * WALL[i - j]);
            }
        }

        cout << WALL[n] << "\n";
    }
}