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
        AlphaWeb solver = new AlphaWeb();
        solver.solve(1, in, out);
        out.close();
    }
 
    static class AlphaWeb {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int diff = 0;
            char c;
            for (int i = 0; i < 2 * n - 1; i++) {
                for (int j = 0; j < 2 * n - 1; j++) {
                    if (i + j == (2 * n - 2) || j == (n - 1) || i == j) {
                        diff = Math.abs(n - 1 - i);
                        c = (char) (65 + diff);
                        out.print(c);
                    } else if (i == n - 1) {
                        diff = Math.abs(n - 1 - j);
                        c = (char) (65 + diff);
                        out.print(c);
 
                    } else {
                        out.print(" ");
                    }
 
                }
                out.println();
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
 