import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class simulation_15662_re {
    
    static int t,k;
    static int Gear[][], isRotate[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken());
        Gear = new int[t][8];
        
        for(int i=0;i<t;i++){
            String str = br.readLine();
            for(int j=0;j<8;j++){
                Gear[i][j] = str.charAt(j) - '0';
            }
        }

        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());

        for(int i=0;i<k;i++){
            isRotate = new int[t];
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());

            num = num - 1;
            int dir = Integer.parseInt(st.nextToken());
            isRotate[num] = dir; 
            
            //num 기준 왼쪽의 회전여부 확인
            for(int j=num;j>0;j--){
                if(Gear[j][6]!=Gear[j-1][2])
                    isRotate[j-1] = isRotate[j]*-1;
                else
                    isRotate[j-1] = 0; 

            }

            //num 기준 오른쪽의 회전여부 확인
            for(int j=num;j<t-1;j++){
                if(Gear[j][2]!=Gear[j+1][6])
                    isRotate[j+1] = isRotate[j]*-1;
                else    
                    isRotate[j+1] = 0;
            }

            SpinGear();
        }

        Print();
    
    }

    private static void Print() {
        int cnt = 0;
        for(int i=0;i<t;i++){
            if(Gear[i][0] ==1)
                cnt++;
        }
        System.out.println(cnt);
    }

    //회전시키기
    private static void SpinGear() {
        for(int n=0;n<t;n++){
            //시계방향
            if(isRotate[n] == 1){
                int tmp = Gear[n][7];
                for(int j=7;j>0;j--){
                    Gear[n][j] = Gear[n][j-1];
                }
                Gear[n][0] = tmp;
            }

            //반시계방향
            if(isRotate[n] == -1){
                int tmp = Gear[n][0];
                for(int j=0;j<7;j++){
                    Gear[n][j] = Gear[n][j+1];
                }
                Gear[n][7] = tmp;
            }
        }
    }
}
