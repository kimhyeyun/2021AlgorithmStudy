import java.util.Scanner;

public class bruteforce_16637 {
    static int n;
    static long ans;
    static String susix;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        susix = sc.next();
        ans = Long.MIN_VALUE;


        DFS(0,0);

        System.out.println(ans);
        
    }
    private static void DFS(int idx,long sum) {
        if(idx > n-1){
            ans = Math.max(sum,ans);
            return;
        }

        char op = idx==0 ? '+':susix.charAt(idx-1);

        //괄호로 묶음
        if(idx+2<n){
            long braket = Cal(susix.charAt(idx)-'0',susix.charAt(idx+2)-'0',susix.charAt(idx+1));
            DFS(idx+4,Cal(sum,braket,op));
        }

        //안 묶음
        DFS(idx+2,Cal(sum,susix.charAt(idx)-'0',op));
    }
    private static long Cal(long i, long j, char op) {
        long result = 0;
        switch(op){
            case '+': 
                result = i+j;
                break;
            case '-': 
                result = i-j;
                break;
            case '*': 
                result = i*j;
                break;
        }
        return result;
    }
}
