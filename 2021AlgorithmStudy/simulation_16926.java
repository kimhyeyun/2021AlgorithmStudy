import java.util.Scanner;

public class simulation_16926 {
    static int [][]array;
    static int n,m,r,sub;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt();

        array = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                array[i][j] = sc.nextInt();
            }
        }

        sub = Math.min(n,m) / 2;

        for(int i=0;i<r;i++)
            spin();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void spin() {
        for(int s = 0;s<sub;s++){
            int dir = 0;  //방향
            int sx = s;
            int sy = s; 
            int tmp = array[sx][sy];

            while(dir < 4){
                int nx = sx + dx[dir];
                int ny = sy + dy[dir];

                if(nx < s || ny < s || nx >= n-s || ny >= m-s){
                    dir++;
                }
                else{
                    array[sx][sy] = array[nx][ny];
                    sx = nx;
                    sy = ny;
                }
            }
            array[s+1][s] = tmp;

        }
    }
}
