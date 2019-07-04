import java.util.Scanner;
 
public class Solve {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        
        int n = input.nextInt();
        String x = input.next();
        int r=0,b=0;
        for(int i=0;i<n;i++) if(x.charAt(i)=='R') r++;else b++;
        int count =0;
        for(int i=0;i<n;i++){
            if(x.charAt(i)=='R'){
                r--;
                
            }
            else{
                b--;
            }
            count++;
            if(r==0 || b==0){
                break;
            }
                
        }
        System.out.println(count);
        
    }
}
