import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class simulation_16926_re {
    static int n,m,r,N,arr[][];
    static int dx[] ={0,1,0,-1};
    static int dy[] ={1,0,-1,0};

     public static void main(String[] args) throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st = new StringTokenizer(br.readLine());

         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());
         r = Integer.parseInt(st.nextToken());

         N = Math.min(n,m)/2;

        arr = new int[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i=0;i<r;i++)
            spin();
        
        PrintArr();
     }

    private static void PrintArr() {
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void spin() {
        for(int i=0;i<N;i++){
            int x = i;
            int y = i;
            int dir = 0;
            int tmp = arr[x][y];

            while(dir<4){
                int nx = x+dx[dir];
                int ny = y+dy[dir];

                if(i<=nx && nx<=n-i-1 && i<=ny && ny<=m-i-1){
                    arr[x][y] = arr[nx][ny];
                    x = nx;
                    y = ny;
                }
                else
                    dir++;
            }

            arr[x+1][y] = tmp;
        }
    }
    
}
