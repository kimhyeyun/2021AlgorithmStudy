import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class simulation_14890_re {
    static int n, l, map[][];
    static boolean stairs[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 가로부터
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int sero[] = new int[n];
            if (isPossible(map[i]))
                cnt++;

            //세로
            for(int j=0;j<n;j++){
                sero[j] = map[j][i];
            }
            if(isPossible(sero))
                cnt++;
        }

        System.out.println(cnt);
    }

    private static boolean isPossible(int[] arr) {
        stairs = new boolean[n];
        int idx = 0;

        while(idx<n-1) {

            if (arr[idx+1] == arr[idx])
                idx++;

            else if (Math.abs(arr[idx+1] - arr[idx]) > 1)
                return false;

            // 올라가는 경사
            else if (arr[idx+1] > arr[idx]) {
                if (idx - l + 1 >= 0) {
                        // 경사로를 놓을 길들의 높이가 같은지 확인
                        //올라가는 경사라 idx 위치와 경사로를 놓을 위치들의 높이가 같아야하고
                        //idx 위치에도 이전에 경사로 존재를 확인해야함
                        for (int j = idx - l + 1; j <= idx; j++) {
                            if (arr[j]!=arr[idx]|| stairs[j])
                                return false;
                        }
                        idx++;
                    
                }
                else
                    return false;
            }

            // 내려가는 경사
            else {
                if (idx + l + 1 > n)
                    return false;
                else {
                    for (int j = idx + 1; j <= idx + l; j++) {
                        stairs[j] = true;
                        if (arr[j] != arr[idx]-1)
                            return false;
                        
                    }
                    idx = idx + l;
                }
            }
        }

        return true;
    }
}


