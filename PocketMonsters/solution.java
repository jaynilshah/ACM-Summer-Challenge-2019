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
        PocketMonsters solver = new PocketMonsters();
        solver.solve(1, in, out);
        out.close();
    }
 
    static class PocketMonsters {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int q = in.nextInt();
            long dp[] = new long[100001];
            long mod = 1000000007;
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 3;
            for (int i = 3; i < 100001; i++) {
                dp[i] = (dp[i - 1] % mod + 2 * dp[i - 2] % mod) % mod;
            }
 
 
            for (int i = 0; i < q; i++) {
 
                out.println(dp[in.nextInt()]);
            }
//        out.println(dp[5]);
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
