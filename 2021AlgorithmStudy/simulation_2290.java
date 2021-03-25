import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class simulation_2290 {
    static int s,width,height,full;
    static String num, result[][];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        s = Integer.parseInt(st.nextToken());
        width = s+2;
        height = 2*s+3;

        num = st.nextToken();
        int sz = num.length();

        full = (width+1)*sz;
        result = new String[height][full];
        for(String a[]:result){
            Arrays.fill(a," ");
        }

        for(int i=0;i<sz;i++){
            switch(num.charAt(i)){
                case '1':
                    middle_up_right(i);
                    middle_down_right(i);
                    break;
                case'2':
                    up(i);
                    middle_up_right(i);
                    middle(i);
                    middle_down_left(i);
                    down(i);
                    break;
                case'3':
                    up(i);
                    middle_up_right(i);
                    middle(i);
                    middle_down_right(i);
                    down(i);
                    break;
                case'4':
                    middle_up_left(i);
                    middle_up_right(i);
                    middle(i);
                    middle_down_right(i);
                    break;
                case'5':
                    up(i);
                    middle_up_left(i);
                    middle(i);
                    middle_down_right(i);
                    down(i);
                    break;
                case'6':
                    up(i);
                    middle_up_left(i);
                    middle(i);
                    middle_down_right(i);
                    middle_down_left(i);
                    down(i);
                    break;
                case'7':
                    up(i);
                    middle_up_right(i);
                    middle_down_right(i);
                    break;
                case'8':
                    up(i);
                    middle_up_left(i);
                    middle_up_right(i);
                    middle(i);
                    middle_down_right(i);
                    middle_down_left(i);
                    down(i);
                    break;
                case'9':
                    up(i);
                    middle_up_left(i);
                    middle_up_right(i);
                    middle(i);
                    middle_down_right(i);
                    down(i);
                    break;
                case'0':
                    up(i);
                    middle_up_left(i);
                    middle_up_right(i);
                    middle_down_right(i);
                    middle_down_left(i);
                    down(i);
                    break;

            }
        }
        Print();
    }


    private static void Print() {
        for(int i=0;i<height;i++){
            for(int j=0;j<full;j++)
                System.out.print(result[i][j]);
            System.out.println();
        }
    }


    static void up(int idx){
        //맨위 라인 있음
       for(int j=1;j<=s;j++){
           result[0][j+(idx*(width+1))] = "-";
       }
    }

    static void middle_up_left(int idx){
        //중상 라인 왼쪽
        for(int j=1;j<=s;j++){
            result[j][0+(idx*(width+1))] = "|";
        }
    }

    static void middle_up_right(int idx){
        //중상라인 오른쪽
        for(int j=1;j<=s;j++){
            result[j][width-1+(idx*(width+1))] = "|";
        }
    }

    static void middle(int idx){
        //가운데 가로
        for(int j=1;j<=s;j++){
            result[height/2][j+(idx*(width+1))] = "-";
        }
    }

    static void middle_down_left(int idx){
        //중하라인 왼쪽
        for(int j=height/2+1;j<height-1;j++){
            result[j][0+(idx*(width+1))] = "|";
        }
    }

    static void middle_down_right(int idx){
        //중하 라인 오른쪽
        for(int j = height/2+1;j<height-1;j++){
            result[j][width-1+(idx*(width+1))] = "|";
        }
    }

    static void down(int idx){
        //맨 밑
        for(int j=1;j<=s;j++){
            result[height-1][j+(idx*(width+1))] = "-";
        }
    }
}
