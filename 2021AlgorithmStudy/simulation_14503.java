import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class simulation_14503 {
    static int n, m, x, y, w, dir, place[][];
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        place = new int[n][m];

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                place[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = Solve(x,y,dir);

        System.out.println(result);
        
    }

    private static int Solve(int i, int j, int d) {
        int dirCnt = 0, cnt = 0, nx, ny;
        boolean flag = true;

        while(flag){
            if(place[i][j] == 0){
                place[i][j] = 2;
                cnt++;
            }

            while(true){
                if(dirCnt==4){ //4방향이 모두 청소완료 혹은 벽
                    nx = i - dx[d];
                    ny = j - dy[d]; //뒤로

                    if(place[nx][ny] == 1){
                        //뒤에도 벽이라 후진불가
                        flag = false;
                        break;
                        //종료
                    }
                    else{
                        i = nx;
                        j = ny;
                        dirCnt = 0;
                    }
                }
                d = (d+3) %4; //왼쪽방향
                nx = i + dx[d];
                ny = j + dy[d];

                if(place[nx][ny] == 0){
                    dirCnt = 0;
                    i = nx;
                    j = ny;
                    break;
                }
                else
                    dirCnt++;
            }
        }
        return cnt;
    }
}
