import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_13549 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int visitedtime[] = new int[100001];

        if (n == k)
            System.out.println(0);
        else {
            Queue<Integer> q = new LinkedList<>();

            q.add(n);
            visitedtime[n] = 1;

            while (!q.isEmpty()) {
                int tmp = q.poll();
                int next;
                boolean flag = false;

                for (int i = 0; i < 3; i++) {
                    if (i == 0) {
                        next = tmp + 1;
                    } else if (i == 1) {
                        next = tmp - 1;
                    } else {
                        next = tmp * 2;
                        flag = true;
                    }

                    if (next == k) {
                        System.out.println(visitedtime[tmp]);
                        return;
                    }
                    if (next >= 0 && next < visitedtime.length && visitedtime[next] == 0) {
                        if (flag) {
                            visitedtime[next] = visitedtime[tmp];
                            q.add(next);
                        } else {
                            visitedtime[next] = visitedtime[tmp] + 1;
                            q.add(next);
                        }
                    }
                }
            }
        }
    }
}
