import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;


public class bruteforce_15686 {
    static int n,m,tmp,min;
    static ArrayList<pair> house = new ArrayList<>();
    static ArrayList<pair> chickens = new ArrayList<>();
    static Stack<pair> sel = new Stack<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                tmp = Integer.parseInt(st.nextToken());
                if(tmp == 1)
                    house.add(new pair(i,j));
                else if(tmp == 2)
                    chickens.add(new pair(i,j));
            }
        }
        
        select(0,0);

        System.out.println(min);
    }

    static private void select(int cnt, int start){
        if(cnt == m){
            check();
            return;
        }
        for(int i=start;i<chickens.size();i++){
            sel.push(chickens.get(i));
            select(cnt+1,i+1);
            sel.pop();
        }
    }

    static private void check(){
        int sum = 0;

        for(pair home:house){
            tmp = Integer.MAX_VALUE;

            for(pair chicken:sel)
                tmp = Math.min(tmp,distance(home, chicken));

            sum+=tmp;

            if(sum>min)
                return;
        }
        min = Math.min(sum,min);
    }

    static private int distance(pair a,pair b){
        return Math.abs(a.x-b.x)+Math.abs(a.y-b.y);
    }

    static private class pair{
        int x;
        int y;

        pair(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}
