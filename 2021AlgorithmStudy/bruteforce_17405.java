import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bruteforce_17405 {
    static int n,m,k,a[][],rcs[][],min;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        min = Integer.MAX_VALUE;

        a = new int[n][m];
        rcs = new int[k][3];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine());
            rcs[i][0] = Integer.parseInt(st.nextToken());
            rcs[i][1] = Integer.parseInt(st.nextToken());
            rcs[i][2] = Integer.parseInt(st.nextToken());
        }

       Gopermutation(new boolean[k],new LinkedList<Integer>());

       System.out.println(min);
    }

    private static void Gopermutation(boolean[] visited, LinkedList<Integer> list) {
        if(list.size() == k){
            int[][] arr = copy();
            
            //뽑힌 순열대로 배열 돌리기 수행
            for(Integer idx : list){
                int r = rcs[idx][0];
                int c = rcs[idx][1];
                int s = rcs[idx][2];

                for(int i=0;i<s;i++){
                    int x1 = r-s-1+i;
                    int y1 = c-s-1+i;
                    int x2 = r+s-1-i;
                    int y2 = c+s-1-i;
                    
                    Rotate(arr,x1,y1,x2,y2);
                }
            }
            min = Math.min(min,calrow(arr));
            return;
        }

        for(int i=0;i<k;i++){
            if(!visited[i]){
                visited[i]=true;
                list.add(i);

                Gopermutation(visited, list);

                visited[i] = false;
                list.removeLast();
            }
        }

    }

    private static int calrow(int[][] arr) {
        int minrow = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int total = 0;
            for(int j=0;j<m;j++){
                total+=arr[i][j];
            }
            minrow = Math.min(total,minrow);
        }
        return minrow;
    }

    private static void Rotate(int[][] arr, int x1, int y1, int x2, int y2) {
        int tmp;

        //왼쪽
        tmp = arr[x1][y1]; 
        for(int i=x1;i<x2;i++){
            arr[i][y1] = arr[i+1][y1];
        }
        //아래
        for(int i=y1;i<y2;i++){
            arr[x2][i] = arr[x2][i+1];
        }
        //오른쪽
        for(int i=x2;i>x1;i--){
            arr[i][y2] = arr[i-1][y2];
        }
        //위
        for(int i=y2;i>y1;i--){
            arr[x1][i] = arr[x1][i-1];
        }

        arr[x1][y1+1] = tmp;
    }

    private static int[][] copy() {
        int [][] tmp = new int[n][m];
        for(int i=0;i<n;i++){
            tmp[i] = Arrays.copyOf(a[i], m);
        }
        return tmp;
    }
}
