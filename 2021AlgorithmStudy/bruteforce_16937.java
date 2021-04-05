import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

public class bruteforce_16937 {
    static int paper[][];
    static Vector<Triple> stickers;
    static Vector<pair> choice;
    static boolean one[], two[];
    static int h,w,n,ans;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        paper = new int[h][w];

        n = Integer.parseInt(br.readLine());
        
        stickers = new Vector<>();
        choice = new Vector<>();

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(x*y >= h*w)
                continue;

            stickers.add(new Triple(x,y,i));

            if(x!= y)
                stickers.add(new Triple(y,x,i));
        }

        one = new boolean[stickers.size()];
        two = new boolean[stickers.size()];

        if(stickers.size()<=1){
            System.out.println(0);
            return;
        }

        ans = 0;

        DFS(0,0);
        System.out.println(ans);
    }

    

    private static void DFS(int idx, int cnt) {

        if(cnt == 2){
            int x = stickers.firstElement().x;
            int xx = stickers.lastElement().x;
            int y = stickers.firstElement().y;
            int yy = stickers.lastElement().y;
            int sz = (x*y) + (xx*yy);

            if(x + xx <= h){
                int my = Math.max(y, yy);
                if(my <= w){
                    ans = Math.max(ans, sz);
                }
            }

            if(y+yy <= w){
                int mx = Math.max(x,xx);
                if(mx <= h){
                    ans = Math.max(ans, sz);
                }
            }
            return;
        }

        for(int i=idx;i<stickers.size();i++){
            if(!one[i] && !two[stickers.elementAt(i).idx]){
                one[i] = true;
                two[stickers.elementAt(i).idx] = true;
                choice.add(new pair(stickers.elementAt(i).x,stickers.elementAt(i).y));
                DFS(i,cnt+1);
                choice.remove(choice.size()-1);
                one[i]= false;
                two[stickers.elementAt(i).idx] = false;

            }
        }
    }




    private static class pair{
        int x;
        int y;
        
        pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    

    private static class Triple{
        int x;
        int y;
        int idx;
        Triple(int x,int y,int idx){
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
    }
}
