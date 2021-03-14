import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class simulation_14499 {
    static int n,m,x,y,k;
    static int[][] map;
    static int sero[], garo[];
    static int dx[] = {0,0,0,-1,1};
    static int dy[] = {0,1,-1,0,0};

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        k = sc.nextInt();

        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());

        // n = Integer.parseInt(st.nextToken());
        // m = Integer.parseInt(st.nextToken());
        // x = Integer.parseInt(st.nextToken());
        // y = Integer.parseInt(st.nextToken());
        // k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        //각각 1이 위 3이 아래 그래서 섞어줘도 1과 3의 값은 동일해야함
        sero = new int[4];
        garo = new int[4];

        for(int a=0;a<n;a++){
            // st = new StringTokenizer(br.readLine());
            for(int b=0;b<m;b++){
                // map[a][b] = Integer.parseInt(st.nextToken());
                map[a][b] = sc.nextInt();
            }
        }

        Arrays.fill(garo, 0);
        Arrays.fill(sero, 0);

        // String d = br.readLine();
        // st = new StringTokenizer(d, " ");
        for(int i=0;i<k;i++){
            // int dir = Integer.parseInt(st.nextToken());
            int dir = sc.nextInt();

            x += dx[dir];
            y += dy[dir];

            if(0 <= x && x < n && 0 <= y && y < m){
                if(dir==1 ||dir==2){ //동 서
                    if(dir==1){
                        //동쪽
                        int tmp = garo[3];
                        for(int j = 3;j > 0;j--)
                            garo[j] = garo[j-1];

                        garo[0] = tmp;
                        sero[1] = garo[1];
                        sero[3] = garo[3];

                        garoPrint(x,y);
                    }

                    else{
                        //서쪽
                        int tmp = garo[0];
                        for(int j = 0;j <3;j++ )
                            garo[j] = garo[j+1];

                        garo[3] = tmp;
                        sero[1] = garo[1];
                        sero[3] = garo[3];

                        garoPrint(x, y);
                    }
                }

                else if(dir == 3 || dir == 4){ //북 남
                    //북쪽
                    if(dir == 3){
                        int tmp = sero[0];
                        for(int j=0;j<3;j++){
                            sero[j] = sero[j+1];
                        }

                        sero[3] = tmp;
                        garo[3] = sero[3];
                        garo[1] = sero[1];

                        seroPrint(x,y);
                    }
                    else{
                        int tmp = sero[3];
                        for(int j=3;j>0;j--){
                            sero[j] = sero[j-1];
                        }

                        sero[0] = tmp;
                        garo[1] = sero[1];
                        garo[3] = sero[3];

                        seroPrint(x,y);
                    }
                }
            }
            else{
                x -= dx[dir];
                y -= dy[dir];
            }
        }
    }

    private static void seroPrint(int i, int j) {
        if(map[i][j]==0){
            map[i][j] = sero[3];
            garo[3] = sero[3];
        }

        else{
            sero[3] = map[i][j];
            garo[3] = sero[3];
            map[i][j] = 0;
        }

        System.out.println(sero[1]);
    }

    private static void garoPrint(int i, int j) {
        if(map[i][j] == 0){
            map[i][j] = garo[3];
            sero[3] = garo[3];
        }

        else{
            garo[3] = map[i][j];
            sero[3] = garo[3];
            map[i][j] = 0;
        }

        System.out.println(garo[1]);
    }
    
}
