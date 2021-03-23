import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class simulation_15685 {
    static final int MAX = 101;
    static int n, cnt = 0;
    static int dx[] = { 0, -1, 0, 1 };
    static int dy[] = { 1, 0, -1, 0 };
    static boolean map[][];
    static LinkedList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new boolean[MAX][MAX];
        n = Integer.parseInt(br.readLine());

        int x, y, d, g;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());

            list = new LinkedList<Integer>();
            list.add(d);
            curveMake(g);
            drawCurve(x,y);
        }

        Check();
        System.out.println(cnt);
    }

    private static void Check() {
        for(int i=0;i<MAX-1;i++){
            for(int j=0;j<MAX-1;j++){
                if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1])
                    cnt++;
            }
        }
    }

    private static void drawCurve(int x, int y) {
        map[x][y] = true;
        for(int i=0;i<list.size();i++){
            int d = list.get(i);
            x += dx[d];
            y += dy[d];
            map[x][y] = true;
        }
    }

    private static void curveMake(int generation) {
        for(int g = 0; g < generation; g++){
            int size = list.size();
            //세대만큼 진행하는데 
            //사이즈 만큼 뒤에서 부터 90도 돌린 후의 방향을 추가
            for(int s=1;s<=size;s++){
                list.add((list.get(size-s)+1) %4);
            }
        }
    }
}