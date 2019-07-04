import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
 
/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Jaynil
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Lottery solver = new Lottery();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }
 
    static class Lottery {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            long ans = 0;
            if (n % 2 == 0 && n > 2) {
                out.println(2);
                return;
            }
 
            while (n != 0) {
                if (Maths.isPrime(n)) {
//                out.println(n);
                    ans = ans + 1;
                    break;
                }
                for (int i = n - 2; i >= 2; i--) {
 
                    if (Maths.isPrime(i)) {
//                    out.println(i);
                        n = n - i;
                        ans = ans + 1;
                        break;
                    }
                }
            }
 
//        for(int i=1;i<=n;i++){
//            if(Maths.isPrime(i) && Maths.isPrime(n-i)){
//                out.println(i + " " + (n-i));
//                break;
//            }
//        }
            out.println(ans);
        }
 
    }
 
    static class Maths {
        static boolean isPrime(int n) {
            if (n <= 1) return false;
            if (n <= 3) return true;
            if (n % 2 == 0 || n % 3 == 0) return false;
            for (int i = 5; i * i <= n; i = i + 6)
                if (n % i == 0 || n % (i + 2) == 0)
                    return false;
            return true;
        }
 
    }
 
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
 
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }
 
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
 
        public int nextInt() {
            return Integer.parseInt(next());
        }
 
    }
}
