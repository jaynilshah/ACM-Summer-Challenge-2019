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
        ConwaysGameOfLife solver = new ConwaysGameOfLife();
        solver.solve(1, in, out);
        out.close();
    }
 
    static class ConwaysGameOfLife {
        public void sol(long red[], long blue[]) {
            red[1] = 1;
            blue[1] = 1;
 
            for (int i = 2; i <= 61; i++) {
                red[i] = red[i - 1] + blue[i - 1];
                blue[i] = 2 * red[i - 1];
            }
        }
 
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            long red[] = new long[62];
            long blue[] = new long[62];
            sol(red, blue);
            while (t-- > 0) {
                int n = in.nextInt();
                out.println(red[n] + blue[n] + red[n - 1] + blue[n - 1]);
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
