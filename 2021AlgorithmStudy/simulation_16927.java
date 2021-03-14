import java.util.Scanner;

public class simulation_16927 {
    static int n,m,r;
    static int[][] array;
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

        int row_start = 0;
        int row_end = n-1;
        int col_start = 0;
        int col_end = m-1;

        while(true){
            //돌릴 갯수
            int sz = (row_end-row_start+1) *2 + (col_end-col_start+1)*2 -4;
            spin(row_start,row_end,col_start,col_end,r%sz);
            row_start++;
            row_end--;
            col_start++;
            col_end--;
            if(row_start>row_end || col_start > col_end)
                break;
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }

    
    private static void spin(int row_start, int row_end, int col_start, int col_end, int cnt) {
        for(int i=0;i<cnt;i++){
            int tmp = array[row_start][col_start];

            //위 가로
            for(int j=col_start;j<col_end;j++)
                array[row_start][j] = array[row_start][j+1];
            
            //오른쪽 세로
            for(int j=row_start;j<row_end;j++)
                array[j][col_end] = array[j+1][col_end];

            //아래 가로
            for(int j=col_end;j>col_start;j--)
                array[row_end][j] = array[row_end][j-1];

            //왼쪽 세로
            for(int j=row_end;j>row_start;j--)
                array[j][col_start] = array[j-1][col_start];

            array[row_start+1][col_start] = tmp;
        }
    }
}
