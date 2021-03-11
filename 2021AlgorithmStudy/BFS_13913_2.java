import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BFS_13913_2 {
  
    static int n, k;
    static int[] visitedtime = new int[100001];
    static int[] parent = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        if (n == k) {
            System.out.println(0);
        } else {
            BFS(n);
        }
    }

    static void BFS(int n) {
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> stk = new Stack<>();
        q.add(n);
        visitedtime[n] = 1;

        while (!q.isEmpty()) {
            int tmp = q.poll();

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0) {
                    next = tmp + 1;
                } else if (i == 1) {
                    next = tmp - 1;
                } else {
                    next = tmp * 2;
                }

                if (next == k) {
                    int cur_idx = tmp;
                    stk.push(k);

                    while(cur_idx!=n){
                        stk.push(cur_idx);
                        cur_idx = parent[cur_idx];
                    }

                    stk.push(cur_idx);

                    System.out.println(visitedtime[tmp]);
                    while(!stk.isEmpty()){
                        System.out.print(stk.pop() + " ");
                    }
                    return;
                }

                if (next >= 0 && next < visitedtime.length && visitedtime[next] == 0) {
                    q.add(next);
                    visitedtime[next] = visitedtime[tmp] + 1;
                    parent[next] = tmp;
                }
            }
        }
    }

}
