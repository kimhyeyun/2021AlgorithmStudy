#include <iostream>
#include <vector>
#include <queue>

#define MAX 20001
using namespace std;

vector<int> graph[MAX];
int visited[MAX];

int v, e;
bool flag = false;

void BFS(int start)
{
    queue<int> q;
    q.push(start);
    visited[start] = 1;

    while (!q.empty())
    {
        int x = q.front();
        q.pop();

        for (int i = 0; i < graph[x].size(); i++)
        {
            int tmp = graph[x][i];

            if (visited[tmp] == 0)
            {
                q.push(tmp);
                if (visited[x] == 1)
                    visited[tmp] = 2;
                else
                    visited[tmp] = 1;
            }
        }
    }
}

void Search()
{
    for (int i = 1; i <= v; i++)
    {
        for (int j = 0; j < graph[i].size(); j++)
        {
            int next = graph[i][j];
            if (visited[i] == visited[next])
            {
                flag = true;
                return;
            }
        }
    }
}

int main()
{
    int t;
    cin >> t;

    while (t--)
    {
        flag = false;

        cin >> v >> e;

        for (int i = 0; i <= v; i++)
        {
            graph[i].clear();
            visited[i] = 0;
        }

        for (int i = 0; i < e; i++)
        {
            int x, y;
            cin >> x >> y;
            graph[x].push_back(y);
            graph[y].push_back(x);
        }

        for (int i = 1; i <= v; i++)
        {
            if (visited[i] == 0)
                BFS(i);
        }

        Search();
        if (flag)
            cout << "NO"
                 << "\n";
        else
            cout << "YES"
                 << "\n";
    }
}