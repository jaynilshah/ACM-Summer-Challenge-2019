import java.util.Scanner;
 
public class Solve {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
       
        int n = input.nextInt();
        int sum =0;
        String x = input.next();
        for(int i=0;i<n;i++)sum += x.charAt(i)-48;
        if(sum%3==0) 
            System.out.println("YES"); 
        else 
            System.out.println("NO");
    }
}
