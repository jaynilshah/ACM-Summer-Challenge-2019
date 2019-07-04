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
        JokerThief solver = new JokerThief();
        solver.solve(1, in, out);
        out.close();
    }
 
    static class JokerThief {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            HashMap<Long, Long> alice = new HashMap<>();
            HashMap<Long, Long> bob = new HashMap<>();
            int n = in.nextInt();
            long a[] = new long[n];
            long b[] = new long[n];
            long al = 0;
            long bo = 0;
            int mod = 1000000007;
            for (int i = 0; i < n; i++) {
                a[i] = in.nextLong();
                if (alice.containsKey(a[i])) {
                    alice.put(a[i], alice.get(a[i]) + 1);
                    continue;
                } else {
                    alice.put(a[i], (long) 1);
                }
            }
            for (int i = 0; i < n; i++) {
                b[i] = in.nextLong();
                if (bob.containsKey(b[i])) {
                    bob.put(b[i], bob.get(b[i]) + 1);
                    continue;
                } else {
                    bob.put(b[i], (long) 1);
                }
            }
            for (int i = 0; i < n; i++) {
                if (alice.get(a[i]) % 2 == 1) {
                    al = al + a[i];
                    alice.put(a[i], (long) 0);
                }
            }
            for (int i = 0; i < n; i++) {
                if (bob.get(b[i]) % 2 == 1) {
                    bo = bo + b[i];
                    bob.put(b[i], (long) 0);
                }
            }
            al = al % mod;
            bo = bo % mod;
            out.println(al % mod);
            out.println(bo % mod);
            if (al == bo) {
                out.println("Tie");
            } else if (al > bo) {
                out.println("Alice");
            } else {
                out.println("Bob");
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
 
        public long nextLong() {
            return Long.parseLong(next());
        }
 
    }
}
