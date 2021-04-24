import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bruteforce_17089 {
    static int person[],n,m,ans;
    static boolean rel[][];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        person = new int[n];
        rel = new boolean[n][n];

        ans = -1;

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;

            person[a]++;
            person[b]++;

            rel[a][b] = true;
            rel[b][a] = true;
        }

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(rel[i][j]){
                    for(int k=j+1;k<n;k++){
                        if(rel[i][k] && rel[j][k]){
                            int sum = person[i]+person[j]+person[k];
                            if(ans == -1 || ans > sum-6)
                                ans = sum-6;
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
