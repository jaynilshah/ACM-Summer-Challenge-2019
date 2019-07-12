import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
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
        ChrissyAndChocolates solver = new ChrissyAndChocolates();
        solver.solve(1, in, out);
        out.close();
    }
 
    static class ChrissyAndChocolates {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int k = in.nextInt();
            String x = in.next();
            Integer pre[] = new Integer[n + 1];
            Arrays.fill(pre, 0);
            for (int i = 0; i < n; i++) {
                if (x.charAt(i) == '1') {
                    pre[i + 1] = pre[i] + 1;
                } else {
                    pre[i + 1] = pre[i];
                }
            }
            long ans = 0;
 
            for (int i = 1; i <= n; i++) {
                int ll = CustomList.lowerBound(Arrays.asList(pre), 0, n + 1, pre[i - 1] + k);
                int ul = CustomList.upperBound(Arrays.asList(pre), 0, n + 1, pre[i - 1] + k);
                ans = ans + (ul - ll);
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
 
    static class CustomList {
        public static int lowerBound(List<Integer> a, int low, int high, int element) {
            while (low < high) {
                int middle = low + (high - low) / 2;
                if (element > a.get(middle))
                    low = middle + 1;
                else
                    high = middle;
            }
            return low;
        }
 
        public static int upperBound(List<Integer> a, int low, int high, int element) {
            while (low < high) {
                int middle = low + (high - low) / 2;
                if (a.get(middle) > element)
                    high = middle;
                else
                    low = middle + 1;
            }
            return low;
        }
 
    }
}
 