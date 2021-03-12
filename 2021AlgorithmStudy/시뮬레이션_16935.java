import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 시뮬레이션_16935 {
    static int n, m, r, array[][], copy[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        array = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                array[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int step = Integer.parseInt(st.nextToken());

            if (step == 1)
                first();
            else if (step == 2)
                second();
            else if (step == 3)
                third();
            else if (step == 4)
                fourth();
            else if (step == 5)
                fifth();
            else if (step == 6)
                sixth();
       

        }
    }

    private static void first() {
        copy = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                 copy[n-i-1][j] = array[i][j];
            }
        }
        array = copy;
    }


    private static void second() {
        copy = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                copy[i][j] = array[i][m-j-1];
            }
        }
        array = copy;
    }

    private static void third() {
        copy = new int[m][n];
        int col = n-1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                copy[j][col] = array[i][j]; 
            }
            col--;
        }
        int tmp = n;
        n = m;
        m = tmp;
        
        array = copy;
    }

    private static void fourth() {
        copy = new int[m][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                copy[m-j-1][i] = array[i][j];
            }
        }
        int tmp = n;
        n = m;
        m = tmp;

        array = copy;
    }

    private static void fifth(){

        for(int i=0;i<n/2;i++){
            for(int j=0;j<m/2;j++){
                
            }
        }
    }


}
