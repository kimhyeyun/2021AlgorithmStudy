import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bruteforce_15638 {
    static int place[][], n, m, ans;
    static ArrayList<node> list = new ArrayList<node>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        place = new int[n][m];
        ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                place[i][j] = Integer.parseInt(st.nextToken());
                if (1 <= place[i][j] && place[i][j] <= 5) {
                    list.add(new node(i, j, place[i][j]));
                }
            }
        }

        Check(0, place);

        System.out.println(ans);

    }

    private static void Check(int cnt, int[][] prev) {
        int[][] visited = new int[n][m];
        if (cnt == list.size()) {
            int tmp = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (prev[i][j] == 0)
                        tmp++;
                }
            }
            ans = Math.min(ans, tmp);
        } else {
            node newN = list.get(cnt);
            int idx = newN.idx;
            int x = newN.x;
            int y = newN.y;

            switch (idx) {
            case 1:
                for (int d = 0; d < 4; d++) {
                    for (int j = 0; j < n; j++) {
                        visited[j] = Arrays.copyOf(prev[j], m);
                    }
                    detect(visited, x, y, d);
                    Check(cnt + 1, visited);
                }
                break;
            case 2:
                for (int d = 0; d < 2; d++) {
                    for (int j = 0; j < n; j++) {
                        visited[j] = Arrays.copyOf(prev[j], m);
                    }
                    detect(visited, x, y, d);
                    detect(visited, x, y, d + 2);
                    Check(cnt + 1, visited);
                }
                break;

            case 3:
                for (int d = 0; d < 4; d++) {
                    for (int j = 0; j < n; j++) {
                        visited[j] = Arrays.copyOf(prev[j], m);
                    }
                    detect(visited, x, y, d);
                    detect(visited, x, y, (d+1)%4);
                    Check(cnt+1,visited);
                }
                break;

            case 4:
                for(int d=0;d<4;d++){
                    for(int j=0;j<n;j++){
                        visited[j] = Arrays.copyOf(prev[j],m);
                    }
                    detect(visited,x,y,d);
                    detect(visited,x,y,(d+1)%4);
                    detect(visited,x,y,(d+2)%4);
                    Check(cnt+1,visited);
                }
                break;

            case 5:
                for(int j=0;j<n;j++)
                    visited[j] = Arrays.copyOf(prev[j],m);

                    detect(visited,x,y,0);
                    detect(visited,x,y,1);
                    detect(visited,x,y,2);
                    detect(visited,x,y,3);
                    Check(cnt+1,visited);
                    break;
            }

        }
    }

    private static void detect(int[][] visited, int x, int y, int dir) {
        switch (dir) {
        case 0:
            // 위 방향
            for (int i = x; i >= 0; i--) {
                if (place[i][y] == 6)
                    break;
                visited[i][y] = 7;
            }
            break;

        case 1:
            // 오른쪽방향
            for (int j = y; j < m; j++) {
                if (place[x][j] == 6)
                    break;
                visited[x][j] = 7;
            }
            break;

        case 2:
            // 아래 방향
            for (int i = x; i < n; i++) {
                if (place[i][y] == 6)
                    break;
                visited[i][y] = 7;
            }
            break;

        case 3:
            // 왼쪽방향
            for (int j = y; j >= 0; j--) {
                if (place[x][j] == 6)
                    break;
                visited[x][j] = 7;
            }
            break;
        }

    }

    static private class node {
        int x;
        int y;
        int idx;

        node(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
    }
}
