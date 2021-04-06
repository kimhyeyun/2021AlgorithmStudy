import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

public class bruteforce_16937 {
    static int paper[][];
    static Vector<Triple> stickers;
    static int h, w, n, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        paper = new int[h][w];

        n = Integer.parseInt(br.readLine());

        stickers = new Vector<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (x * y < h * w) {
                stickers.add(new Triple(x, y, i));
                if (x != y)
                    stickers.add(new Triple(y, x, i));
            }
        }
        
        ans = 0; 
        for(int i=0;i<stickers.size();i++){
            for(int j=0;j<stickers.size();j++){
                if(stickers.elementAt(i).idx == stickers.elementAt(j).idx)  
                    continue;
                int x1 = stickers.elementAt(i).x;
                int x2 = stickers.elementAt(j).x;
                int y1 = stickers.elementAt(i).y;
                int y2 = stickers.elementAt(j).y;

                if(x1 + x2 <= h && Math.max(y1,y2)<=w)
                    ans = Math.max(ans,(x1*y1)+(x2*y2));
                if(y1 + y2 <= w && Math.max(x1,x2)<=h)
                    ans = Math.max(ans,(x1*y1)+(x2*y2));
            }
        }

        System.out.println(ans);
    }


    private static class Triple {
        int x;
        int y;
        int idx;

        Triple(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
    }
}
