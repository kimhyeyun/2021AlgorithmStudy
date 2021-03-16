import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class simulation_14499_re {
    static int map[][], n, m, garo[], sero[], x, y, k;
    static int dx[] = { 0, 0, 0, -1, 1 };
    static int dy[] = { 0, 1, -1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 동서로 움직일때 변함
        garo = new int[4];
        Arrays.fill(garo, 0);
        // 남북으로 움직일때 변함
        sero = new int[4];
        Arrays.fill(sero, 0);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int dir = Integer.parseInt(st.nextToken());
            x = x + dx[dir];
            y = y + dy[dir];

            // 지도안의 범위일때만
            if (0 <= x && x < n && 0 <= y && y < m) {
                if (dir == 1 || dir == 2) {
                    if (dir == 1) {
                        // 동쪽으로 굴리기
                        int tmp = garo[3];
                        for (int j = 3; j > 0; j--) {
                            garo[j] = garo[j - 1];
                        }
                        garo[0] = tmp;
                    } else {
                        // 서쪽으로 굴리기
                        int tmp = garo[0];
                        for (int j = 0; j < 3; j++) {
                            garo[j] = garo[j + 1];
                        }
                        garo[3] = tmp;
                    }
                    Print("g");

                } else {
                    if (dir == 3) {
                        // 북쪽으로 굴리기
                        int tmp = sero[0];
                        for (int j = 0; j < 3; j++) {
                            sero[j] = sero[j + 1];
                        }
                        sero[3] = tmp;
                    } else {
                        // 남쪽으로 굴리기
                        int tmp = sero[3];
                        for (int j = 3; j > 0; j--) {
                            sero[j] = sero[j - 1];
                        }
                        sero[0] = tmp;
                    }

                    Print("s");
                }
            } else {
                x = x - dx[dir];
                y = y - dy[dir];
            }
        }
    }

    private static void Print(String str) {
        if (str == "g") {
            if (map[x][y] != 0) {
                garo[3] = map[x][y];
                map[x][y] = 0;
            } else {
                map[x][y] = garo[3];
            }
            sero[3] = garo[3];
            sero[1] = garo[1];
        }
        else{
            if(map[x][y] != 0){
                sero[3] = map[x][y];
                map[x][y] = 0;
            }else{
                map[x][y] = sero[3];
            }
            garo[3] = sero[3];
            garo[1] = sero[1];
        }

        System.out.println(garo[1]);
    }
}
