import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Collections;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        LimitedEditionTShirts solver = new LimitedEditionTShirts();
        solver.solve(1, in, out);
        out.close();
    }
 
    static class LimitedEditionTShirts {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            ArrayList<String> s[] = new ArrayList[11];
            for (int i = 0; i < 11; i++) {
                s[i] = new ArrayList<String>();
            }
            int size[] = new int[11];
            for (int i = 0; i < n; i++) {
                String x = in.next();
                s[x.length() % 11].add(x);
                size[x.length() % 11]++;
            }
            for (int i = 1; i < 11; i++) {
                Collections.sort(s[i], Collections.reverseOrder());
            }
            int q = in.nextInt();
            while (q-- > 0) {
                int k = in.nextInt();
                for (int i = 1; i < 11; i++) {
                    if (k <= size[i]) {
                        out.println(s[i].get(k - 1));
                        break;
                    } else {
                        k = k - size[i];
                    }
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
