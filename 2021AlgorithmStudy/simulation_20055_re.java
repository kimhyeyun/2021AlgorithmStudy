import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class simulation_20055_re {
    static int belt[];
    static boolean robot[];
    static int n,k;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        belt = new int[2*n];
        robot = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<2*n;i++){
            belt[i] = Integer.parseInt(st.nextToken());
        }

        int cnt=0;
        while(true){
            cnt++;
            beltMove();
            robotMove();
            if(isEnd()){
                System.out.println(cnt);
                break;
            }
        }
    }

    private static boolean isEnd() {
        int c = 0;
        for(int i=0;i<2*n;i++){
            if(belt[i] == 0)
                c++;
            if(c==k)
                return true;
        }

        return false;
    }

    private static void robotMove() {
        //내려가는 위치에 로봇이 있으면 내림
        if(robot[n-1])
            robot[n-1] = false;
        
        //로봇이 있는데, 앞에 로봇이 없고 내구도가 1이상이면
        for(int i=n-2;i>=0;i--){
            if(robot[i] && !robot[i+1] && belt[i+1]>0){
                robot[i] = false;
                robot[i+1] = true;
                belt[i+1]--;
            }
        }
        //올라가는 위치에 로봇이 없으면 올림
        if(!robot[0] && belt[0] > 0){
            robot[0] = true;
            belt[0]--;
        }
            
    }

    //컨베이너 벨트 이동
    private static void beltMove() {
        int tmp = belt[2*n-1];
        for(int i=2*n-1;i>0;i--){
            belt[i] = belt[i-1];
        }
        belt[0] = tmp;
        
        //벨트가 움직이면 그위의 로봇들도 바뀌기때문에 이동
        for(int i=n-1;i>0;i--){
            robot[i] = robot[i-1];
        }
        //n-1위치에서 내려야히기 때문에 이동 후에는 0에는 로봇이 존재 하지않음
        robot[0] = false;
    }
}
