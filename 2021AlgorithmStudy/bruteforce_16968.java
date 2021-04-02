import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class bruteforce_16968 {
    static String form;

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       form = sc.nextLine();

       int ans = 1;

       if(form.charAt(0) == 'd')
            ans *= 10;
        else
            ans *= 26;
       for(int i=1;i<form.length();i++){
            int ok = 0;
            if(form.charAt(i-1) == form.charAt(i))
                ok = 1;
            if(form.charAt(i) == 'd')
                ans*=(10-ok);
            if(form.charAt(i) == 'c')
                ans *= (26-ok);
       }

       System.out.println(ans);
    }
}
