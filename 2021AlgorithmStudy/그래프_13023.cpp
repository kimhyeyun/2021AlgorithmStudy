#include <iostream>
#include <vector>

#define MAX 2001
using namespace std;

vector<int> R[MAX];
bool visited[MAX];
bool ans = false;

void DFS(int idx, int cnt)
{
    if (cnt == 5)
    {
        ans = true;
        return;
    }

    else
    {
        visited[idx] = true;

        for (int i = 0; i < R[idx].size(); i++)
        {
            int next = R[idx][i];
            if (visited[next])
                continue;
            DFS(next, cnt + 1);

            if (ans)
                return;
        }

        visited[idx] = false;
    }
}

int main()
{
    int n, m;

    cin >> n >> m;

    for (int i = 0; i < m; i++)
    {
        int x, y;
        cin >> x >> y;
        R[x].push_back(y);
        R[y].push_back(x);
    }

    for (int i = 0; i < n; i++)
    {
        DFS(i, 1);
        if (ans)
            break;
    }

    if (ans)
        cout << 1 << "\n";
    else
        cout << 0 << "\n";
}