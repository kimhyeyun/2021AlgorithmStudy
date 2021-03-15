import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


public class simulation_16935_re {
    static int n,m,r,k,arr[][],copy[][];
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        // n = sc.nextInt();
        // m = sc.nextInt();
        // r = sc.nextInt();

        arr = new int[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
            // String str = br.readLine();
            // for(int j=0;j<m;j++){
            //     arr[i][j] = str.charAt(j)-'0';
            // }
            // for(int j=0;j<m;j++)
            //     arr[i][j] = sc.nextInt();
        }


        st = new StringTokenizer(br.readLine());
        for(int i=0;i<r;i++){
            k = Integer.parseInt(st.nextToken());
            //k = sc.nextInt();

            if(k == 1)
                First();
            else if(k == 2)
                Second();
            else if(k == 3)
                Third();
            else if(k == 4)
                Fourth();
            else if(k == 5)
                Fifth();
            else
                Sixth(); 
        }

        printArr();

    }

    private static void printArr() {
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    //상하반전
    private static void First() {
        copy = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                copy[n-i-1][j] = arr[i][j];
            }
        }
        arr = copy;
    }

    //좌우반전
    private static void Second() {
        copy = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                copy[i][m-j-1] = arr[i][j];
            }
        }
        arr = copy;
    }

    //오른쪽 90도 회전
    private static void Third() {
        copy = new int[m][n];

        int col = n-1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                copy[j][col] = arr[i][j];
            }
            col--;
        }

        arr = copy;

        int tmp = n;
        n = m; 
        m = tmp;
    }

    //왼쪽으로 90도 회전
    private static void Fourth() {
        copy = new int[m][n];

        int col = 0;
        for(int i=0;i<n;i++,col++){
            int row = m-1;
            for(int j=0;j<m;j++,row--){
                copy[row][col] = arr[i][j];
            }
        }
        arr = copy;
        int tmp = n;
        n = m; 
        m = tmp;
    }
    
    //5번연산
    private static void Fifth() {
        copy = new int[n][m];

        //1->2
        for(int i=0;i<n/2;i++){
            for(int j=0;j<m/2;j++){
                copy[i][j+m/2] = arr[i][j];
            }
        }

        //2->3
        for(int i=0;i<n/2;i++){
            for(int j=m/2;j<m;j++){
                copy[i+n/2][j] = arr[i][j];
            }
        }

        //3->4
        for(int i=n/2;i<n;i++){
            for(int j=m/2;j<m;j++){
                copy[i][j-m/2] = arr[i][j];
            }
        }

        //4->1
        for(int i=n/2;i<n;i++){
            for(int j=0;j<m/2;j++){
                copy[i-n/2][j] = arr[i][j];
            }
        }

        arr = copy;
    }

    //6번 연산
    private static void Sixth() {
        copy = new int[n][m];

        //1->4
        for(int i=0;i<n/2;i++){
            for(int j=0;j<m/2;j++){
                copy[i+n/2][j] = arr[i][j];
            }
        }

        //2->1
        for(int i=0;i<n/2;i++){
            for(int j=m/2;j<m;j++){
                copy[i][j-m/2] = arr[i][j];
            }
        }

        //3->2
        for(int i=n/2;i<n;i++){
            for(int j=m/2;j<m;j++){
                copy[i-n/2][j] = arr[i][j];
            }
        }

        //4->3
        for(int i=n/2;i<n;i++){
            for(int j=0;j<m/2;j++){
                copy[i][j+m/2] = arr[i][j];
            }
        }

        arr = copy;
    }
}
