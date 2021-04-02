#include <iostream>
#include <vector>

using namespace std;

#define endl '\n'

// Set up : Global Variables
int N, M;
char board[100][100];
bool isChecked[100][100];
struct Cross { int x, y, s; };
int dx[4] = {+1, 0, 0, -1};
int dy[4] = {0, +1, -1, 0};
#define INF 987654321

// Set up : Functions Declaration
bool isValid(int x, int y);
int getMaxS(int x, int y);
void putCross(int x, int y, int s);


int main()
{
    // Set up : I/O
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    // Set up : Input
    cin >> N >> M;
    for (int i=0; i<N; i++) {
        for (int j=0; j<M; j++) {
            cin >> board[i][j];
        }
    }

    // Process
    int k = 0; /* 십자가의 개수 */
    vector<Cross> crosses; /* 십자가이 정보가 담긴 Vector */
    for (int x=1; x<N-1; x++) { /* 문제에서는 시작칸이 (1,1)
                                 * 코드에서는 시작칸이 (0,0) */
        for (int y=1; y<M-1; y++) { /* (0~(N-1), 0) 과 (0, 0~(M-1) 은 십자가를 놓을 수 없음
                                     * 그래서 (1~(N-2), 1~(M-2)) 칸만 탐색 */
            if (board[x][y] == '*') { /* 현재칸이 별표면 */
                int s = getMaxS(x, y); /* 이 칸을 중심으로 십자가를 놓을 때 최대 크기를 구함 */
                if (s >= 1) { /* 최대 크기가 1 이상이면 */
                    putCross(x, y, s); /* 십자가를 놓음 */
                    k++; /* 십자가 개수 갱신 */
                    crosses.push_back({x+1, y+1, s}); /* 십자가 정보 저장 */
                }
            }
        }
    }

    // Control : Output
    bool isPossible = true; /* 주어진 모양을 만들 수 있는지 여부 */
    for (int x=0; x<N; x++) {
        if (not(isPossible)) break;
        for (int y=0; y<M; y++) {
            /* 별표인 칸인데 체크안된 칸이 있으면 */
            if (board[x][y] == '*' && not(isChecked[x][y])) {
                isPossible = false; /* 모양 만들기 불가능 */
                break;
            }
        }
    }

    if (not(isPossible))
        cout << -1 << endl;
    else {
        cout << k << endl;
        for (Cross c : crosses) {
            cout << c.x << ' ' << c.y << ' ' << c.s << endl;
        }
    }
}

// Helper Functions
bool isValid(int x, int y)
/* 주어진 좌표가 유효하면 true 를 반환, 그 외 false 를 반환 */
{
    return x >= 0 && x < N && y >= 0 && y < M;
}

int getMaxS(int x, int y)
/* 주어진 좌표에서 놓을 수 있는 십자가의 최대 크기를 구함 */
{
    int maxS = INF;
    for (int i=0; i<4; i++) { /* 아래쪽, 오른쪽, 왼쪽, 위쪽 차례로 검사
                               * 각 방향으로 놓아진 별표의 개수의 최솟값이 십자가의 최대 크기 */
        int s = 0; /* (x,y) 에서 (dx[i], dy[i]) 방향으로 놓아진 별표의 개수 */
        int ax = x + dx[i];
        int ay = y + dy[i];
        while (isValid(ax, ay) && board[ax][ay] == '*') {
            s++;
            ax += dx[i];
            ay += dy[i];
        }
        maxS = min(maxS, s); /* 십자가의 최대 크기 갱신 */
    }
    return maxS;
}

void putCross(int x, int y, int s)
/* (x,y) 에 크기 s 인 십자가를 놓음 */
{
    isChecked[x][y] = true;
    for (int i=1; i<=s; i++) {
        isChecked[x+i][y] = true;
        isChecked[x-i][y] = true;
        isChecked[x][y+i] = true;
        isChecked[x][y-i] = true;
    }
}