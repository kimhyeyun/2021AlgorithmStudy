import java.util.Scanner;
import java.util.Vector;

public class bruteforce_16936 {
    static int n;
    static long arr[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        arr = new long[n];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextLong();
        }

        for(int i=0;i<n;i++){
            //idx 0~n-1를 시작점으로 해서 확인
            Vector<Long> v = new Vector<>();

            v.add(arr[i]);

            while(true){
                if(v.size() == n){
                    for(int j=0;j<v.size();j++){
                        System.out.print(v.elementAt(j)+" ");
                    }
                    System.out.println();
                    return;
                }
                boolean flag = false;

                //*2한 값 존재여부 확인
                if(check(v.elementAt(v.size()-1)*2)){
                    flag = true;
                    v.add(v.elementAt(v.size()-1)*2);
                }

                //3으로 나눈 나머지 값이 0일때 
                if(v.elementAt(v.size()-1)%3 == 0){
                    //3으로 나눈 값 존재여부 확인
                    if(check(v.elementAt(v.size()-1)/3)){
                        flag = true;
                        v.add(v.elementAt(v.size()-1)/3);
                    }
                }

                //숫자가 존재하지않으므로 시작점 변경
                if(!flag)
                    break;
            }
        }
    }

    //존재여부확인
    private static boolean check(long num){
        for(int i=0;i<n;i++){
            if(arr[i] == num)
                return true;
        }
        return false;
    }

}
