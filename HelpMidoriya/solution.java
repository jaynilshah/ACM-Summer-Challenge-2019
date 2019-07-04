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
        HelpMidoriya solver = new HelpMidoriya();
        solver.solve(1, in, out);
        out.close();
    }
 
    static class HelpMidoriya {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int a[] = new int[n];
            HashMap<Integer, Integer> map = new HashMap<>();
            int pre[] = new int[n + 1];
            int ans = 0;
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                pre[i + 1] = pre[i] ^ a[i];
 
                if (pre[i + 1] == 0) {
                    ans = i + 1;
                    continue;
                }
                if (!map.containsKey(pre[i + 1]))
                    map.put(pre[i + 1], i);
                if (map.containsKey(pre[i + 1])) {
                    ans = Math.max(i - map.get(pre[i + 1]), ans);
                }
            }
            if (ans == 1) {
                out.println(0);
                return;
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
