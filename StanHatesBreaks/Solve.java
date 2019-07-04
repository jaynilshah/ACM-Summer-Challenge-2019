import java.util.Scanner;
 
public class Solve {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
       
        while(input.hasNext()){
            String x = input.next();
            System.out.print(x);
            if(input.hasNext())
            System.out.print( "\\" );
 
        }
    }
}
