#include <iostream>

#define MAX 1001
using namespace std;

int n, m;
int graph[MAX][MAX];
bool visited[MAX];

void DFS(int idx)
{
    visited[idx] = true;

    for (int i = 1; i <= n; i++)
    {
        if (!visited[i] && graph[idx][i] == 1)
            DFS(i);
    }
    return;
}

int main()
{
    cin >> n >> m;

    for (int i = 0; i < m; i++)
    {
        int x, y;
        cin >> x >> y;
        graph[x][y] = 1;
        graph[y][x] = 1;
    }

    int ans = 0;

    for (int i = 1; i <= n; i++)
    {
        if (!visited[i])
        {
            DFS(i);
            ans++;
        }
    }

    cout << ans << "\n";
}