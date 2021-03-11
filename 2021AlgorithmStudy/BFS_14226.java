import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_14226{
    static final int MAX = 2001;
    static int s, ans;
    static boolean visited[][] = new boolean[MAX][MAX];
    //행은 화면에 있는 갯수, 열은 클립보드의 갯수
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        s = sc.nextInt();

        BFS();

        System.out.println(ans);

    }

    static void BFS(){
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(1,0,0));
        visited[1][0] = true;

        while(!q.isEmpty()){
            pair p = q.poll();
            int screen = p.x;
            int clip = p.y;
            int time = p.z;

            if(screen == s){
                ans = time;
                return;
            }
            
            //copy
            q.add(new pair(screen,screen,time+1));

            //paste
            //범위를 확인해주지않자 런타임에러 폭탄;;;
            if(clip!=0 && !visited[screen+clip][clip] && screen+clip<=1000){
                visited[screen+clip][clip] = true;
                q.add(new pair(screen+clip,clip,time+1));
            }

            //delete
            if(screen>0 && !visited[screen-1][clip] && screen-1<=1000){
                visited[screen-1][clip] = true;
                q.add(new pair(screen-1,clip,time+1));
            }
            
        }
    }

    static class pair{
        int x,y,z;
        pair(int x, int y, int z){
            this.x = x; //행
            this.y = y; //열
            this.z = z; //시간
        }
    }
}