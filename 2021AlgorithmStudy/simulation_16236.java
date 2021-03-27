import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class simulation_16236 {
    static int n,space[][],dist[][];
    static int sharksz = 2;
    static int eating=0, cnt=0;
    static int sharkx,sharky,minx,miny,mindist;
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        space = new int[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                space[i][j] = Integer.parseInt(st.nextToken());
                if(space[i][j] == 9) {
                    sharkx = i;
                    sharky = j ;
                    space[i][j] = 0;
                }
            }
        }

        while(true){
            dist = new int[n][n];
            minx = Integer.MAX_VALUE;
            miny = Integer.MAX_VALUE;
            mindist = Integer.MAX_VALUE;

            BFS(sharkx,sharky);

            if(minx != Integer.MAX_VALUE && miny!= Integer.MAX_VALUE){
                eating++;
                space[minx][miny] = 0;
                sharkx = minx;
                sharky = miny;
                cnt+=dist[minx][miny];

                if(eating == sharksz){
                    sharksz++;
                    eating=0;
                }
            }
            else
                break;
        }
        System.out.println(cnt);
    }
    private static void BFS(int sx, int sy) {
        Queue<Point> q= new LinkedList<>();
        q.add(new Point(sx,sy));

        while(!q.isEmpty()){
            Point p = q.poll();

            for(int i=0;i<4;i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];

                if(isArea(nx,ny) && isMove(nx,ny) && dist[nx][ny] == 0){
                    dist[nx][ny] = dist[p.x][p.y]+1;

                    if(isEat(nx,ny)){
                        if(mindist > dist[nx][ny]){
                            mindist = dist[nx][ny];
                            minx = nx;
                            miny = ny;
                        }
                        else if(mindist == dist[nx][ny]){
                            if(minx == nx){
                                if(miny > ny){
                                    minx = nx;
                                    miny = ny;
                                }
                            }
                            else if(minx > nx){
                                minx = nx;
                                miny = ny;
                            }
                        }
                    }
                    q.add(new Point(nx,ny));
                 }
            }

        }
    }

    private static boolean isEat(int nx, int ny) {
        return space[nx][ny]!= 0 && space[nx][ny] < sharksz;
    }
    private static boolean isArea(int nx, int ny) {
        if(0 <= nx && nx < n && 0 <= ny && ny < n)
            return true;
        return false;
    }
    private static boolean isMove(int nx, int ny) {
        return space[nx][ny] <= sharksz;
    }

    private static class Point{
        private int x, y;

        private Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}