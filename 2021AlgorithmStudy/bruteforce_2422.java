import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class bruteforce_2422 {
    static int n,m,ans;
    static boolean[][] not;
    static boolean[] visited;
    static int[] choice = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        not = new boolean[n][n];
        visited = new boolean[n];

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;

            not[a][b] = true;
            not[b][a] = true;
        }

        ans = 0;
        DFS(0,0);
        System.out.println(ans);
        
    }

    private static void DFS(int idx, int cnt) {
        if(cnt == 3){
            if(check())
                ans++;
            return;
        }
        for(int i=idx;i<n;i++){
            if(!visited[i]){
                visited[i]=true;
                choice[cnt]=i;
                DFS(i, cnt+1);
                visited[i]=false;
            }
        }
    }

    private static boolean check() {
        for(int i=0;i<2;i++){
            for(int j=i+1;j<3;j++){
                if(not[choice[i]][choice[j]])  
                    return false;
            }
        }
        return true;
    }
}
