import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.Map.Entry;
import java.io.BufferedReader;
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
        DeDust2 solver = new DeDust2();
        solver.solve(1, in, out);
        out.close();
    }
 
    static class DeDust2 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            HashMap<Long, Long> map = new HashMap<>();
            HashMap<Long, Long> mapy = new HashMap<>();
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                long x = in.nextInt();
                long y = in.nextInt();
                if (map.containsKey(y - x)) {
                    map.put(y - x, map.get(y - x) + 1);
                } else {
                    map.put((y - x), (long) 1);
                }
 
                if (mapy.containsKey(y + x)) {
                    mapy.put(x + y, mapy.get(y + x) + 1);
                } else {
                    mapy.put(y + x, (long) 1);
                }
 
            }
            long ans = 0;
            for (Map.Entry element : map.entrySet()) {
 
                long temp = (long) element.getValue();
                ans = ans + (temp * (temp - 1)) / 2;
            }
            for (Map.Entry element : mapy.entrySet()) {
 
                long temp = (long) element.getValue();
                ans = ans + (temp * (temp - 1)) / 2;
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
