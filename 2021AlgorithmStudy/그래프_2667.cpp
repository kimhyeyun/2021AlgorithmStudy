#include<iostream>
#include<stdio.h>
#include<vector>
#include<algorithm>

#define MAX 26
using namespace std;

int apartment[MAX][MAX];
bool visited[MAX][MAX];
int n, cnt;
vector<int> ans;
int dx[] = {1,0,-1,0};
int dy[] = {0,1,0,-1};

void DFS(int x, int y){

    for(int i=0;i<4;i++){
        int nx = x+dx[i];
        int ny = y+dy[i];

        if(nx>=0 && nx<n && ny>=0 && ny<n){
            if(apartment[nx][ny] == 1 &&!visited[nx][ny]){
                cnt++;
                visited[nx][ny] = true;
                DFS(nx,ny);
            }
        }
    }
    return;
}

int main(){
    cin>>n;

    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++)
            scanf("%1d", &apartment[i][j]);
    }

    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(apartment[i][j] == 1 && !visited[i][j]){
                cnt = 1;
                visited[i][j] = true;
                DFS(i,j);
                ans.push_back(cnt);
            }
        }
    }

    sort(ans.begin(),ans.end());
    
    cout<<ans.size()<<"\n";
    for(int i=0;i<ans.size();i++)
        cout<<ans[i]<<"\n";
}

