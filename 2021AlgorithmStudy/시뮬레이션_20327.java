import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 시뮬레이션_20327 {
    static int N, n, r, k, l, array[][], copy[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        N = 1 << n;
        array = new int[N][N];
        copy = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                array[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());

            k = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());

            int sz = 1 << l;

            if (sz == 0)
                continue;
            else if (k == 1)
                first(l);
            else if (k == 2)
                second(l);
            else if (k == 3)
                third(l);
            else if (k == 4)
                fourth(l);
            else if (k == 5)
                fifth(l);
            else if (k == 6)
                sixth(l);
            else if (k == 7)
                seventh(l);
            else if (k == 8)
                eighth(l);

        }
    }

    private static void first(int sz) {
        int row, col;

        for (int i = 0; i < N; i += sz) {
            for (int j = 0; j < N; j += sz) {
                // 부분 행렬에서 각 행/렬의 마지막 인덱스
                row = i + sz;
                col = j + sz;

                for (int a = i; a < row; a++) {
                    for (int b = j; b < col; b++) {
                        if (a % 2 == 0)
                            copy[a][b] = array[a + 1][b];
                        else
                            copy[a][b] = array[a - 1][b];
                    }
                }
            }
        }
        ArCpy();
    }


    private static void second(int sz) {
        int row,col;
        
        for(int i=0;i<N;i+=sz){
            for(int j=0;j<N;j+=sz){
                row = i+sz;
                col = j+sz;

                for(int a=i;a<row;a++){
                    for(int b=j;b<col;b++){
                        if(b%2==0)
                            copy[a][b] = array[a][b+1];
                        else
                            copy[a][b] = array[a][b-1];
                    }
                }
            }
        }
        ArCpy();
    }

    private static void third(int sz) {
        int row,col;

        for(int i=0;i<)
    }

    private static void fourth(int step, int sz) {
    }


    static void ArCpy(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                array[i][j] = copy[i][j];
            }
        }
    }
}//실패