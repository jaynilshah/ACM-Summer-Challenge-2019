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
        Numtrix solver = new Numtrix();
        solver.solve(1, in, out);
        out.close();
    }
 
    static class Numtrix {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            int a[][] = new int[n + 2][m + 2];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    a[i][j] = in.nextInt();
                }
            }
            int count = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (Maths.gcd(a[i - 1][j], a[i][j]) != 1 && Maths.gcd(a[i][j - 1], a[i][j]) != 1 && Maths.gcd(a[i + 1][j], a[i][j]) != 1 && Maths.gcd(a[i][j + 1], a[i][j]) != 1) {
                        count++;
                    }
                }
            }
            out.println(count);
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
 
    static class Maths {
        static int gcd(int a, int b) {
            if (a == 0) {
                return b;
            }
            if (b == 0) {
                return a;
            }
 
            while (a != b) {
                if (a > b)
                    a = a - b;
                else
                    b = b - a;
            }
            return a;
        }
 
    }
}
