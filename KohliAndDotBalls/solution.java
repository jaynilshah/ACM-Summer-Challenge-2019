import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.HashMap;
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
        KohliAndDotBalls solver = new KohliAndDotBalls();
        solver.solve(1, in, out);
        out.close();
    }
 
    static class KohliAndDotBalls {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int a[] = new int[n];
            double[] ans = new double[n + 1];
            HashMap<Double, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            ans[0] = 0;
            int max = 0;
            map.put(0.0, 0);
            for (int i = 1; i <= n; i++) {
                if (a[i - 1] == 0) {
                    ans[i] = ans[i - 1] + -1;
                } else {
                    ans[i] = ans[i - 1] + (double) 0.5;
                }
                if (map.containsKey(ans[i])) {
                    max = Math.max(max, i - map.get(ans[i]));
                } else {
                    map.put(ans[i], i);
                }
            }
            out.println(max);
 
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
