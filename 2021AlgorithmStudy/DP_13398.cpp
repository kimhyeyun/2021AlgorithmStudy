#include <iostream>

#define MAX 100001
using namespace std;

int NUM[MAX], DP[MAX][2];
//DP[][0] : 수열 중 하나를 삭제하지 않는 경우
//DP[][1] : 수열 중 하나를 삭제하는 경우 

int main()
{
    int n, ans;

    cin >> n;

    for (int i = 0; i < n; i++)
        cin >> NUM[i];

    DP[0][0] = NUM[0];
    DP[0][1] = NUM[0]; 

    ans = max(DP[0][0],DP[0][1]);

    for(int i=1;i<n;i++){
        //계속 더해가는 경우인데, 앞의 값이 -라면 최대가 될 수 없으므로 0부터
        DP[i][0] = max(0, DP[i-1][0])+NUM[i];
        //i값을 더했을때와 제외할 경우를 비교해서 빼는 경우
        DP[i][1] = max(DP[i-1][1]+NUM[i],DP[i-1][0]);

        ans = max(max(DP[i][0],DP[i][1]),ans);
    }

    cout<<ans<<"\n";
    
}