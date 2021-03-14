import java.util.Scanner;

public class simulation_14890 {

    static int n, l;
    static int map[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();

        map = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                map[i][j] = sc.nextInt();
        }

        int cnt = 0;

        for(int i=0;i<n;i++){
            //가로길
            if(isPossible(map[i])){
                cnt++;
            }

            //세로길
            int tmp[] = new int[n];
            for(int j=0;j<n;j++){
                tmp[j] = map[j][i];
            }

            if(isPossible(tmp))
                cnt++;
       }

       System.out.println(cnt);
    }


    private static boolean isPossible(int[] arr) {
        int idx = 0;
        boolean[] stairs = new boolean[n];

        while(true){
            if(idx==n-1)
                break;

            //올라가는 경사
            if(arr[idx+1] == arr[idx]+1){
                if(idx-l+1 < 0)
                    return false;

                for(int i=idx-l+1; i<=idx;i++)
                    if(stairs[i]||arr[i]!=arr[idx])
                        return false;

                idx++;
            }

            //내려가는 경사
            else if(arr[idx+1] == arr[idx]-1){
                if(idx + l >= n)
                    return false;
                
                for(int i=idx+1;i<=idx+l;i++){
                    stairs[i] = true;
                    if(arr[i] != arr[idx]-1)
                        return false;
                }
                idx+=l;
            }

            //평지인 경우
            else if(arr[idx]==arr[idx+1])
                idx++;

            //높이가 2이상 차이
            else{
                return false;
            }
        }
        return true;
    }
    
}
