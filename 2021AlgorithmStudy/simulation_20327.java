import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.concurrent.Flow.Subscriber;

public class simulation_20327 {
    static int N, n, r, k, l, arr[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        N = 1 << n;
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        while(r-- > 0) {
            st = new StringTokenizer(br.readLine());

            k = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());

            int sub_sz = 1 << l;

            if(1 <= k && k <= 4){
                //부분 집합 대로 요청
                for(int i=0;i<N;i+=sub_sz){
                    for(int j=0;j<N;j+=sub_sz){
                        op1_4(arr,k,i,j,sub_sz);
                    }
                }
            }
            else if(5<=k && k<=8){
                if(k==5)
                    arr = op5(arr,sub_sz);
                else if(k==6)
                    arr = op6(arr,sub_sz);
                else if(k==7)
                    arr = op7(arr,sub_sz);
                else
                    arr = op8(arr,sub_sz);
                }

        }

        PrintArr();
    }

    //부분배열 왼쪽으로 90도 회전
    private static int[][] op8(int[][] arr, int sub) {
        int ans[][] = new int[N][N];
        int sub_cnt = N/sub;

        for(int i=0;i<sub_cnt;i++){
            for(int j=0;j<sub_cnt;j++){
                int x1 = i * sub;
                int y1 = j * sub;

                //x1, y1 위치에 올 값
                int x2 = j * sub;
                int y2 = (sub_cnt-i-1) * sub;

                for(int x = 0;x<sub;x++){
                    for(int y = 0;y<sub;y++){
                        ans[x1+x][y1+y] = arr[x2+x][y2+y];
                    }
                }
            }
        }
    }

    //부분배열 오른쪽으로 90도 회전
    //부분배열 안에서는 위치 변화 x
    private static int[][] op7(int[][] arr, int sub) {
        int ans[][] = new int[N][N];
        int sub_cnt = N/sub;

        for(int i=0;i<sub_cnt;i++){
            for(int j=0;j<sub_cnt;j++){
                int x1 = i * sub;
                int y1 = j * sub;

                int x2 = j * sub;
                int y2 = (sub_cnt-i-1) * sub;

                for(int x = 0;x<sub;x++){
                    for(int y = 0;y<sub;y++){
                        ans[x2+x][y2+y] = arr[x1+x][y1+y];
                    }
                }
            }
        }
        return ans;

        return ans;
    }

    //부분 배열끼리 좌우 반전
    private static int[][] op6(int[][] arr, int sub) {
        int ans[][] = new int[N][N];
        int sub_cnt = N/sub;

        for(int i=0;i<sub_cnt;i++){
            for(int j=0;j<sub_cnt;j++){
                int x1 = i * sub;
                int y1 = j * sub;

                int x2 = i * sub;
                int y2 = (sub_cnt-j-1) *sub;

                for(int x=0;x<sub;x++){
                    for(int y =0;y<sub;y++){
                        ans[x+x1][y+y1] = arr[x+x2][y+y2];
                    }
                }
            }
        }
        return ans;
    }

    //부분배열=1칸 상하 반전
    private static int[][] op5(int[][] arr, int sub) {
        int ans[][] = new int[N][N];
        int sub_cnt = N/sub;

        for(int i=0;i<sub_cnt;i++){
            for(int j=0;j<sub_cnt;j++){
                //원래 부분배열의 좌측 상단
                int x1 = i*sub;
                int y1 = j*sub;

                //바뀌여야 할 배열의 좌측상단
                int x2 = (sub_cnt-i-1) *sub;
                int y2 = j*sub;

                for(int x=0;x<sub;x++){
                    for(int y = 0;y<sub;y++){
                        ans[x1+x][y1+y] = arr[x2+x][y2+y];
                    }
                }
            }
        }
        return ans;
    }

    private static void PrintArr() {
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void op1_4(int[][] a, int k, int x , int y , int sub_sz) {
        int tmp[][] = new int[sub_sz][sub_sz];
        for(int i=0;i<sub_sz;i++){
            for(int j=0;j<sub_sz;j++){
                tmp[i][j] = a[x+i][y+j];
            }
        }

        if(k==1)
            tmp=op1(tmp,sub_sz);
        else if(k==2)
            tmp = op2(tmp,sub_sz);
        else if(k==3)
            tmp = op3(tmp,sub_sz);
        else
            tmp = op4(tmp,sub_sz);

        for(int i=0;i<sub_sz;i++){
            for(int j=0;j<sub_sz;j++){
                a[x+i][y+j] = tmp[i][j];            
            }
        }
    }

    //왼쪽으로 90도 회전
    private static int[][] op4(int[][] tmp, int sub) {
        int ans[][] = new int[sub][sub];

        int col = sub-1;
        for(int i=0;i<sub;i++,col--){
            for(int j=0;j<sub;j++){
                ans[i][j] = tmp[j][col];
            }
        }
        return ans;
    }

    //오른쪽으로 90도 회전
    private static int[][] op3(int[][] tmp, int sub) {
        int ans[][] = new int[sub][sub];

        for(int i=0;i<sub;i++){
            int r = sub-1;
            for(int j=0;j<sub;j++,r--){
                ans[i][j] = tmp[r][i];
            }
        }
        return ans;
    }

    //좌우반전
    private static int[][] op2(int[][] tmp, int sub) {
        int ans[][] = new int[sub][sub];

        for(int i=0;i<sub;i++){
            for(int j=0;j<sub;j++){
                ans[i][j] = tmp[i][sub-j-1];
            }
        }
        return ans;
    }

    //상하 반전
    private static int[][] op1(int[][] tmp, int sub) {
        int ans[][] = new int[sub][sub];

        for(int i=0;i<sub;i++){
            for(int j=0;j<sub;j++){
                ans[i][j] = tmp[sub-i-1][j];
            }
        }
        return ans;
    }


}//실패