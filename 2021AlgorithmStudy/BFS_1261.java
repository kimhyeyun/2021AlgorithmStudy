import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

class Pair{
    int x,y;
    Pair(int x, int y){
        this.x=x;
        this.y=y;
    }
}

public class BFS_1261 {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String size= br.readLine();
		
		StringTokenizer stringTokenizer=new StringTokenizer(size);

        int m = Integer.parseInt(stringTokenizer.nextToken());
        int n = Integer.parseInt(stringTokenizer.nextToken());

        int[][] maze = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        int[][] wall = new int[n][m];

        int dx[] = {-1,0,0,1};
        int dy[] = {0,-1,1,0};

        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<m;j++){
                maze[i][j] = str.charAt(j)-'0';
            }
        }

        Deque<Pair> q = new LinkedList<>();
        q.addLast(new Pair(0,0));
        visited[0][0] = true;
        wall[0][0] = 0;

        while(!q.isEmpty()){
            Pair tmp = q.pollLast();
            //벽없는 부분부터 뺄 예정

            for(int i=0;i<4;i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if(nx<0 || nx>=n || ny <0 || m<=ny || visited[nx][ny])
                    continue;

                if(maze[nx][ny] == 0){
                    wall[nx][ny] = wall[tmp.x][tmp.y];
                    q.addLast(new Pair(nx,ny));
                }

                if(maze[nx][ny] == 1){
                    wall[nx][ny] = wall[tmp.x][tmp.y]+1;
                    //벽이있는 길로는 나중에 지나가자!
                    q.addFirst(new Pair(nx,ny));
                }
                visited[nx][ny] = true;
            }

        }

        System.out.println(wall[n-1][m-1]);

    }

   
}
