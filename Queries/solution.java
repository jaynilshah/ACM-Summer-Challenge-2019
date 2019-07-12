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
        QueriesHarderVersion solver = new QueriesHarderVersion();
        solver.solve(1, in, out);
        out.close();
    }
 
    static class QueriesHarderVersion {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int a[] = new int[n];
            long pre[] = new long[n + 1];
 
            for (int i = 0; i < n; i++) {
 
                a[i] = in.nextInt();
                pre[i + 1] = pre[i] + a[i];
            }
            int q = in.nextInt();
 
            int temp = 0;
            while (q-- > 0) {
                int type = in.nextInt();
                int l = in.nextInt();
                int r = in.nextInt();
                if (type == 2) {
                    out.println(pre[r] - pre[l - 1]);
                    continue;
                }
                for (int i = l; i <= (l + r) / 2; i++) {
                    temp = a[l + r - i - 1];
                    a[l + r - i - 1] = a[i - 1];
                    a[i - 1] = temp;
                }
                for (int i = l; i <= r; i++) {
                    pre[i] = pre[i - 1] + a[i - 1];
                }
 
            }
 
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