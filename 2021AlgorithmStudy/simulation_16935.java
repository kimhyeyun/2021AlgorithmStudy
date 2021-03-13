import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class simulation_16935 {
    static int n, m, r, array[][], copy[][];

    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());
        Scanner sc = new Scanner(System.in);

        // n = Integer.parseInt(st.nextToken());
        // m = Integer.parseInt(st.nextToken());
        // r = Integer.parseInt(st.nextToken());
        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt();

        array = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                array[i][j] = sc.nextInt();
        }

        for (int i = 0; i < r; i++) {
            // st = new StringTokenizer(br.readLine());
            int step = sc.nextInt();

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
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(array[i][j]+ " ");
            }
            System.out.println();
        }

        br.close();
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
                copy[i][m-j-1] = array[i][j];
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

    //1->2 2->3 3->4 4->1 이동
    private static void fifth(){
        copy = new int[n][m];

        //1->2
        for(int i=0;i<n/2;i++){
            for(int j=0;j<m/2;j++){
                copy[i][j+m/2] = array[i][j]; 
            }
        }

        //2->3
        for(int i=0;i<n/2;i++){
            for(int j=m/2;j<m;j++){
                copy[i+n/2][j] = array[i][j]; 
            }
        }

        //3->4
        for(int i=n/2;i<n;i++){
            int col = 0;
            for(int j=m/2;j<m;j++, col++){
                copy[i][col] = array[i][j];
            }
        }

        //4->1
        int row = 0;
        for(int i=n/2;i<n;i++, row++){
            for(int j=0;j<m/2;j++){
                copy[row][j] = array[i][j];
            }
        }
        array = copy;
    }

    //1->4 2->1 3->2 4->3
    private static void sixth(){
        copy = new int[n][m];

        //1->4
        for(int i=0;i<n/2;i++){
            for(int j=0;j<m/2;j++){
                copy[i+n/2][j] = array[i][j];
            }
        }

        //2->1
        for(int i=0;i<n/2;i++){
            int col=0;
            for(int j=m/2;j<m;j++,col++){
                copy[i][col] = array[i][j];
            }
        }

        //3->2
        int row = 0;
        for(int i=n/2;i<n;i++, row++){
            for(int j=m/2;j<m;j++){
                copy[row][j] = array[i][j];
            }
        }

        //4->3
        for(int i=n/2;i<n;i++){
            for(int j=0;j<m/2;j++){
                copy[i][j+m/2] = array[i][j];
            }
        }
        array = copy;
    }

}
