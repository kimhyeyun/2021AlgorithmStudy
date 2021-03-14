import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class simulation_15662 {
    static int t,k;
    static int gear[][];
    static int gearR[];
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken());
        
        gear = new int[t][8];
        gearR = new int[t];

        for(int i=0;i<t;i++){
            String str = br.readLine();
            for(int j=0;j<8;j++){
                gear[i][j] = str.charAt(j)-'0';
            }
        }

        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());

        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            num = num-1;
            int dir = Integer.parseInt(st.nextToken());
            gearR[num]  = dir;
            //gearR : 안돌리냐 돌리면 무슨방향?
            
            //오른쪽 확인
            for(int g=num;g<t-1;g++){
                if(gear[g][2] == gear[g+1][6])
                    gearR[g+1] = 0;
                else
                    gearR[g+1] = gearR[g]*-1;
            }

            //왼쪽 확인
            for(int g=num;g>0;g--){
                if(gear[g][6] == gear[g-1][2])
                    gearR[g-1] = 0;
                else   
                    gearR[g-1] = gearR[g]*-1;
            }

            for(int start = 0; start<t;start++){
                if(gearR[start] == -1)
                    RotateLeft(start);
                else if(gearR[start]==1)
                    RotateRight(start);
            }
            
        }

        int cnt = 0;
        for(int i=0;i<t;i++){
            if(gear[i][0] == 1)
                cnt++;
        }

        System.out.println(cnt);

        br.close();
    }

    private static void RotateLeft(int num) {
        int tmp = gear[num][0];
        for(int i=0;i<7;i++)
            gear[num][i] = gear[num][i+1];

        gear[num][7] = tmp;
    }

    private static void RotateRight(int num) {
        int tmp = gear[num][7];
        for(int i=7;i>0;i--)
            gear[num][i] = gear[num][i-1];

        gear[num][0] = tmp;
    }
}
