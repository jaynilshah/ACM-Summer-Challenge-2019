import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
 
public class Solution {
 
	public static void main(String[] args) throws FileNotFoundException, IOException{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		
		int n = in.nextInt();
		int k = in.nextInt();
		String x = in.next();
		
		long ans =0;
		long lc=0,rc=0;
		int l=0,r=0;
		int freq=0;
//		System.out.println(k);
//		for(int i=0;i<n;i++) {
//			if(x.charAt(i)=='1')
//				ans++;
//		}
		
		
		while( l<n && x.charAt(l)!='1') {
			l++;
			lc++;
		}
		r = l+1;
		if(l==n) {
			System.out.println(0);
			return;
		}
 
		while(freq!=k-1 && r<n) {
			if(x.charAt(r)=='1') {
				freq++;
			}
			r++;
		}
 
	
		if(freq!=k-1) {
			System.out.println(0);
			return;
		}
 
        while(l<n && r<=n) {
        	while(l<n &&  x.charAt(l)!='1' ) {
        		l++;
        		lc++;
        	}
        	if(l==n) {
    			System.out.println(ans);
    			return;
        	}
        	while(r<n && x.charAt(r)!='1') {
        		r++;
        		rc++;
        	}
        		ans = ans + (lc+1)*(rc+1);
            	
 
 
        	
        	l++;
        	r++;
        	lc=0;
        	rc=0;
        	
        }
        
		System.out.println(ans);
 
		
 
	}
 
}