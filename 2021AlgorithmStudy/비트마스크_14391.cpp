#include<iostream>
#include<string>
#include<vector>

#define MAX 4
using namespace std;

int N, M, ans;
int MAP[MAX][MAX];
int Select[16];
bool visited[MAX][MAX];
vector<int> v;

//못하겠다 ... 어렵다....
void Make_Visit(int x,int y, int size,char c, bool flag) {
    if (c == 'G') {
        for (int i = y; i < y + size; i++)
            visited[x][i] = flag;
    }
    else {
        for (int i = x; i < x + size; i++)
            visited[y][i] = flag;
    }
}

int Find_Max_Size(int x, int y, char c) {
    int cnt = 0;
    if (c == 'G') { //가로
        for (int i = y; i < M; i++) {
            if (!visited[x][i])
                cnt++;
            else
                break;
        }
    }
    else {
        for(int i=x;i<N;i++){
            if (!visited[i][y])
                cnt++;
            else
                break;
        }
    }
    return cnt;
}

pair<int, int> Find_Point() {
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++)
            if (!visited[i][j])
                return { i,j };
    }
    return { -1,-1 };
}

void DFS(int sum) {
    if (N == 1 && M == 1) {
        cout << MAP[0][0] << "\n";
        return;
    }

    pair<int, int> p = Find_Point();
    int x = p.first;
    int y = p.second;

    if (x == -1 && y == -1) {
        if (ans < sum)
            ans = sum;
        return;
    }

    int sz = Find_Max_Size(x, y, 'G');

    for (int i = sz; i > 0; i--) {
        Make_Visit(x, y, sz, 'G', true);
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> M;

    for (int i = 0; i < N; i++) {
        string str;
        cin >> str;
        for (int j = 0; j < str.length(); j++)
            MAP[i][j] = str[j] - '0';
    }


}