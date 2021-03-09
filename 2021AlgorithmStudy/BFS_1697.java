import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_1697 {
    static int n, k;
    static int[] visitedtime = new int[100001];

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
                    System.out.println(visitedtime[tmp]);
                    return;
                }

                if (next >= 0 && next < visitedtime.length && visitedtime[next] == 0) {
                    q.add(next);
                    visitedtime[next] = visitedtime[tmp] + 1;
                }
            }
        }
    }

}
