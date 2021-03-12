import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 시뮬레이션_20055 {
    static int n,k,belt[];
    static boolean robot[];
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());

       n = Integer.parseInt(st.nextToken());
       k = Integer.parseInt(st.nextToken());

       belt = new int[2*n];
       robot = new boolean[n];

       st = new StringTokenizer(br.readLine());
       for(int i=0;i<2*n;i++)
            belt[i] = Integer.parseInt(st.nextToken());


        int cnt = 0;

        while(true){
            MoveBelf();
            cnt++;
            MoveRobot();
            
            if(isEnd()){
                System.out.println(cnt);
                break;
            }
            
        }
    }

    private static boolean isEnd() {
        int count = 0;
        for(int i=0;i<belt.length;i++){
            if(belt[i] == 0)
                count++;

            if(count == k)
                return true;
        }
        return false;
    }

    //로봇이동
    private static void MoveRobot() {
        //내려가야하는 위치
        if(robot[n-1])
            robot[n-1] = false;

        for(int i=n-2;i>-1;i--){
            if(robot[i] && !robot[i+1] && belt[i+1] > 0){
                robot[i+1] = true;
                robot[i] = false;
                belt[i+1]--;
            }
        }

        //올라가도되는 위치
        if(belt[0]>0 && !robot[0]){
            robot[0]=true;
            belt[0]--;
        }
    }

    //belf가 회전하기에 각 내구도와 로봇의 유무를 바꿔줌
    private static void MoveBelf() {
        int end = belt[belt.length-1];
        for(int i=belt.length-2;i>-1;i--)
            belt[i+1] = belt[i];

        belt[0] = end;

        for(int i=n-2;i>-1;i--){
            robot[i+1] = robot[i];
        }

        robot[0] = false;
        //로봇은 n-1위치에서 무조건 내려야해서 0에는 로봇이 오르기만하지 없다
    }


}
