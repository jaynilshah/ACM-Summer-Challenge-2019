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
        PlayWithXOR solver = new PlayWithXOR();
        solver.solve(1, in, out);
        out.close();
    }
 
    static class PlayWithXOR {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
 
            long n = in.nextLong();
            long q = in.nextLong();
            int count = 0;
 
            while (q-- > 0) {
 
                long l = in.nextLong();
                long r = in.nextLong();
                long lx = Maths.xor(l - 1);
                long rx = Maths.xor(r);
                out.println(lx ^ rx);
            }
 
//        out.println(count);
        }
 
    }
 
    static class Maths {
        static long xor(long n) {
            if (n % 4 == 0) return n;
            if (n % 4 == 1) return 1;
            if (n % 4 == 2) return n + 1;
            if (n % 3 == 0) return 0;
 
            return 0;
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
 
        public long nextLong() {
            return Long.parseLong(next());
        }
 
    }
}
