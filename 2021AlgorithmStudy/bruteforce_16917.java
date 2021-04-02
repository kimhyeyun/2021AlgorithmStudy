import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bruteforce_16917 {
    static int a,b,c,x,y;
    static int ans = 0, tmp = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        if(a+b >= 2*c){
            if(x > y){
                ans += 2*c*y + (x-y) *a; 
            }
            else
                ans += 2*c*x + (y-x)*b;
        }
        else{
            ans += a*x + b*y;
        }

        if(x>=y){
            tmp += 2*x*c;
        }
        else   
            tmp += 2*y*c;


        ans = Math.min(ans, tmp);

        System.out.println(ans);
    }
}
