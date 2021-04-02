import java.util.Scanner;

public class bruteforce_16922 {
    static int n,ans;
    static int Roma[] = {1,5,10,50};
    static boolean visited[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        visited = new boolean[1001];
        ans = 0;
        
        DFS(0,0,0);

        System.out.println(ans);
    }

    private static void DFS(int cnt, int idx, int sum) {
        if(cnt == n){
            if(!visited[sum]){
                visited[sum] = true;
                ans++;
            }
            return;
        }
        for(int i=idx;i<4;i++){
            DFS(cnt+1,i,sum+Roma[i]);
        }
    }
}
