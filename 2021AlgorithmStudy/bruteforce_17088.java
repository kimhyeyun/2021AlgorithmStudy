
import java.util.Scanner;

public class bruteforce_17088 {
    static int n,ans,a[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n];

        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }

        if(n==1){
            System.out.println(0);
            return;
        }

        ans = -1;
        
        for(int a1 = -1;a1<2;a1++){
            for(int a2 = -1;a2<2;a2++){
                int c = 0;
                if(a1 != 0)
                    c++;
                if(a2 != 0)
                    c++;

                int b1 = a[0] + a1;
                int d = a[1] + a2 - b1;
                boolean flag = true;
                int cur = b1+d;
                for(int i=2;i<n;i++){
                    cur+=d;
                    if(a[i] == cur)
                        continue;
                    else if(a[i]+1 == cur || a[i]-1 == cur)
                        c++;
                    else{
                        flag = false;
                        break;
                    }
                }

                if(flag){
                    if(ans == -1 || ans > c)    
                        ans = c;
                }
            }
        }

        System.out.println(ans);
    }

}
