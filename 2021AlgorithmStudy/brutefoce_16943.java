import java.util.Scanner;

public class brutefoce_16943 {
    static int a,b,ans;
    static String astr, c;
    static boolean visited[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        c = "";
        ans = -1;

        astr = Integer.toString(a);
        visited = new boolean[astr.length()];

        DFS(0);

        System.out.println(ans);
    }

    private static void DFS(int size) {
        if(size == astr.length()){
            if((Integer.parseInt(c)) < b){
                ans = Math.max(ans,Integer.parseInt(c));
            }
            return;
        }

        for(int i=0;i<astr.length();i++){
            if(size == 0 && astr.charAt(i) == '0')
                continue;
            if(!visited[i]){
                visited[i]=true;
                c+=astr.charAt(i);
                DFS(size+1);
                c=c.substring(0,c.length()-1);
                visited[i]=false;
            }
        }
    }


}
