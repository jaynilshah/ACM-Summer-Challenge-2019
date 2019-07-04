import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Vector;
import java.util.StringTokenizer;
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
        LastDay solver = new LastDay();
        solver.solve(1, in, out);
        out.close();
    }
 
    static class LastDay {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
 
            ArrayList<Integer> list[] = new ArrayList[n + 1];
            int level[] = new int[n + 2];
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i = 0; i < n; i++) {
                list[i + 1] = new ArrayList<Integer>();
            }
            Arrays.fill(level, Integer.MAX_VALUE);
            for (int i = 0; i < n - 1; i++) {
                int u = in.nextInt();
                int v = in.nextInt();
                list[u].add(v);
                list[v].add(u);
            }
            Stack<Integer> s = new Stack<>();
            Stack<Integer> lev = new Stack<>();
            s.push(1);
            lev.push(0);
            map.put(1, 0);
            while (!s.isEmpty()) {
                int val = s.pop();
                int l = lev.pop();
                for (int i = 0; i < list[val].size(); i++) {
                    if (map.containsKey(list[val].get(i))) {
                        continue;
                    }
                    s.push(list[val].get(i));
                    lev.push(l + 1);
                    map.put(list[val].get(i), l + 1);
                    level[l + 1] = Math.min(level[l + 1], val + list[val].get(i));
                }
 
            }
            int i = 1;
            long sum[] = new long[n + 1];
            while (level[i] != Integer.MAX_VALUE) {
                sum[i] = sum[i - 1] + (long) level[i];
                i++;
            }
            int q = in.nextInt();
            while (q-- > 0) {
                int p = in.nextInt();
                int t = in.nextInt();
                p = map.get(p);
                t = map.get(t);
                int min = (int) Math.min(p, t);
                int max = (int) Math.max(p, t);
                out.println(sum[max] - sum[min]);
            }
//        Array.print(level);
 
 
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
