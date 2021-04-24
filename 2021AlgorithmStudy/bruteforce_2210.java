import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class bruteforce_2210 {
    static int dx[] = {-1,0,0,1};
    static int dy[] = {0,-1,1,0};
    static int digits[][] = new int[5][5];
    static HashSet<String> hs = new HashSet<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 

        for(int i=0;i<5;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++){
                digits[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        String str = new String();
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                DFS(i,j,0,str);
            }
        }

        System.out.println(hs.size());
    }
    private static void DFS(int x, int y, int cnt, String str) {
        if(cnt == 6){
            hs.add(str);
            return;
        }
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(0 <= nx && nx < 5 && 0 <= ny && ny < 5){
                DFS(nx,ny,cnt+1,str+digits[x][y]);
            }
        }
    }
}
