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
        Chapter85TheBasement solver = new Chapter85TheBasement();
        solver.solve(1, in, out);
        out.close();
    }
 
    static class Chapter85TheBasement {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            int extra = m % 3;
            int all = m / 3;
            long ans = 0;
            for (int i = 1; i <= n; i++) {
                int temp = i % 3;
                ans += all;
                if (extra == 1) {
                    if ((i + all * 3 + 1) % 3 == 0) {
                        ans++;
                    }
 
                } else if (extra == 2) {
                    if ((i + all * 3 + 1) % 3 == 0) {
                        ans++;
                    }
                    if ((i + all * 3 + 2) % 3 == 0) {
                        ans++;
                    }
 
                }
            }
            out.println(ans);
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