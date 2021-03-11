import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_13549 {
    public static void main(String[] args) {
        final int MAX = 100001;

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] visitedtime = new int[MAX];
        boolean[] check = new boolean[MAX];

        if (n == k)
            System.out.println(0);
        else {
            Queue<Integer> q = new LinkedList<>();

            q.add(n);
            visitedtime[n] = 0;
            check[n] =true;

            while (!q.isEmpty()) {
                int tmp = q.poll();
                
                if(tmp == k){
                    System.out.println(visitedtime[k]);
                    break;
                }

                if(tmp*2<MAX && !check[tmp*2]){
                    visitedtime[tmp*2] = visitedtime[tmp];
                    q.add(tmp*2);
                    check[tmp*2] = true;
                }

                if(0<=tmp-1&& !check[tmp-1]){
                    visitedtime[tmp-1] = visitedtime[tmp]+1;
                    q.add(tmp-1);
                    check[tmp-1]=true;
                }
                
                if(tmp+1<MAX && !check[tmp+1]){
                    visitedtime[tmp+1] = visitedtime[tmp]+1;
                    q.add(tmp+1);
                    check[tmp+1] = true;
                }
               
            }
        }
    }
}
