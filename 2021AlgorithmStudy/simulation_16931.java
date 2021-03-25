import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class simulation_16931 {
    static int n,m,paper[][],ans;
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        paper = new int[n+2][m+2];
        for(int a[]:paper)
            Arrays.fill(a, 0);

        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=m;j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans =  n*m*2;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                for(int k=0;k<4;k++){
                    int nx = i+dx[k];
                    int ny = j+dy[k];

                    if(paper[i][j] > paper[nx][ny])
                        ans += (paper[i][j] - paper[nx][ny]);
                }
            }
        }

        System.out.println(ans);
    }
    
}
