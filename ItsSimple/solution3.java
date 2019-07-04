import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
 
public class Solu {
    static int __gcd(int a, int b)
    {
        if (b == 0)
            return a;
        return __gcd(b, a % b);
 
    }
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO Auto-generated method stub
			Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0){
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();
            long max = -1;
            for(int i=1;i*i<=n;i++){
                if(n%i==0){
                    int part = n/i;
                    if(__gcd(m,i)>k){
                        max = Math.max(max,i);
                    }
                    if(part!=n){
                        if(__gcd(m,part)>k){
                            max = Math.max(max,part);
                        }
                    }
                }
            }
            System.out.println(max);
        }
 
    }
}
