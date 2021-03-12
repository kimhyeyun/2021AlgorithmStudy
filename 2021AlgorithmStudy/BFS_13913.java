import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BFS_13913 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int MAX = 100000;
    private static int visited[];
    private static int parent[];
    
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        //방문여부와 최단거리 저장
        visited = new int[MAX+1];
        //부모 노드 저장
        parent = new int[MAX+1];

        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = 1;

        //경로를 저장할 스택
        Stack<Integer> stk = new Stack<>();

        while(true){
            int cur = q.poll();

            if(0 <= cur-1 && cur-1 <= MAX && visited[cur-1]==0){
                q.add(cur-1);
                visited[cur-1] = visited[cur]+1;
                parent[cur-1] = cur;
            }

            if(0 <= cur+1 && cur+1 <= MAX && visited[cur+1]==0){
                q.add(cur+1);
                visited[cur+1] = visited[cur]+1;
                parent[cur+1] = cur;
            }

            if(0 <= 2*cur && 2*cur <= MAX && visited[cur*2] == 0){
                q.add(cur*2);
                visited[cur*2] = visited[cur]+1;
                parent[cur*2] = cur;
            }

            // 동생을 잡았다면 우선 stack에 경로 넣어주기
            if(visited[k]!=0){
                int cur_idx = k;

                //parent를 따라가면서 경로 저장
                while(cur_idx != n){
                    stk.push(cur_idx);
                    cur_idx = parent[cur_idx];
                }

                //시작 위치인 n 추가
                stk.push(cur_idx);
                break;
            }
        }

        //시작 위치를 1로 지정해주었기 때문에 -1해주기
        bw.write(visited[k]-1 + "\n");

        while(!stk.isEmpty()){
            bw.write(stk.pop() + " ");
        }
        
        bw.close();
        br.close();;


    }
  

}
