import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class simulation_14503 {
    static int n, m, x, y, w, dir, place[][];
    static boolean clean[][];
    static int[] dx = { 0, -1, 0, 1 };
    static int[] dy = { -1, 0, 1, 0 };
    static int[] backx = {1,0,-1,0};
    static int[] backy = {0,-1,0,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        place = new int[n][m];
        clean = new boolean[n][m];

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

        int cnt = 1;
        clean[x][y] = true;

        while (true) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if(w == 4 && place[x+backx[dir]][y+backy[dir]] == 1)
                break;

            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                if (place[nx][ny] == 0) {
                    if (clean[nx][ny]) {
                        RotateLeft();
                    } else {
                        x = nx;
                        y = ny;
                        clean[nx][ny] = true;
                        cnt++;
                        w = 0;
                    }
                }
                else{
                    RotateLeft();
                    
                    if(w == 4 && place[x+backx[dir]][y+backy[dir]]==0){
                        x = x + backx[dir];
                        y = y + backy[dir];
                        w = 0;
                    }
                }
            }
            else{
                RotateLeft();
            }
        }
        System.out.println(cnt);
    }

    private static void RotateLeft() {
        // 왼쪽으로 회전
        if (dir == 0)
            dir = 3;
        else
            dir = dir - 1;

        w++;
    }
}


//ing