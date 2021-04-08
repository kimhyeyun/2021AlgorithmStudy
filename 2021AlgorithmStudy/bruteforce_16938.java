    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.StringTokenizer;
    import java.util.Vector;

    public class bruteforce_16938 {
        static int n,l,r,x,maxi,mini,ans;
        static int a[];
        static boolean visited[];
        static Vector<Integer> v;
        
        public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            v = new Vector<>();

            n = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());

            a = new int[n];
            visited = new boolean[n];

            st = new StringTokenizer(br.readLine());

            for(int i=0;i<n;i++){
                a[i] = Integer.parseInt(st.nextToken());
            }

            DFS(0,0,0);

            System.out.println(ans);
        }

        private static void DFS(int idx, int cnt, int sum) {
            if(cnt >= 2){
                maxi = Integer.MIN_VALUE;
                mini = Integer.MAX_VALUE;

                for(int a =0;a<v.size();a++){
                    maxi = Math.max(maxi, v.elementAt(a));
                    mini = Math.min(mini,v.elementAt(a));
                }

                if(maxi-mini >= x && l <= sum && sum <= r)
                    ans++;

            }

            for(int i=idx;i<n;i++){
                if(!visited[i] && a[i]+sum <= r){
                    visited[i] = true;
                    v.add(a[i]);
                    DFS(i,cnt+1,a[i]+sum);
                    v.removeElementAt(v.size()-1);
                    visited[i] = false;
                }
            }
        }
        
    }
