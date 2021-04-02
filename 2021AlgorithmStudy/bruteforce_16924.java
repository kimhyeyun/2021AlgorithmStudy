
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Vector;

public class bruteforce_16924 {
    static int n,m;
    static char board[][];
    static boolean visited[][];
    static int dx[] = {1,0,0,-1}, dy[] = {0,1,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        visited = new boolean[n][m];

        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<m;j++){
                board[i][j] = str.charAt(j);
            }
        }

        int ans = 0;//십자가의 갯수
        Vector<Triple> v = new Vector<>();

        for(int i =1;i<n-1;i++){
            for(int j=1;j<m-1;j++){
                if(board[i][j] == '*'){
                    int one_max = Maxcenter(i,j); //현재칸을 중심으로 십자가를 놓을때 최대크기
                    if(one_max >= 1){
                        putCross(i,j,one_max);
                        ans++;
                        v.add(new Triple(i+1,j+1,one_max));
                        // if(one_max>1){
                        //     for(int a=one_max-1;a>0;a--){
                        //         v.add(new Triple(i+1,j+1,a));
                        //     }
                        // }
                    }
                }
            }
        }

        boolean flag = true;
        for(int i=0;i<n;i++){
            if(!flag)
                break;
            for(int j = 0;j<m;j++){
                //별표인 칸인데 체크안된 칸이 있으면
                if(board[i][j] == '*' && !visited[i][j]){
                    flag = false; //
                    break;
                }
            }
        }

        if(!flag)
            System.out.println(-1);
        else{
            System.out.println(ans);
            for(Triple t : v){
                System.out.println(t.x+" "+t.y+" "+t.z);
            }
        }
    }

    private static void putCross(int i, int j, int one_max) {
        visited[i][j] = true;
        for(int a = 1; a<=one_max;a++){
            visited[i+a][j] = true;
            visited[i-a][j] = true;
            visited[i][j-a] = true;
            visited[i][j+a] = true;
        }
    }

    private static int Maxcenter(int x, int y) {
        int m = Integer.MAX_VALUE;
        for(int i=0;i<4;i++){
            int s = 0;
            int nx = x + dx[i];
            int ny = y + dy[i];
            while(isPossible(nx,ny) && board[nx][ny]=='*'){
                s++;
                nx += dx[i];
                ny += dy[i];
            }
            m = Math.min(m,s);
        }
        return m;
    }

    private static boolean isPossible(int nx, int ny) {
        return 0 <= nx && nx < n && 0 <= ny && ny < m;
    }

    private static class Triple{
        int x;
        int y;
        int z;

        Triple(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
