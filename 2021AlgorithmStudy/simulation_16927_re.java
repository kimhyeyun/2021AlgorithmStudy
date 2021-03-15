import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import jdk.internal.joptsimple.internal.Rows;


public class simulation_16927_re {
    static int n,m,r,sub,arr[][];
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        sub = Math.min(n,m)/2;
        arr = new int[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int row_start = 0;
        int row_end = n-1;
        int col_start = 0;
        int col_end = m-1;

        for(int i=0;i<r;i++){
            int sub_n = (row_end-row_start)*2+(col_end-col_start)*2-4;

            Spin(row_start,row_end,col_start,col_end,r%sub_n);
            row_start++;
            row_end--;
            col_start++;
            col_end--;

        }

        ArrPrint();
        

    }

    private static void ArrPrint() {
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void Spin(int row_start, int row_end, int col_start, int col_end, int num) {
        for(int i=0;i<num;i++){
            int tmp = arr[row_start][col_start];

            //가로 위 
            for(int j=col_start;j<col_end;j++){
                arr[row_start][j] = arr[row_start][j+1];
            }

            //세로 오른쪽
            for(int j=row_start;j<row_end;j++){
                arr[j][col_end] = arr[j+1][col_end];
            }

            //가로 아래
            for(int j=col_end;j>col_start;j--){
                arr[row_end][j] = arr[row_end][j-1];
            }

            //세로 왼쪽
            for(int j=row_end;j>row_start;j--){
                arr[j][col_start] = arr[j-1][col_start];
            }

            arr[row_start+1][col_start] = tmp;
        }
    }
}
