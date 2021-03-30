import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class simulation_16967 {
    static int h,w,x,y;
    static int B[][], A[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        B = new int[h+x][w+y];
        A = new int[h][w];

        for(int i=0;i<h+x;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<w+y;j++){
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<h+x;i++){
            for(int j=0;j<w+y;j++){
                int num  = B[i][j];
                if(num == 0)
                    continue;

                if(CheckRange(i,j) && CheckRange(i-x,j-y)){
                    A[i][j] = B[i][j] - A[i-x][j-y];
                }
                
                else if(CheckRange(i,j) && !CheckRange(i-x, j-y)){
                    A[i][j] = num;
                }

                else if(!CheckRange(i, j) && CheckRange(i-x, j-y)){
                    A[i-x][j-y] = B[i][j];
                }

            }
        }

        for(int i=0;i<h;i++){
            for(int j =0;j<w;j++){
                System.out.print(A[i][j]+" ");
            }
            System.out.println();
        }
    }
    private static boolean CheckRange(int i, int j) {
        if(0 <= i && i < h && 0 <= j && j < w)
            return true; 
        return false;
    }
}
